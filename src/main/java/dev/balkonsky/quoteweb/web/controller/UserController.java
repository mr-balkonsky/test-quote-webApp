package dev.balkonsky.quoteweb.web.controller;
import com.auth0.jwt.exceptions.TokenExpiredException;
import dev.balkonsky.quoteweb.security.jwt.JwtDecoder;
import dev.balkonsky.quoteweb.service.UserService;
import dev.balkonsky.quoteweb.web.dto.UserDto;
import dev.balkonsky.quoteweb.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final JwtDecoder jwtDecoder;
    private final BCryptPasswordEncoder encoder;

    @PostMapping("")
    public ResponseEntity<String> createUser(@RequestBody UserDto dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        var user = userMapper.toEntity(dto);
        userService.save(user);
        return ResponseEntity.ok("User created");
    }

    @GetMapping("/user")
    public ResponseEntity<UserDto> getUser(@RequestHeader("Authorization") String token) {
        var email = jwtDecoder.decode(token).getClaim("e").asString();
        var user = userService.findByEmail(email).orElseThrow();
        var userDto = userMapper.toDto(user);
        userDto.setPassword("");
        return ResponseEntity.ok(userDto);
    }

}
