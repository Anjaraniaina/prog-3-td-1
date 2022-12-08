package app.prog.controller.mapper;

import app.prog.controller.request.CreateBook;
import app.prog.controller.response.BookResponse;
import app.prog.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookRestMapper {
    public BookResponse toRest(Book domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public Book toDomain(CreateBook rest) {
        return Book.builder()
                .title(rest.getTitle())
                .author(rest.getAuthor())
                .pageNumber(0)
                .build();
    }

    public Book toDomain(BookResponse rest) {
        return Book.builder()
                .id(rest.getId())
                .title(rest.getTitle())
                .author(rest.getAuthor())
                .pageNumber(0)
                .build();
    }
}
