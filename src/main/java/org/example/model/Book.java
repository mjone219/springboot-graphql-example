package org.example.model;

import java.util.Objects;

public class Book {
    private final String id;
    private String title;
    private int pageCount;
    private String authorId;

    public Book(String id, String title, int pageCount, String authorId) {
        this.id = id;
        this.title = title;
        this.pageCount = pageCount;
        this.authorId = authorId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pageCount == book.pageCount && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(authorId, book.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, pageCount, authorId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(title).append('\'');
        sb.append(", pageCount=").append(pageCount);
        sb.append(", authorId='").append(authorId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
