package org.example.repository;
import org.example.model.Author;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class AuthorDao {

    private static final HashMap<String, Author> authors = new HashMap<>();

    static {
        String id1 = "00000000-0000-0000-0000-000000000001";
        authors.put(id1, new Author(id1, "Joanne", "Rowling"));
        String id2 = "00000000-0000-0000-0000-000000000002";
        authors.put(id2, new Author(id2, "Herman", "Melville"));
        String id3 = "00000000-0000-0000-0000-000000000003";
        authors.put(id3, new Author(id3, "Anne", "Rice"));
    }

    public Author getById(String id) {
        return authors.get(id);
    }

    public void addAuthor(Author author) {
        authors.put(author.getId(), author);
    }
}