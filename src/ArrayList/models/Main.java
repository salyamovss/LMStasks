package ArrayList.models;

import ArrayList.models.enums.Gender;
import ArrayList.models.enums.Genre;
import ArrayList.models.serviceImpl.BookServiceImpl;
import ArrayList.models.serviceImpl.LibraryServiceImpl;
import ArrayList.models.serviceImpl.ReaderServiceImpl;

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
                    \n========= MENU =========
                    1 -> Add Library
                    2 -> Get All Libraries
                    3 -> Add Reader
                    4 -> Get All Readers
                    5 -> Add Book to Library
                    6 -> Get All Books in Library
                    7 -> Exit
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
                    try {
                        System.out.print("Введите название библиотеки: ");
                        String name = scanner.nextLine();
                        System.out.print("Введите адрес библиотеки: ");
                        String address = scanner.nextLine();

                        Library library = new Library(name, address);
                        libraryService.addLibrary(library);

                        System.out.println("Библиотека успешно добавлена с ID: " + library.getId());
                    } catch (Exception e) {
                        System.out.println("Ошибка при добавлении библиотеки: " + e.getMessage());
                    }
                }

                case 2 -> {
                    try {
                        if (!libraryService.getAllLibraries().isEmpty()) {
                            System.out.println("\nВсе библиотеки:");
                            for (Library lib : libraryService.getAllLibraries()) {
                                System.out.println("ID: " + lib.getId() + ", Название: " + lib.getName() + ", Адрес: " + lib.getAddress());
                            }
                        } else {
                            System.out.println("Библиотеки отсутствуют.");
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка при получении списка библиотек: " + e.getMessage());
                    }
                }

                case 3 -> {
                    try {
                        System.out.print("Введите полное имя читателя: ");
                        String fullName = scanner.nextLine();

                        System.out.print("Введите email читателя: ");
                        String email = scanner.nextLine();

                        System.out.print("Введите номер телефона читателя: ");
                        String phoneNumber = scanner.nextLine();

                        Gender gender = null;
                        boolean validGender = false;
                        while (!validGender) {
                            System.out.print("Введите пол (MALE/FEMALE): ");
                            String genderInput = scanner.nextLine().toUpperCase();
                            try {
                                gender = Gender.valueOf(genderInput);
                                validGender = true;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Некорректный пол! Введите MALE или FEMALE.");
                            }
                        }

                        Reader reader = new Reader(fullName, email, phoneNumber, gender);
                        readerService.saveReader(reader);

                        System.out.println("Читатель успешно добавлен с ID: " + reader.getId());
                    } catch (Exception e) {
                        System.out.println("Ошибка при добавлении читателя: " + e.getMessage());
                    }
                }

                case 4 -> {
                    try {
                        if (!readerService.getAllReaders().isEmpty()) {
                            System.out.println("\nВсе читатели:");
                            for (Reader reader : readerService.getAllReaders()) {
                                System.out.println("Reader ID: " + reader.getId() +
                                                   ", Имя: " + reader.getFullName() +
                                                   ", Email: " + reader.getEmail() +
                                                   ", Телефон: " + reader.getPhoneNumber() +
                                                   ", Пол: " + reader.getGender());
                            }
                        } else {
                            System.out.println("Читатели отсутствуют.");
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка при получении списка читателей: " + e.getMessage());
                    }
                }

                case 5 -> {
                    try {
                        System.out.print("Введите ID библиотеки для добавления книги: ");
                        Long libraryId = scanner.nextLong();
                        scanner.nextLine();

                        System.out.print("Введите название книги: ");
                        String bookName = scanner.nextLine();

                        System.out.print("Введите автора книги: ");
                        String author = scanner.nextLine();

                        System.out.print("Выберите жанр книги: ");
                        Genre genre = Genre.valueOf(scanner.nextLine());
                        scanner.nextLine();

                        Book book = new Book(bookName, author, genre);
                        bookService.saveBook(libraryId, book);

                        System.out.println("Книга успешно добавлена в библиотеку с ID: " + libraryId);
                    } catch (Exception e) {
                        System.out.println("Ошибка при добавлении книги: " + e.getMessage());
                    }
                }

                case 6 -> {
                    try {
                        System.out.print("Введите ID библиотеки для вывода всех книг: ");
                        Long libraryId = scanner.nextLong();
                        scanner.nextLine();

                        if (!bookService.getAllBooks(libraryId).isEmpty()) {
                            System.out.println("\nВсе книги в библиотеке с ID " + libraryId + ":");
                            for (Book book : bookService.getAllBooks(libraryId)) {
                                System.out.println("ID: " + book.getId() + ", Название: " + book.getName() + ", Автор: " + book.getAuthor() + ", Год: " + book.getGenre());
                            }
                        } else {
                            System.out.println("Книги отсутствуют в библиотеке с ID " + libraryId);
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка при получении списка книг: " + e.getMessage());
                    }
                }

                case 7 -> {
                    System.out.println("Завершение программы... До свидания!");
                    return;
                }

                default -> System.out.println("Неверный выбор! Пожалуйста, попробуйте снова.");
            }
        }
    }
}
