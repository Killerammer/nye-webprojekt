package hu.nye.webapp.books.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class BookDTO {

    private Long id;
    @NotNull
    private String title;
    private String author;
    private Date releaseDate;
    private int price;
    @NotNull
    private int pageNumber;
    private String publisher;
    @NotNull
    private String ISBN;
}
