package com.salihpolat.service;

import com.salihpolat.dto.response.PostDto;
import com.salihpolat.exception.BadRequestException;
import com.salihpolat.exception.InternalServerErrorException;
import com.salihpolat.exception.ResourceNotFoundException;
import com.salihpolat.mapper.IPostMapper;
import com.salihpolat.model.Post;
import com.salihpolat.repository.IPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final IPostRepository postRepository;

    public List<PostDto> findAll() {

        try {

            return IPostMapper.INSTANCE.postListToPostDtoList(postRepository.findAll());

        } catch (DataAccessException e) {

            throw new InternalServerErrorException("An error occurred while fetching categories");

        }
    }

    public PostDto findById(Long id) {

        if (id <= 0) {
            throw new BadRequestException("Invalid post ID: " + id);
        }

        Optional<Post> postOptional = postRepository.findById(id);

        if (postOptional.isEmpty()) {
            throw new ResourceNotFoundException("Post not found with ID: " + id);
        }

        PostDto postDto = IPostMapper.INSTANCE.postToPostDto(postRepository.findById(id).get());

        return postDto;
    }

    public PostDto save(Post post) {

        try {

            if (post == null) {
                throw new BadRequestException("Post cannot be null");
            }

            PostDto postDto = IPostMapper.INSTANCE.postToPostDto(postRepository.save(post));

            return postDto;

        } catch (Exception e) {

            throw new InternalServerErrorException("An error occurred while saving post");

        }
    }

    public void deleteById(Long id) {

        Optional<Post> post = postRepository.findById(id);

        try {

            if (post.isEmpty()) {
                throw new ResourceNotFoundException("Post not found with ID: " + id);
            }

            postRepository.deleteById(id);

        } catch (Exception e) {

            throw new InternalServerErrorException("An error occurred while deleting post");

        }
    }

    public List<PostDto> findPostsByUserId(Long id) {
        List<PostDto> posts = IPostMapper.INSTANCE.postListToPostDtoList(postRepository.findPostsByUserId(id));

        if (posts.isEmpty()) {

            throw new ResourceNotFoundException("No posts found for user with id: " + id);

        }

        return posts;
    }

    public List<PostDto> findPostsByCategoryId(Long id) {

        List<PostDto> posts = IPostMapper.INSTANCE.postListToPostDtoList(postRepository.findPostsByCategoryId(id));

        if (posts.isEmpty()) {
            throw new ResourceNotFoundException("No posts found for category with id: " + id);
        }

        return posts;
    }
}