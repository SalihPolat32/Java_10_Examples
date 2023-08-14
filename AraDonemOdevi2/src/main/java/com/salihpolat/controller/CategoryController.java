package com.salihpolat.controller;

import com.salihpolat.dto.response.CategoryDto;
import com.salihpolat.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.salihpolat.constant.RestApiUrl.CATEGORY;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(CATEGORY)
    public ResponseEntity<List<CategoryDto>> findAll() {

        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping(CATEGORY + "/{categoryId}")
    public ResponseEntity<CategoryDto> findById(@PathVariable(name = "categoryId") Long id) {

        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping(CATEGORY)
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(categoryDto));
    }

    @PutMapping(CATEGORY + "/{categoryId}")
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto, @PathVariable(name = "categoryId") Long id) {

        return ResponseEntity.ok(categoryService.update(categoryDto, id));
    }

    @DeleteMapping(CATEGORY + "/{categoryId}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "categoryId") Long id) {

        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api" + CATEGORY + "/{name}")
    public CategoryDto findCategoryByCategoryNameIgnoreCase(@PathVariable(name = "name") String name) {

        return categoryService.findCategoryByCategoryNameIgnoreCase(name);
    }
}