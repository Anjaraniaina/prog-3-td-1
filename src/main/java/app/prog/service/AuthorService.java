package app.prog.service;

import app.prog.model.Author;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;

    public List<Author> getAuthors() {
        return repository.findAll();
    }

    public List<Author> createAuthors(List<Author> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<Author> updateAuthors(List<Author> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public Author deleteAuthor(Integer authorId) {
        Optional<Author> optional = repository.findById(String.valueOf(authorId));
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Resource Not Found", null);
        }
    }
}
