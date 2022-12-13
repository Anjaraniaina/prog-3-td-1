package app.prog.controller;

import app.prog.controller.mapper.CategoryRestMapper;
import app.prog.controller.response.CategoryResponse;
import app.prog.controller.response.CreateCategoryResponse;
import app.prog.model.Category;
import app.prog.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService service;
    private final CategoryRestMapper mapper;

    @GetMapping("/categories")
    public List<CategoryResponse> getCategorys() {
        List<CategoryResponse> list = new ArrayList<>();
        for (Category category : service.getCategories()) {
            CategoryResponse categoryResponse = mapper.toRest(category);
            list.add(categoryResponse);
        }
        return list;
    }



    @PostMapping("/categories")
    public List<CategoryResponse> createCategories(@RequestBody List<CreateCategoryResponse> toCreate) {
        List<Category> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.createCategories(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/categories/{categoryId}")
    public CategoryResponse deleteCategory(@PathVariable Integer categoryId) {
        return mapper.toRest(service.deleteCategory(categoryId));
    }
}
