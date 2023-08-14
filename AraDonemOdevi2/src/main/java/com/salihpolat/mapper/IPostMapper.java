package com.salihpolat.mapper;

import com.salihpolat.dto.request.PostRequestDto;
import com.salihpolat.dto.response.PostDto;
import com.salihpolat.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPostMapper {
    IPostMapper INSTANCE = Mappers.getMapper(IPostMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "category.id", target = "categoryId")
    PostDto postToPostDto(Post post);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "category.id", target = "categoryId")
    List<PostDto> postListToPostDtoList(List<Post> postList);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "categoryId", target = "category.id")
    Post postDTOToPost(PostDto postDto);

    Post postRequestDtoToPost(PostRequestDto postRequestDto);
/*
    PostRequestDto postToPostRequestDto(Post post);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "categoryId", target = "category.id")
    List<Post> postDtoListToPostList(List<PostDto> postDtoList);
*/
}