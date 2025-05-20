package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.service.BooksService;

@Controller

public class BooksController {
    @Autowired
    BooksService booksService;
    
    @GetMapping("/books/{id}")
    public String getBooks(@PathVariable("id")Long id,Model model) {
    	model.addAttribute("book",this.booksService.findById(id));
    	return "book.html";
    }
    
    @GetMapping("/books")
    public String showBooks(Model model) {
    	model.addAttribute("books",this.booksService.findAll());
    	return "books.html";
    }
}
