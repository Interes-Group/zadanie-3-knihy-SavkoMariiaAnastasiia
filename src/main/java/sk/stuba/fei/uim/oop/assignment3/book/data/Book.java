package sk.stuba.fei.uim.oop.assignment3.book.data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Long author;

    private Integer pages;

    private Integer amount;

    private Integer lendCount;

}
