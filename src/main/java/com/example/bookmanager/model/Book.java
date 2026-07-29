package com.example.bookmanager.model;
import jakarta.persistence.*;
import lombok.*;

@Entity //a table in database
@Getter @Setter //auto generated getter setters
@NoArgsConstructor @AllArgsConstructor
public class Book {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String Author;


}
