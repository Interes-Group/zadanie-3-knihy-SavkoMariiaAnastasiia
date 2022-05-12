package sk.stuba.fei.uim.oop.assignment3.list.logic;


import sk.stuba.fei.uim.oop.assignment3.autor.data.Autor;
import sk.stuba.fei.uim.oop.assignment3.autor.web.bodies.AutorRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListClass;
import sk.stuba.fei.uim.oop.assignment3.list.web.bodies.BookIdRequest;

import java.util.List;

public interface IListClassService {

    List<ListClass> getAll();
}
