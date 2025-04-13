package ArrayList.models.serviceImpl;

import ArrayList.models.Database;
import ArrayList.models.Library;
import ArrayList.models.Reader;
import ArrayList.models.service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private Database database;

    public ReaderServiceImpl(Database database) {
        this.database = database;
    }

    public ReaderServiceImpl() {
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public void saveReader(Reader reader) {
        database.getReaders().add(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return database.getReaders();
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader : database.getReaders()) {
            if (reader.getId().equals(id)) {
                return reader;
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader updatedReader) {
        for (Reader reader : database.getReaders()) {
            if (reader.getId().equals(id)) {
                reader.setFullName(updatedReader.getFullName());
                reader.setEmail(updatedReader.getEmail());
                reader.setPhoneNumber(updatedReader.getPhoneNumber());
                reader.setGender(updatedReader.getGender());
                return reader;
            }
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        Reader reader = getReaderById(readerId);
        for (Library library : database.getLibraries()) {
            if (library.getId() == (libraryId)) {
                library.getReaders().add(reader);
                break;
            }
        }
    }
}
