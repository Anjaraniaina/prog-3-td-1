package app.prog.controller;

import app.prog.controller.mapper.BookRestMapper;
import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.BookEntity;
import app.prog.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService service;
    private final BookRestMapper mapper;

    @GetMapping("/books")
    public List<BookResponse> getBooks() {
        List<BookResponse> list = new ArrayList<>();
        for (BookEntity bookEntity : service.getBooks()) {
            BookResponse bookResponse = mapper.toRest(bookEntity);
            list.add(bookResponse);
        }
        return list;
    }

    @PostMapping("/books")
    public List<BookResponse> createBooks(@RequestBody List<CreateBookResponse> toCreate) {
        List<BookEntity> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.createBooks(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @PutMapping("/books")
    public List<BookResponse> updateBooks(@RequestBody List<UpdateBookResponse> toUpdate) {
        List<BookEntity> domain = toUpdate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.updateBooks(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookId) {
        BookEntity book = service.findById(bookId);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Content-Type", "text/plain")
                    .body("Book not found");
        }
        service.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}

