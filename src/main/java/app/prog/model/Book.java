package app.prog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    /*
    TODO-4-a: Note that i use serial type for ID in database. What does serial do ?
    TODO-4-b: Should I map it with int ? Fix it if there is a problem
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true ,updatable = false)
    private int id;
    private String title;
    private String author;
    private Integer pageNumber;
    private LocalDate releaseDate;

    public boolean hasAuthor() {
        return author != null;
    }

}
