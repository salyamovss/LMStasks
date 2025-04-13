package ArrayList.models;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Library> libraries;
    private List<Book> books;
    private List<Reader> readers;
    private long lastLibraryId;  // Это будет хранить последний использованный ID для библиотеки

    public Database() {
        this.libraries = new ArrayList<>();
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.lastLibraryId = 0;  // Начинаем с нуля
    }

    public long getLastLibraryId() {
        return lastLibraryId;
    }

    public void setLastLibraryId(long lastLibraryId) {
        this.lastLibraryId = lastLibraryId;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }
}
