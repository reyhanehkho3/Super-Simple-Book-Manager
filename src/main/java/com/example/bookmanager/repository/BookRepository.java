package com.example.bookmanager.repository;
//this will handle all database operations automaticaly.
import com.example.bookmanager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {//extending JpaRepository gives me ready-to-use methods without writing SQL.
    //spring boot provides all CRUD methods: save, findAll, deleteById, ...
    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(b.author) LIKE LOWER(CONCAT('%',:keyword, '%'))")
    List<Book> searchBooks(@Param("keyword") String keyword);
}

