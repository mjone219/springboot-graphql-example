package org.example.repository;
import org.example.model.Author;
import org.example.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BookDao {

    private static final HashMap<String, Book> books = new HashMap<>();

    static {
        String id1 = UUID.randomUUID().toString();
        books.put(id1, new Book(id1, "Harry Potter and the Philosopher's Stone", 223, "00000000-0000-0000-0000-000000000001"));
        String id2 = UUID.randomUUID().toString();
        books.put(id2, new Book(id2, "Moby Dick", 635, "00000000-0000-0000-0000-000000000002"));
        String id3 = UUID.randomUUID().toString();
        books.put(id3, new Book(id3, "Interview with the vampire", 371, "00000000-0000-0000-0000-000000000003"));
    }

    public Book getById(String id) {
        return books.get(id);
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public Book updateBook(String id, String title, Integer pageCount, String authorId) {
        Book book = books.get(id);
        if (title != null) {
            book.setTitle(title);
        }
        if (pageCount != null) {
            book.setPageCount(pageCount);
        }
        if (authorId != null) {
            book.setAuthorId(authorId);
        }
        return book;
    }

    public List<Book> listBooks(Integer count, Integer offset) {
        return books.entrySet().stream()
                .sorted(Comparator.comparing(o -> o.getValue().getId()))
                .skip((long) count * offset)
                .limit(count)
                .map(Map.Entry::getValue)
                .toList();
    }

}