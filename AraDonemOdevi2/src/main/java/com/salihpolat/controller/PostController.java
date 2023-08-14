package com.salihpolat.controller;

import com.salihpolat.dto.request.PostRequestDto;
import com.salihpolat.dto.response.PostDto;
import com.salihpolat.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.salihpolat.constant.RestApiUrl.POST;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping(POST)
    public ResponseEntity<List<PostDto>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping(POST + "/{postId}")
    public ResponseEntity<PostDto> findById(@PathVariable(name = "postId") Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping(POST)
    public ResponseEntity<PostDto> save(@RequestBody PostRequestDto postRequestDto,
                                        @RequestParam Long userId,
                                        @RequestParam(required = false) Long categoryId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(postRequestDto, userId, categoryId));
    }

    @PutMapping(POST + "/{postId}")
    public ResponseEntity<PostDto> update(@RequestBody PostDto postDto, @PathVariable(name = "postId") Long id) {
        return ResponseEntity.ok(postService.update(postDto, id, postDto.getUserId(), postDto.getCategoryId()));
    }

    @DeleteMapping(POST + "/{postId}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "postId") Long id) {
        postService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(POST + "/user/{userId}")
    public ResponseEntity<List<PostDto>> findPostsByUserId(@PathVariable(name = "userId") Long id) {
        return ResponseEntity.ok(postService.findPostsByUserId(id));
    }

    @GetMapping(POST + "/category/{categoryId}")
    public ResponseEntity<List<PostDto>> findPostsByCategoryId(@PathVariable(name = "categoryId") Long id) {

        return ResponseEntity.ok(postService.findPostsByCategoryId(id));
    }

    @GetMapping("/api" + POST)
    public ResponseEntity<List<PostDto>> findPostsBySearch(
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "category", required = false) String category) {

        List<PostDto> result;

        if (search != null) {
            result = postService.findPostsByContentContains(search);
        } else if (category != null) {
            result = postService.findPostsByCategory(category);
        } else {

            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(result);
    }
}