package com.example.bookmanager.repository;
//this will handle all database operations automaticaly.
import com.example.bookmanager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {//extending JpaRepository gives me ready-to-use methods without writing SQL.
    //spring boot provides all CRUD methods: save, findAll, deleteById, ...
}

