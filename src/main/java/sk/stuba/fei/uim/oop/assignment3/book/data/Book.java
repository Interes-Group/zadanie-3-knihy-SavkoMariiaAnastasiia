package sk.stuba.fei.uim.oop.assignment3.book.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Long author;

    private Integer pages;

    private Integer amount;

    private Integer lendCount;

    public Book (BookRequest request){
        this.name=request.getName();
        this.description=request.getDescription();
        this.author=request.getAuthor();
        this.pages=request.getPages();
        this.amount=request.getAmount();
        this.lendCount=request.getLendCount();
    }
}
