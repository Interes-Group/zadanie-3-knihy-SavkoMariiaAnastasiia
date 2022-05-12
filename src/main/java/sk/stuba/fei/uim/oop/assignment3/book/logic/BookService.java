package sk.stuba.fei.uim.oop.assignment3.book.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository repository;

    @Override
    public void delete(Long id) throws NotFoundException {
        this.repository.delete(this.getById(id));
    }

    @Override
    public Book update(Long id, BookRequest body) throws NotFoundException {
        Book b=this.getById(id);
        if(body.getName() != null){
            b.setName(body.getName());
        }
        if(body.getDescription() != null){
            b.setDescription(body.getDescription());
        }
        if(body.getAuthor() != 0){
            b.setAuthor(body.getAuthor());
        }
        if(body.getPages() != 0){
            b.setPages(body.getPages());
        }
        if(body.getAmount() != 0){
            b.setAmount(body.getAmount());
        }
        if(body.getLendCount() != 0){
            b.setLendCount(body.getLendCount());
        }
        return this.repository.save(b);
    }

    @Override
    public Book getById(Long Id) throws NotFoundException {
        Book b = this.repository.findBookById(Id);
        if(b==null){
            throw new NotFoundException();
        }
        return b;
    }

    @Override
    public List<Book> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Book create(BookRequest body) {
        return this.repository.save(new Book(body));
    }

    @Override
    public int getBookAmount(Long id) throws NotFoundException {
        if(this.repository.findBookById(id) ==null){
            throw new NotFoundException();
        }
        return this.repository.findBookById(id).getAmount();
    }

    @Override
    public int addAmount(long id, int increment) throws NotFoundException {
        Book p = this.getById(id);
        p.setAmount(p.getAmount() + increment);
        this.repository.save(p);
        return p.getAmount();
    }
}
