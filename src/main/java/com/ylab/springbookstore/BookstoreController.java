package com.ylab.springbookstore;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.ui.Model;


@Controller
public class BookstoreController {

    private BookServiceInterface bookServiceInterface;

    public BookstoreController(BookServiceInterface thBookServiceInterface){
        bookServiceInterface = thBookServiceInterface;
    }

    @GetMapping("/")
    public String showWelcome() {
        return "welcome";
    }
    
    @GetMapping("/list")
    public String listBooks(Model theModel){
        List<Book> theBook = bookServiceInterface.findAll();
        theModel.addAttribute("books", theBook);
        return "listbooks";
    }

    @GetMapping("/add")
    public String formForAdd(Model theModel){
        Book theBook = new Book();
        theModel.addAttribute("book", theBook);
        return "bookform";
    }

    @GetMapping("/update")
    public String formForUpdate(@RequestParam("bookId") int theId, Model theModel) {
        Book theBook = bookServiceInterface.findById(theId);
        theModel.addAttribute("book", theBook);
        return "bookform";
    }

    @GetMapping("/purchase")
    public String orderConfirm(@RequestParam("bookId") int theId, Model theModel) {
        Book theBook = bookServiceInterface.findById(theId);
        theModel.addAttribute("order", theBook);
        return "confirmation";
    }

    @PostMapping("/save")
    public String saveBook(@Valid @ModelAttribute("book") Book theBook, BindingResult thBindingResult) {

        if(thBindingResult.hasErrors()){
            return "bookform";
        } else {
            bookServiceInterface.save(theBook);
            return "redirect:/list";
        }
        
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int theId) {
        bookServiceInterface.deleteById(theId);
        return "redirect:/list";
    }
}
