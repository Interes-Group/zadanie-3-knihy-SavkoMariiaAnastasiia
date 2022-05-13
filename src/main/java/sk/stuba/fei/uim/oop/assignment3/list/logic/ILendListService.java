package sk.stuba.fei.uim.oop.assignment3.list.logic;


import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.list.data.LendList;
import sk.stuba.fei.uim.oop.assignment3.list.web.bodies.BookIdRequest;

import java.util.List;

public interface ILendListService {

    List<LendList> getAll();

    LendList create();

    LendList getById(long id) throws NotFoundException;

    LendList addBook(long id, BookIdRequest bookId) throws NotFoundException, IllegalOperationException;

    void removeBook(long id, BookIdRequest bookId) throws NotFoundException;

    void lendBook(long listId) throws NotFoundException, IllegalOperationException;

    void deleteList(long listId) throws NotFoundException;
}
