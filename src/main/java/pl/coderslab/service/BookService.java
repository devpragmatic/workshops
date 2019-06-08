package pl.coderslab.service;

import pl.coderslab.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getList();
    Book getById(long id);
    void update(Book newBook);
    void delete(long id);
    void add(Book newBook);
}
