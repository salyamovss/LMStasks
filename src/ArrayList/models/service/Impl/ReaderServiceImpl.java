package ArrayList.models.service.Impl;

import ArrayList.models.db.Database;
import ArrayList.models.models.Library;
import ArrayList.models.models.Reader;
import ArrayList.models.service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    public ReaderServiceImpl(Database database) {
    }

    @Override
    public void saveReader(Reader reader) {
        Database.readers.add(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return Database.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader : Database.readers) {
            if (reader.getId().equals(id)) {
                return reader;
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (int i = 0; i < Database.readers.size(); i++) {
            Reader existing = Database.readers.get(i);
            if (existing.getId().equals(id)) {
                existing.setFullName(reader.getFullName());
                existing.setEmail(reader.getEmail());
                existing.setPhoneNumber(reader.getPhoneNumber());
                existing.setGender(reader.getGender());
                return existing;
            }
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        Reader foundReader = null;
        Library foundLibrary = null;

        for (Reader reader : Database.readers) {
            if (reader.getId().equals(readerId)) {
                foundReader = reader;
                break;
            }
        }

        for (Library library : Database.libraries) {
            if (library.getId()==(libraryId)) {
                foundLibrary = library;
                break;
            }
        }

        if (foundReader != null && foundLibrary != null) {
            foundLibrary.getReaders().add(foundReader);
        }
    }
}
