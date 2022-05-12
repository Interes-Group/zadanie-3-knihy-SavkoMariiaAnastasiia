package sk.stuba.fei.uim.oop.assignment3.autor.logic;

import sk.stuba.fei.uim.oop.assignment3.autor.data.Autor;
import sk.stuba.fei.uim.oop.assignment3.autor.web.bodies.AutorRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IAutorService {
    void delete(Long id) throws NotFoundException;
    Autor update(Long id, AutorRequest body) throws NotFoundException;
    Autor getById(Long Id) throws NotFoundException;
    List<Autor> getAll();
    Autor create (AutorRequest body);
}
