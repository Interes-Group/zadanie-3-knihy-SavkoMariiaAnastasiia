package sk.stuba.fei.uim.oop.assignment3.list.data;

import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ListClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private java.util.List<Book> lendingList;
    private Boolean lended;
}
