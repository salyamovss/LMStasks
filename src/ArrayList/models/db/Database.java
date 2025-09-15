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

}
