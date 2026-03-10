package com.library.controller;

import com.library.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {
    private List<Book> books = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Library Management System";
    }

    @GetMapping("/count")
    public int count() {
        return 100;
    }

    @GetMapping("/price")
    public double price() {
        return 299.99;
    }

    @GetMapping("/books")
    public List<String> getBooks() {
        List<String> bookTitles = new ArrayList<>();
        bookTitles.add("The Great Gatsby");
        bookTitles.add("To Kill a Mockingbird");
        bookTitles.add("1984");
        bookTitles.add("Pride and Prejudice");
        return bookTitles;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return new Book(id, "Sample Book", "Sample Author", 199.99);
    }

    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "Searching for book with title: " + title;
    }

    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Author name: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book added successfully: " + book.getTitle();
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return books;
    }
}
