package in.co.learningville.springbootsample.controllers;

import in.co.learningville.springbootsample.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pra_pri on 13-Aug-17.
 */
@Controller
public class BookController {

    private BookRepository bookRepository;

    //Constructor Based Dependency Injection
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

    model.addAttribute("books",bookRepository.findAll());

    return "books";//ThymeLeaf Template Name (View)
    }
}
