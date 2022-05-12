package sk.stuba.fei.uim.oop.assignment3.list.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.autor.data.Autor;
import sk.stuba.fei.uim.oop.assignment3.autor.web.bodies.AutorRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListClass;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListClassRepository;
import sk.stuba.fei.uim.oop.assignment3.list.web.bodies.BookIdRequest;

import java.util.List;

@Service
public class ListClassService implements IListClassService {
    @Autowired
    private ListClassRepository repository;


    @Override
    public List<ListClass> getAll() {
        return null;
    }



}
