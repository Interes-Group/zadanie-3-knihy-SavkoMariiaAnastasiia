package sk.stuba.fei.uim.oop.assignment3.list.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.logic.IBookService;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListClassRepo;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListClass;
import sk.stuba.fei.uim.oop.assignment3.list.web.bodies.BookIdRequest;


import java.util.List;
import java.util.Optional;

@Service
public class ListClassService implements IListClassService {

    @Autowired
    private final ListClassRepo repository;

    @Autowired
    private IBookService booksService;

    @Autowired
    public ListClassService(ListClassRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<ListClass> getAll() {
        return this.repository.findAll();
    }


    @Override
    public ListClass create() {
        return this.repository.save(new ListClass());
    }

    @Override
    public ListClass getById(long id) throws NotFoundException {
        Optional<ListClass> list = this.repository.findById(id);
        if (list.isEmpty()) {
            throw new NotFoundException();

        }

        return list.get();
    }

    @Override
    public ListClass addBook(long id, BookIdRequest bookId) throws NotFoundException, IllegalOperationException {

        Optional<ListClass> list = this.repository.findById(id);
        Optional<Book> book = Optional.ofNullable(this.booksService.getById((long)bookId.getBookId()));
        if (book.isEmpty() || list.isEmpty()) {
            throw new NotFoundException();
        }
        if (list.get().getLendingList().contains(book.get()) || list.get().isLended() || book.get().getLendCount() >= book.get().getAmount()) {
            throw new IllegalOperationException();
        }
        list.get().getLendingList().add(book.get());
        this.repository.save(this.getById(id));

        return list.get();

    }

    @Override
    public void removeBook(long id, BookIdRequest bookId) throws NotFoundException {
        Optional<ListClass> list = this.repository.findById(id);
        Optional<Book> book = Optional.ofNullable(this.booksService.getById((long)bookId.getBookId()));
        if (book.isEmpty() || list.isEmpty() || !list.get().getLendingList().contains(book.get())) {
            throw new NotFoundException();
        }
        list.get().getLendingList().remove(book.get());
        this.repository.save(this.getById(id));
    }

    @Override
    public void lendBook(long listId) throws NotFoundException, IllegalOperationException {
        Optional<ListClass> list = this.repository.findById(listId);
        if (list.isEmpty()) {
            throw new NotFoundException();
        }
        if (list.get().isLended()) {
            throw new IllegalOperationException();
        }
        list.get().setLended(true);
        for (Book book: list.get().getLendingList()) {
            book.setLendCount(book.getLendCount() + 1);
        }

        this.repository.save(list.get());
    }

    @Override
    public void deleteList(long listId) throws NotFoundException {
        Optional<ListClass> list = this.repository.findById(listId);
        if (list.isEmpty()) {
            throw new NotFoundException();
        }

        for (Book book: list.get().getLendingList()) {
            book.setLendCount(book.getLendCount() - 1);
        }
        this.repository.deleteById(listId);
    }
}


