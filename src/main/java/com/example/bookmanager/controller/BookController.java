package com.example.bookmanager.controller;
//this class will handle web requests and returns HTML pages.
import com.example.bookmanager.model.Book;
import com.example.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    //show all the books
    @GetMapping("/") //when user goes to http://localhost:8080/, show index.html.
    public String viewBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());//sends data to HTML page.
        return "index";
    }
    //add a new book(from submission)
    @PostMapping("/add")
    public String addBook(@RequestParam String title, @RequestParam String author){
        Book book = new Book(null, title, author);
        bookRepository.save(book);
        return "redirect:/";
    }
    //delete a book.
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
        return "redirect:/";
    }
}
