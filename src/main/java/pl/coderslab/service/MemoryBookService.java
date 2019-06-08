package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryBookService {
    private List<Book> list;
    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                    "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                    "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                    "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {return list;}

    public void setList(List<Book> list) {this.list = list;}

    public Book getById(long id){
        Optional<Book> maybeBook = list.stream()
                .filter(book -> book.getId() == id)
                .findAny();
        return maybeBook.orElse(null);
    }

    public void update(Book newBook){
        Book bookToUpdate = getById(newBook.getId());
        bookToUpdate.setAuthor(newBook.getAuthor());
        bookToUpdate.setIsbn(newBook.getIsbn());
        bookToUpdate.setPublisher(newBook.getPublisher());
        bookToUpdate.setTitle(newBook.getTitle());
        bookToUpdate.setType(newBook.getType());
    }

    public void delete(long id){
        Book bookToRemove = getById(id);
        list.remove(bookToRemove);
    }

    public void add(Book newBook){
        Optional<Long> max = list.stream()
                .map(book -> book.getId())
                .max((id1, id2) -> Long.compare(id1, id2));
        Long id  = max.orElse(0L) + 1;
        newBook.setId(id);
        list.add(newBook);
    }
}