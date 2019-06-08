package pl.coderslab.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;

import java.util.List;

public class DBBookService implements BookService{
    @Override
    public List<Book> getList() {
        return null;
    }

    @Override
    public Book getById(long id) {
        return null;
    }

    @Override
    public void update(Book newBook) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void add(Book newBook) {

    }
}
