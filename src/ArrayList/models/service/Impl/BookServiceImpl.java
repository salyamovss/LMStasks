package ArrayList.models.service.Impl;

import ArrayList.models.models.Book;
import ArrayList.models.models.Library;
import ArrayList.models.db.Database;
import ArrayList.models.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    public BookServiceImpl(Database database) {
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                library.getBooks().add(book);
                Database.books.add(book);
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                return library.getBooks();
            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                for (Book book : library.getBooks()) {
                    if (library.getId() == libraryId) {
                        return book;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                List<Book> books = library.getBooks();
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getId()==(bookId)) {
                        books.remove(i);
                        for (int j = 0; j < Database.books.size(); j++) {
                            if (Database.books.get(j).getId()==(bookId)) {
                                Database.books.remove(j);
                                break;
                            }
                        }
                        return "Book deleted!";
                    }
                }
                return "Book not found!";
            }
        }
        return "Library not found!";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library : Database.libraries) {
            if (library.getId()==(libraryId)) {
                library.getBooks().clear();
            }
        }
    }
}
