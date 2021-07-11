package com.example.demo;

import com.example.demo.book.Author;
import com.example.demo.book.AuthorRepository;
import com.example.demo.book.Book;
import com.example.demo.book.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ContextConfiguration(classes = DomainConfig.class)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private JdbcAggregateTemplate aggregateTemplate;

    @Test
    public void booksAndAuthors() {
        Author author = new Author(1L, "Greg L. Turnquist");

        author = authorRepository.save(author);

        Book book = new Book();
        book.title = "Spring Boot";
        book.addAuthor(author);

        bookRepository.save(book);

        bookRepository.deleteAll();

        assertThat(authorRepository.count()).isEqualTo(1);
    }

    @Test
    public void authors() {
        Author author = new Author(1l, "APJ");

        aggregateTemplate.insert(author);

        Author byId = authorRepository.findById(1L).get();
        byId.setName("Kalam");

        aggregateTemplate.update(byId);

        Author updated = authorRepository.findById(1L).get();

        System.out.println(updated);
    }
}
