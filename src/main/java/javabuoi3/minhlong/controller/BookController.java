package javabuoi3.minhlong.controller;


import jakarta.validation.Valid;
import javabuoi3.minhlong.entity.Book;
import javabuoi3.minhlong.serrvices.BookService;
import javabuoi3.minhlong.serrvices.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
@Valid
@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute(("categories"), categoryService.getAllCategories());
        return "book/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            // Xử lý khi không tìm thấy đầu sách
            return "redirect:/books";
        }
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/edit";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book updatedBook, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/edit";
        }
        Book book = bookService.getBookById(id);
        if (book == null) {
            // Xử lý khi không tìm thấy đầu sách
            return "redirect:/books";
        }
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setPrice(updatedBook.getPrice());
        book.setCategory(updatedBook.getCategory());
        bookService.updateBook(book);
        return "redirect:/books";
    }

}
