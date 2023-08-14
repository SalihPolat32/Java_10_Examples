package com.salihpolat.service;

import com.salihpolat.dto.request.PostRequestDto;
import com.salihpolat.dto.response.PostDto;
import com.salihpolat.exception.BadRequestException;
import com.salihpolat.exception.InternalServerErrorException;
import com.salihpolat.exception.ResourceNotFoundException;
import com.salihpolat.mapper.IPostMapper;
import com.salihpolat.model.Category;
import com.salihpolat.model.Post;
import com.salihpolat.model.User;
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

    private final CategoryService categoryService;

    private final UserService userService;

    public List<PostDto> findAll() {

        try {

            return IPostMapper.INSTANCE.postListToPostDtoList(postRepository.findAll());

        } catch (DataAccessException e) {

            throw new InternalServerErrorException("An Error Occurred While Fetching Categories");

        }
    }

    public PostDto findById(Long id) {

        if (id <= 0) {
            throw new BadRequestException("Invalid Post ID: " + id);
        }

        Optional<Post> postOptional = postRepository.findById(id);

        if (postOptional.isEmpty()) {
            throw new ResourceNotFoundException("Post Not Found With ID: " + id);
        }

        PostDto postDto = IPostMapper.INSTANCE.postToPostDto(postRepository.findById(id).get());

        return postDto;
    }

    public PostDto save(PostRequestDto postRequestDto, Long userId, Long categoryId) {

        if (postRequestDto == null) {
            throw new BadRequestException("Post Cannot Be null");
        }

        User user = userService.getById(userId);

        if (user == null) {
            throw new ResourceNotFoundException("User Does Not Exist");
        }

        Category category = categoryService.getById(categoryId);

        if (category == null) {
            throw new ResourceNotFoundException("Category Does Not Exist");
        }

        Post post = IPostMapper.INSTANCE.postRequestDtoToPost(postRequestDto);

        post.setUser(user);

        post.setCategory(category);

        Post savedPost = postRepository.save(post);

        if (savedPost == null) {
            throw new InternalServerErrorException("An Error Occurred While Saving Post");
        }

        return IPostMapper.INSTANCE.postToPostDto(savedPost);
    }

    public PostDto update(PostDto postDto, Long id, Long userId, Long categoryId) {
        try {

            User user = userService.getById(userId);

            if (user == null) {
                throw new BadRequestException("User Does Not Exist");
            }

            Category category = categoryService.getById(categoryId);

            if (category == null) {

                throw new BadRequestException("Category Does Not Exist");
            }

            postDto.setId(id);

            Post post = IPostMapper.INSTANCE.postDTOToPost(postDto);

            post.setUser(user);

            post.setCategory(category);

            Post savedPost = postRepository.save(post);

            if (savedPost == null) {
                throw new InternalServerErrorException("An Error Occurred While Saving Post");
            }

            return IPostMapper.INSTANCE.postToPostDto(savedPost);

        } catch (Exception e) {

            throw new InternalServerErrorException("An Error Occurred While Saving Post: " + e);

        }
    }

    public void deleteById(Long id) {

        Optional<Post> post = postRepository.findById(id);

        try {

            if (post.isEmpty()) {
                throw new ResourceNotFoundException("Post Not Found With ID: " + id);
            }

            postRepository.deleteById(id);

        } catch (Exception e) {

            throw new InternalServerErrorException("An Error Occurred While Deleting Post");

        }
    }

    public List<PostDto> findPostsByUserId(Long id) {

        List<PostDto> posts = IPostMapper.INSTANCE.postListToPostDtoList(postRepository.findPostsByUserId(id));

        if (posts.isEmpty()) {

            throw new ResourceNotFoundException("No Posts Found For User With ID: " + id);

        }

        return posts;
    }

    public List<PostDto> findPostsByCategoryId(Long id) {

        List<PostDto> posts = IPostMapper.INSTANCE.postListToPostDtoList(postRepository.findPostsByCategoryId(id));

        if (posts.isEmpty()) {
            throw new ResourceNotFoundException("No Posts Found For Category With ID: " + id);
        }

        return posts;
    }

    public List<PostDto> findPostsByCategory(String category) {

        return IPostMapper.INSTANCE.postListToPostDtoList(postRepository.getPostsByCategoryCategoryName(category));
    }

    public List<PostDto> findPostsByContentContains(String search) {

        return IPostMapper.INSTANCE.postListToPostDtoList(postRepository.getPostsByContentContainingIgnoreCase(search));
    }
}