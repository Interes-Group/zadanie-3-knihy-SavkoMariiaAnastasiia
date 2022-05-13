package sk.stuba.fei.uim.oop.assignment3.list.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.logic.IBookService;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.list.data.ILendListRepo;
import sk.stuba.fei.uim.oop.assignment3.list.data.LendList;
import sk.stuba.fei.uim.oop.assignment3.list.web.bodies.BookIdRequest;


import java.util.List;
import java.util.Optional;

@Service
public class LendListService implements ILendListService {

    @Autowired
    private final ILendListRepo repository;

    @Autowired
    private IBookService booksService;

    @Autowired
    public LendListService(ILendListRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<LendList> getAll() {
        return this.repository.findAll();
    }


    @Override
    public LendList create() {
        return this.repository.save(new LendList());
    }

    @Override
    public LendList getById(long id) throws NotFoundException {
        Optional<LendList> list = this.repository.findById(id);
        if (list.isEmpty()) {
            throw new NotFoundException();

        }

        return list.get();
    }

    @Override
    public LendList addBook(long id, BookIdRequest bookId) throws NotFoundException, IllegalOperationException {

        Optional<LendList> list = this.repository.findById(id);
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
        Optional<LendList> list = this.repository.findById(id);
        Optional<Book> book = Optional.ofNullable(this.booksService.getById((long)bookId.getBookId()));
        if (book.isEmpty() || list.isEmpty() || !list.get().getLendingList().contains(book.get())) {
            throw new NotFoundException();
        }
        list.get().getLendingList().remove(book.get());
        this.repository.save(this.getById(id));
    }

    @Override
    public void lendBook(long listId) throws NotFoundException, IllegalOperationException {
        Optional<LendList> list = this.repository.findById(listId);
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
        Optional<LendList> list = this.repository.findById(listId);
        if (list.isEmpty()) {
            throw new NotFoundException();
        }

        for (Book book: list.get().getLendingList()) {
            book.setLendCount(book.getLendCount() - 1);
        }
        this.repository.deleteById(listId);
    }
}


