package sk.stuba.fei.uim.oop.assignment3.book.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository repository;
}
