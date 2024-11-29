package org.example.controller;
import org.example.model.Author;
import org.example.model.Book;
import org.example.repository.AuthorDao;
import org.example.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
class BookController {

    private final AuthorDao authorDao;
    private final BookDao bookDao;

    @Autowired
    public BookController(AuthorDao authorDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    @QueryMapping
    public List<Book> listBooks(@Argument Integer count, @Argument Integer offset) {
        return bookDao.listBooks(count, offset);
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookDao.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorDao.getById(book.getAuthorId());
    }

    @MutationMapping
    public Book addBook(@Argument String title,
                        @Argument Integer pageCount,
                        @Argument String authorId) {

        Book book = new Book(UUID.randomUUID().toString(), title, pageCount, authorId);
        bookDao.addBook(book);

        return book;
    }

    @MutationMapping
    public Book updateBook(@Argument String id,
                           @Argument String title,
                           @Argument Integer pageCount,
                           @Argument String authorId) {

        return bookDao.updateBook(id, title, pageCount, authorId);
    }

    @MutationMapping
    public Author addAuthor(@Argument String firstName,
                            @Argument String lastName) {

        Author author = new Author(UUID.randomUUID().toString(), firstName, lastName);
        authorDao.addAuthor(author);

        return author;
    }
}