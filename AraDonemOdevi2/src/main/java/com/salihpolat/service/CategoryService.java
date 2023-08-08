package com.salihpolat.service;

import com.salihpolat.dto.response.CategoryDto;
import com.salihpolat.exception.BadRequestException;
import com.salihpolat.exception.InternalServerErrorException;
import com.salihpolat.exception.ResourceNotFoundException;
import com.salihpolat.mapper.ICategoryMapper;
import com.salihpolat.model.Category;
import com.salihpolat.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final ICategoryRepository categoryRepository;

    public List<Category> findAll() {

        try {

            return categoryRepository.findAll();

        } catch (Exception e) {

            throw new InternalServerErrorException("An error occurred while fetching categories");

        }
    }

    public Category findById(Long id) {

        if (id <= 0) {
            throw new BadRequestException("Invalid category ID: " + id);
        }

        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isEmpty()) {
            throw new ResourceNotFoundException("Category not found with ID: " + id);
        }

        return categoryOptional.get();
    }

    public CategoryDto save(Category category) {

        try {

            if (category == null) {
                throw new BadRequestException("Category cannot be null");
            }

            CategoryDto categoryDto = ICategoryMapper.INSTANCE.categoryToCategoryDto(categoryRepository.save(category));

            return categoryDto;

        } catch (Exception e) {

            throw new InternalServerErrorException("An error occurred while saving category");

        }
    }

    public void deleteById(Long id) {

        Optional<Category> category = categoryRepository.findById(id);

        try {

            if (category.isEmpty()) {
                throw new ResourceNotFoundException("Category not found with ID: " + id);
            }

            categoryRepository.deleteById(id);

        } catch (Exception e) {

            throw new InternalServerErrorException("An error occurred while deleting category");

        }
    }
}