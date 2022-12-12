package app.prog.repository;

import app.prog.model.Author;
import app.prog.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {
}
