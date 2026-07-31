package com.example.bookmanager.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity //a table in database
@Getter @Setter //auto generated getter setters
@NoArgsConstructor @AllArgsConstructor
public class Book {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private LocalDate publishedDate;
    //constructor without ID:
    public Book(String title, String author, LocalDate publishedDate){
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;

    }


}
