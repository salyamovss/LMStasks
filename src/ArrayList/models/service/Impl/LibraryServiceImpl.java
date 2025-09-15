package ArrayList.models.service.Impl;

import ArrayList.models.db.Database;
import ArrayList.models.models.Library;
import ArrayList.models.service.LibraryService;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    public LibraryServiceImpl(Database database) {
    }

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        Database.libraries.addAll(libraries);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return Database.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : Database.libraries) {
            if (library.getId()==(id)) {
                return library;
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (int i = 0; i < Database.libraries.size(); i++) {
            Library existing = Database.libraries.get(i);
            if (existing.getId()==(id)) {
                existing.setName(library.getName());
                existing.setAddress(library.getAddress());
                return existing;
            }
        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        for (int i = 0; i < Database.libraries.size(); i++) {
            if (Database.libraries.get(i).getId()==(id)) {
                Database.libraries.remove(i);
                return "Library deleted!";
            }
        }
        return "Library not found!";
    }

    @Override
    public void addLibrary(Library library) {
        Database.libraries.add(library);
    }
}
