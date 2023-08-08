package com.salihpolat.controller;

import com.salihpolat.dto.response.PostDto;
import com.salihpolat.model.Post;
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

    @PostMapping(POST)
    public ResponseEntity<PostDto> save(@RequestBody Post post) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(post));
    }

    @GetMapping(POST)
    public ResponseEntity<List<PostDto>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping(POST + "/{postId}")
    public ResponseEntity<PostDto> findById(@PathVariable(name = "postId") Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @PutMapping(POST + "/{postId}")
    public ResponseEntity<PostDto> update(@RequestBody Post post, @PathVariable(name = "postId") Long id) {
        post.setId(id);
        return ResponseEntity.ok(postService.save(post));
    }

    @DeleteMapping(POST + "/{postId}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "postId") Long id) {
        postService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(POST + "/category/{categoryId}")
    public ResponseEntity<List<PostDto>> findPostsByCategoryId(@PathVariable(name = "categoryId") Long id) {

        return ResponseEntity.ok(postService.findPostsByCategoryId(id));
    }

    @GetMapping(POST + "/user/{userId}")
    public ResponseEntity<List<PostDto>> findPostsByUserId(@PathVariable(name = "userId") Long id) {
        return ResponseEntity.ok(postService.findPostsByUserId(id));
    }
}