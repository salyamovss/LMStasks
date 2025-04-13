package ArrayList.models.serviceImpl;

import ArrayList.models.Book;
import ArrayList.models.Database;
import ArrayList.models.Library;
import ArrayList.models.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    private Database database;

    public BookServiceImpl() {

    }

    public BookServiceImpl(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library library : database.getLibraries()) {
            if (library.getId() == libraryId) {
                library.getBooks().add(book);
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for (Library library : database.getLibraries()) {
            if (library.getId() == libraryId) {
                return library.getBooks();
            }
        }
        return new ArrayList<>();
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library : database.getLibraries()) {
            if (library.getId() == libraryId) {
                for (Book book : library.getBooks()) {
                    if (book.getId() == bookId) {
                        return book;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library : database.getLibraries()) {
            if (library.getId() == libraryId) {
                List<Book> books = library.getBooks();
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getId() == bookId) {
                        books.remove(i);
                        return "Book deleted.";
                    }
                }
            }
        }
        return "Book not found.";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library : database.getLibraries()) {
            if (library.getId() == libraryId) {
                library.setBooks(new ArrayList<>());
                break;
            }
        }
    }
}
