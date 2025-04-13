package ArrayList.models.serviceImpl;

import ArrayList.models.Database;
import ArrayList.models.Library;
import ArrayList.models.service.LibraryService;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    private Database database;

    public LibraryServiceImpl(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public void addLibrary(Library library) {
        library.setId(database.getLastLibraryId() + 1); // Присваиваем новый ID, увеличив последний
        database.getLibraries().add(library);
        database.setLastLibraryId(library.getId()); // Обновляем последний использованный ID
    }

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        database.getLibraries().addAll(libraries);
        return database.getLibraries();
    }

    @Override
    public List<Library> getAllLibraries() {
        return database.getLibraries();
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : database.getLibraries()) {
            if (library.getId() == id) {
                return library;
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (int i = 0; i < database.getLibraries().size(); i++) {
            if (database.getLibraries().get(i).getId() == id) {
                database.getLibraries().set(i, library);
                return library;
            }
        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        for (int i = 0; i < database.getLibraries().size(); i++) {
            if (database.getLibraries().get(i).getId() == id) {
                database.getLibraries().remove(i);
                return "Library deleted.";
            }
        }
        return "Library not found.";
    }
}
