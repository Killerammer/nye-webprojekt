package hu.nye.webapp.books.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private Date releaseDate;
    private int price;
    private int pageNumber;
    private String publisher;
    private String ISBN;
    private String image;
}
