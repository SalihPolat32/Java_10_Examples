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

    public List<CategoryDto> findAll() {

        try {

            List<CategoryDto> categoryDtoList = ICategoryMapper.INSTANCE.categoryListToCategoryDtoList(categoryRepository.findAll());

            return categoryDtoList;

        } catch (Exception e) {

            throw new InternalServerErrorException("An Error Occurred While Fetching Categories");

        }
    }

    public CategoryDto findById(Long id) {

        if (id <= 0) {
            throw new BadRequestException("Invalid Category ID: " + id);
        }

        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isEmpty()) {
            throw new ResourceNotFoundException("Category Not Found With ID: " + id);
        }

        CategoryDto categoryDto = ICategoryMapper.INSTANCE.categoryToCategoryDto(categoryRepository.findById(id).get());

        return categoryDto;
    }

    public Category getById(Long id) {

        if (id <= 0) {
            throw new BadRequestException("Invalid Category ID: " + id);
        }

        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isEmpty()) {
            throw new ResourceNotFoundException("Category Not Found With ID: " + id);
        }

        return categoryOptional.get();
    }

    public CategoryDto save(CategoryDto categoryDto) {

        try {

            if (categoryDto == null) {
                throw new BadRequestException("Category Cannot Be null");
            }

            Category savedCategory = categoryRepository.save(ICategoryMapper.INSTANCE.categoryDtoToCategory(categoryDto));

            CategoryDto savedCategoryToCategoryDto = ICategoryMapper.INSTANCE.categoryToCategoryDto(savedCategory);

            return savedCategoryToCategoryDto;

        } catch (Exception e) {

            throw new InternalServerErrorException("An Error Occurred While Saving Category");

        }
    }

    public CategoryDto update(CategoryDto categoryDto, Long id) {

        categoryDto.setId(id);

        Category category = ICategoryMapper.INSTANCE.categoryDtoToCategory(categoryDto);

        Category updatedCategory = categoryRepository.save(category);

        return ICategoryMapper.INSTANCE.categoryToCategoryDto(updatedCategory);
    }

    public void deleteById(Long id) {

        Optional<Category> category = categoryRepository.findById(id);

        try {

            if (category.isEmpty()) {
                throw new ResourceNotFoundException("Category Not Found With ID: " + id);
            }

            categoryRepository.deleteById(id);

        } catch (Exception e) {

            throw new InternalServerErrorException("An Error Occurred While Deleting Category");

        }
    }

    public CategoryDto findCategoryByCategoryNameIgnoreCase(String name) {

        Category category = categoryRepository.findCategoryByCategoryNameIgnoreCase(name);

        if (category == null) {
            throw new ResourceNotFoundException("Category Not Found With Name : " + name);
        }

        return ICategoryMapper.INSTANCE.categoryToCategoryDto(category);
    }
}