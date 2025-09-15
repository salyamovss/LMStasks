package ArrayList.models.db;

public class GenerateId {
    private static Long bookId;
    private static Long libraryId;
    private static Long readerId;

    public static Long genBookId(){
        return ++bookId;
    }
    public static Long genLibraryId(){
        return ++libraryId;
    }
    public static Long genReaderId(){
        return ++readerId;
    }

}
