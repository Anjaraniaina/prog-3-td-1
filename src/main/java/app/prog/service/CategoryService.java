package app.prog.service;

import app.prog.model.Category;
import app.prog.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public List<Category> getCategories() {
        return repository.findAll();
    }

    public List<Category> createCategories(List<Category> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<Category> updateCategories(List<Category> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public Category deleteCategory(Integer authorId) {
        Optional<Category> optional = repository.findById(authorId);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Resource Not Found", null);
        }
    }
}
