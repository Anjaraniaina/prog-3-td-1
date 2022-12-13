package app.prog.repository;

import app.prog.model.Author;
import app.prog.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findByName(String name);

    List<Author> findByBirthDateOrderByDesc();
}
