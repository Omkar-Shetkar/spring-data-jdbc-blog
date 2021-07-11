package com.example.demo.book;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

@Table("book")
public class Book {
    @Id
    public Long id;
    public String title;
    private Set<AuthorRef> authors = new HashSet<>();

    public void addAuthor(Author author) {
        authors.add(createAuthorRef(author));
    }

    private AuthorRef createAuthorRef(Author author) {
        Assert.notNull(author, "Author must not be null");
        Assert.notNull(author.getId(), "Author id, must not be null");

        AuthorRef authorRef = new AuthorRef();
        authorRef.author = author.getId();
        return authorRef;
    }
}

@Table("book_author")
class AuthorRef {
    Long author;
}