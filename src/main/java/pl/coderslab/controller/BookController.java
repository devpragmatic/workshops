package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.service.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @RequestMapping("/")
    public List<Book> getAll(){
        return bookService.getList();
    }

    @RequestMapping("/{id}")
    public Book getById(@PathVariable long id){
        return bookService.getById(id);
    }

    @PostMapping("/")
    public void addBook(@RequestBody Book book){
        bookService.add(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable long id, @RequestBody Book book){
        book.setId(id);
        bookService.update(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        bookService.delete(id);
    }
}