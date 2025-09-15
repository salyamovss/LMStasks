package ArrayList.models.models;

import ArrayList.models.db.GenerateId;
import ArrayList.models.enums.Genre;

public class Book {

    private Long id;
    private String name;
    private String author;
    private Genre genre;

    public Book(String name, String author, Genre genre) {
        this.id = GenerateId.genBookId();
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                '}';
    }
}
