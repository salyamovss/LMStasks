package ArrayList.models;

import ArrayList.models.db.Database;
import ArrayList.models.enums.Gender;
import ArrayList.models.enums.Genre;
import ArrayList.models.models.Book;
import ArrayList.models.models.Library;
import ArrayList.models.models.Reader;
import ArrayList.models.service.Impl.BookServiceImpl;
import ArrayList.models.service.Impl.LibraryServiceImpl;
import ArrayList.models.service.Impl.ReaderServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        LibraryServiceImpl libraryService = new LibraryServiceImpl(database);
        BookServiceImpl bookService = new BookServiceImpl(database);
        ReaderServiceImpl readerService = new ReaderServiceImpl(database);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    
                    ========= МЕНЮ =========
                    1  -> Добавить библиотеку
                    2  -> Показать все библиотеки
                    3  -> Найти библиотеку по ID
                    4  -> Обновить библиотеку
                    5  -> Удалить библиотеку
                    6  -> Добавить читателя
                    7  -> Показать всех читателей
                    8  -> Найти читателя по ID
                    9  -> Обновить данные читателя
                    10 -> Прикрепить читателя к библиотеке
                    11 -> Добавить книгу в библиотеку
                    12 -> Показать все книги в библиотеке
                    13 -> Найти книгу по ID
                    14 -> Удалить книгу из библиотеки
                    15 -> Очистить все книги в библиотеке
                    0  -> Выйти из программы
                    ========================
                    """);

            System.out.print("Выберите опцию: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректное число!");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите название библиотеки: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите адрес библиотеки: ");
                    String address = scanner.nextLine();
                    Library library = new Library(name, address);
                    libraryService.addLibrary(library);
                    System.out.println("✅ Библиотека добавлена с ID: " + library.getId());
                }

                case 2 -> {
                    if (!libraryService.getAllLibraries().isEmpty()) {
                        System.out.println("\nВсе библиотеки:");
                        for (Library lib : libraryService.getAllLibraries()) {
                            System.out.println(lib);
                        }
                    } else {
                        System.out.println("Библиотек нет.");
                    }
                }

                case 3 -> {
                    System.out.print("Введите ID библиотеки: ");
                    long id = Long.parseLong(scanner.nextLine());
                    Library lib = libraryService.getLibraryById(id);
                    System.out.println(lib != null ? lib : "❌ Библиотека не найдена!");
                }

                case 4 -> {
                    System.out.print("Введите ID библиотеки для обновления: ");
                    long id = Long.parseLong(scanner.nextLine());
                    System.out.print("Введите новое название: ");
                    String newName = scanner.nextLine();
                    System.out.print("Введите новый адрес: ");
                    String newAddress = scanner.nextLine();
                    Library updated = new Library(newName, newAddress);
                    updated.setId(id);
                    Library result = libraryService.updateLibrary(id, updated);
                    System.out.println(result != null ? "✅ Обновлено: " + result : "❌ Библиотека не найдена!");
                }

                case 5 -> {
                    System.out.print("Введите ID библиотеки для удаления: ");
                    long id = Long.parseLong(scanner.nextLine());
                    System.out.println(libraryService.deleteLibrary(id));
                }
                case 6 -> {
                    System.out.print("Введите полное имя: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Введите email: ");
                    String email = scanner.nextLine();
                    System.out.print("Введите телефон: ");
                    String phone = scanner.nextLine();

                    Gender gender = null;
                    while (gender == null) {
                        System.out.print("Введите пол (MALE/FEMALE): ");
                        try {
                            gender = Gender.valueOf(scanner.nextLine().toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("❌ Некорректный пол!");
                        }
                    }

                    Reader reader = new Reader(fullName, email, phone, gender);
                    readerService.saveReader(reader);
                    System.out.println("✅ Читатель добавлен с ID: " + reader.getId());
                }

                case 7 -> {
                    if (!readerService.getAllReaders().isEmpty()) {
                        System.out.println("\nВсе читатели:");
                        for (Reader r : readerService.getAllReaders()) {
                            System.out.println(r);
                        }
                    } else {
                        System.out.println("Читателей нет.");
                    }
                }

                case 8 -> {
                    System.out.print("Введите ID читателя: ");
                    long id = Long.parseLong(scanner.nextLine());
                    Reader reader = readerService.getReaderById(id);
                    System.out.println(reader != null ? reader : "❌ Читатель не найден!");
                }

                case 9 -> {
                    System.out.print("Введите ID читателя: ");
                    long id = Long.parseLong(scanner.nextLine());
                    System.out.print("Введите новое имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите новый email: ");
                    String email = scanner.nextLine();
                    System.out.print("Введите новый телефон: ");
                    String phone = scanner.nextLine();
                    System.out.print("Введите пол (MALE/FEMALE): ");
                    Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

                    Reader updated = new Reader(name, email, phone, gender);
                    updated.setId(id);
                    Reader result = readerService.updateReader(id, updated);
                    System.out.println(result != null ? "✅ Обновлён: " + result : "❌ Читатель не найден!");
                }

                case 10 -> {
                    System.out.print("Введите ID читателя: ");
                    long readerId = Long.parseLong(scanner.nextLine());
                    System.out.print("Введите ID библиотеки: ");
                    long libraryId = Long.parseLong(scanner.nextLine());
                    readerService.assignReaderToLibrary(readerId, libraryId);
                    System.out.println("✅ Читатель прикреплён к библиотеке!");
                }
                case 11 -> {
                    System.out.print("Введите ID библиотеки: ");
                    long libId = Long.parseLong(scanner.nextLine());
                    System.out.print("Введите название книги: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine();

                    Genre genre = null;
                    while (genre == null) {
                        System.out.print("Введите жанр (FANTASY, HISTORY, SCIENCE, DETECTIVE): ");
                        try {
                            genre = Genre.valueOf(scanner.nextLine().toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("❌ Неверный жанр!");
                        }
                    }

                    Book book = new Book(bookName, author, genre);
                    bookService.saveBook(libId, book);
                    System.out.println("✅ Книга добавлена с ID: " + book.getId());
                }

                case 12 -> {
                    System.out.print("Введите ID библиотеки: ");
                    long libId = Long.parseLong(scanner.nextLine());
                    if (!bookService.getAllBooks(libId).isEmpty()) {
                        System.out.println("Книги в библиотеке " + libId + ":");
                        for (Book b : bookService.getAllBooks(libId)) {
                            System.out.println(b);
                        }
                    } else {
                        System.out.println("❌ Книг нет.");
                    }
                }

                case 13 -> {
                    System.out.print("Введите ID библиотеки: ");
                    long libId = Long.parseLong(scanner.nextLine());
                    System.out.print("Введите ID книги: ");
                    long bookId = Long.parseLong(scanner.nextLine());
                    Book book = bookService.getBookById(libId, bookId);
                    System.out.println(book != null ? book : "❌ Книга не найдена!");
                }

                case 14 -> {
                    System.out.print("Введите ID библиотеки: ");
                    long libId = Long.parseLong(scanner.nextLine());
                    System.out.print("Введите ID книги: ");
                    long bookId = Long.parseLong(scanner.nextLine());
                    System.out.println(bookService.deleteBook(libId, bookId));
                }

                case 15 -> {
                    System.out.print("Введите ID библиотеки: ");
                    long libId = Long.parseLong(scanner.nextLine());
                    bookService.clearBooksByLibraryId(libId);
                    System.out.println("✅ Все книги удалены из библиотеки " + libId);
                }

                case 0 -> {
                    System.out.println("Завершение программы...");
                    return;
                }

                default -> System.out.println("❌ Неверный выбор!");
            }
        }
    }
}
