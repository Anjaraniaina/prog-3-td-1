package app.prog.controller.mapper;

import app.prog.controller.response.CategoryResponse;
import app.prog.controller.response.CreateCategoryResponse;
import app.prog.model.Category;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryRestMapper {

    public CategoryResponse toRest(Category domain) {
        return CategoryResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

    public Category toDomain(CreateCategoryResponse rest) {
        return Category.builder()
                .name(rest.getName())
                .build();
    }
}
