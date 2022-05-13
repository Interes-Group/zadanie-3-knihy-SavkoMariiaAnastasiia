package sk.stuba.fei.uim.oop.assignment3.list.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.autor.data.Autor;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListClass;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListClassRepository;

import java.util.List;

@Service
public class ListClassService implements IListClassService {
    @Autowired
    private ListClassRepository repository;
    private BookRepository bookrepository;


    @Override
    public List<ListClass> getAll() {
        return this.repository.findAll();
    }

    @Override
    public ListClass create() {
        //todo vetvorim list ulozim list repositar a preposlem naspet
        ListClass o = new ListClass();
        return repository.save(o);
    }

}
