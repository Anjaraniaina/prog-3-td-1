package app.prog.repository;

import app.prog.model.BookEntity;
import app.prog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
