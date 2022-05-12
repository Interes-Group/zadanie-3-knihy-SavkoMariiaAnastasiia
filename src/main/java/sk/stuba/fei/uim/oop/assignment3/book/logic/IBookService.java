package sk.stuba.fei.uim.oop.assignment3.book.logic;

import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IBookService {
    void delete(Long id) throws NotFoundException;
    Book update(Long id, BookRequest body) throws NotFoundException;
    Book getById(Long Id) throws NotFoundException;
    List<Book> getAll();
    Book create (BookRequest body) throws NotFoundException;
    int getBookAmount(Long id) throws NotFoundException;
    int addAmount(long id, int increment) throws NotFoundException;
}
