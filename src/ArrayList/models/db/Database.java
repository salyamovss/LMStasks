package ArrayList.models.db;

import ArrayList.models.models.Book;
import ArrayList.models.models.Library;
import ArrayList.models.models.Reader;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Library> libraries = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();
    public static List<Reader> readers = new ArrayList<>();

    public Database() {
    }

    public static List<Library> getLibraries() {
        return libraries;
    }

    public static void setLibraries(List<Library> libraries) {
        Database.libraries = libraries;
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static void setBooks(List<Book> books) {
        Database.books = books;
    }

    public static List<Reader> getReaders() {
        return readers;
    }

    public static void setReaders(List<Reader> readers) {
        Database.readers = readers;
    }
}
