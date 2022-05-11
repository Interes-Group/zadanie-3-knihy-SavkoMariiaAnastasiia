package sk.stuba.fei.uim.oop.assignment3.list.web.bodies;


import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListClass;

@Getter
public class ListClassResponse {

    private final long id;
    private final  java.util.List<Book> lendingList;
    private final Boolean lended;

    public ListClassResponse(ListClass l) {
        this.id = l.getId();
        this.lendingList = l.getLendingList();
        this.lended = l.getLended();
    }
}
