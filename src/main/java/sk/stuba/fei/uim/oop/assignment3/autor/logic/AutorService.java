package sk.stuba.fei.uim.oop.assignment3.autor.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.autor.data.Autor;
import sk.stuba.fei.uim.oop.assignment3.autor.data.AutorRepository;
import sk.stuba.fei.uim.oop.assignment3.autor.web.bodies.AutorRequest;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

@Service
public class AutorService implements IAutorService{
    @Autowired
    private AutorRepository repository;
    @Autowired
    private BookRepository repositorbook;

    @Override
    public void delete(Long id) throws NotFoundException {
        Autor a = this.repository.findAutorById(id);
        if(a==null){
            throw new NotFoundException();
        }
        for (int i=repository.findAutorById(id).getBooks().size()-1;i>=0;i--){
            Book b=repository.findAutorById(id).getBooks().get(i);
            repository.findAutorById(id).getBooks().remove(i);//odstranim zo zoznamu
            repositorbook.delete(b);
        }
        this.repository.delete(this.getById(id));
    }

    @Override
    public Autor update(Long id, AutorRequest body) throws NotFoundException {
        Autor a=this.getById(id);
        if(body.getName() != null){
            a.setName(body.getName());
        }
        if(body.getSurname() != null){
            a.setSurname(body.getSurname());
        }
        return this.repository.save(a);
    }

    @Override
    public Autor getById(Long Id) throws NotFoundException {
        Autor a = this.repository.findAutorById(Id);
        if(a==null){
            throw new NotFoundException();
        }
        return a;
    }

    @Override
    public List<Autor> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Autor create(AutorRequest body) {
        return this.repository.save(new Autor(body));
    }
}
