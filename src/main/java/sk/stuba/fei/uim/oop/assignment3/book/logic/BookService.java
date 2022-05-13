package sk.stuba.fei.uim.oop.assignment3.book.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.autor.data.Autor;
import sk.stuba.fei.uim.oop.assignment3.autor.data.AutorRepository;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository repository;
    @Autowired
    private AutorRepository repositar;

    @Override
    public void delete(Long id) throws NotFoundException {
        Book book = this.getById(id);
        Autor a = repositar.findAutorById(book.getAuthor());
        a.getBooks().remove(book);
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
    public Book create(BookRequest body) throws NotFoundException{
        if (repositar.findAutorById(body.getAuthor()) == null){
            throw new NotFoundException();
        }
        Autor o = repositar.findAutorById(body.getAuthor());
        Book c=new Book(body);
        o.getBooks().add(c);
        return this.repository.save(c);
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
    public int getLendCount(long productId) throws NotFoundException {
        Optional<Book> book= repository.findById(productId);
        if (book.isEmpty()){
            throw new NotFoundException();
        }
        return book.get().getLendCount();
    }
}
