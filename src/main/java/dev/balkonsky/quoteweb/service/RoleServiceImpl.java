package dev.balkonsky.quoteweb.service;

import dev.balkonsky.quoteweb.model.entity.Role;
import dev.balkonsky.quoteweb.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleRepository {

    private final RoleRepository roleRepository;

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleRepository.getRoleByRoleName(roleName);
    }
}
