package com.book.project.demo.dao.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_fk")
    private Author author;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "book_illustrators",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "illustrator_id")})
    private List<Illustrator> illustrators = new ArrayList<>();

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public void addIllustrator(Illustrator illustrator) {
        this.illustrators.add(illustrator);
        illustrator.getBooks().add(this);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Illustrator> getIllustrators() {
        return illustrators;
    }

    public void setIllustrators(List<Illustrator> illustrators) {
        this.illustrators = illustrators;
    }


}
