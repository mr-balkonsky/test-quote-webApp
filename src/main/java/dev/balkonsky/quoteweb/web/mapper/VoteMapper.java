package dev.balkonsky.quoteweb.web.mapper;

import dev.balkonsky.quoteweb.model.entity.Vote;
import dev.balkonsky.quoteweb.web.dto.VoteDto;
import org.mapstruct.Mapper;

public interface VoteMapper extends Mappable<Vote, VoteDto> {
}
