package sk.stuba.fei.uim.oop.assignment3.book.web.bodies;


import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

@Getter
public class BookResponse {
    private final long id;
    private final String name;
    private final String description;
    private final long author;
    private final Integer pages;
    private final Integer amount;
    private final Integer lendCount;

    public BookResponse(Book b) {
        this.id = b.getId();
        this.name = b.getName();
        this.description = b.getDescription();
        this.author = b.getAuthor();
        this.pages = b.getPages();
        this.amount = b.getAmount();
        this.lendCount = b.getLendCount();
    }
}
