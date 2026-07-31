package com.example.bookmanager.controller;
//this class will handle web requests and returns HTML pages.
import com.example.bookmanager.model.Book;
import com.example.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    //show all the books(with search)
    @GetMapping("/") //when user goes to http://localhost:8080/, show index.html.
    public String viewBooks(@RequestParam(required = false) String search, Model model){
        if(search != null && !search.isEmpty()){
            model.addAttribute("books", bookRepository.searchBooks(search));
            model.addAttribute("searchKeyword", search);
        }
        else{
            model.addAttribute("books", bookRepository.findAll());//sends data to HTML page.
        }
        return "index";
    }
    //show add form
    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("book", new Book());
        return "add-book";
    }

    //add a new book(from submission)
    @PostMapping("/add")
    public String addBook(@RequestParam String title, @RequestParam String author, @RequestParam String publishedDate){
        Book book = new Book(null, title, author, LocalDate.parse(publishedDate));
        bookRepository.save(book);
        return "redirect:/";
    }
    //delete a book.
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
        return "redirect:/";
    }

    //show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Book book = bookRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid book ID" + id));
        model.addAttribute("book", book);
        return "edit-book";
    }

    //update book
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @RequestParam String title, @RequestParam String author, @RequestParam String publishedDate){
        Book book = bookRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid book ID: "+ id));
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishedDate(LocalDate.parse(publishedDate));
        bookRepository.save(book);
        return "redirect:/";
    }
}
