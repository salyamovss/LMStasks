package ArrayList.models;

import ArrayList.models.enums.Gender;
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
                    5 -> Exit
                    ========================
                    """);

            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите название библиотеки: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите адрес библиотеки: ");
                    String address = scanner.nextLine();

                    Library library = new Library(name, address);
                    libraryService.addLibrary(library);

                    System.out.println("✅ Библиотека успешно добавлена с ID: " + library.getId());
                }

                case 2 -> {
                    if (libraryService.getDatabase() != null){
                        for (Library lib : libraryService.getAllLibraries()) {
                            System.out.println("📚 ID: " + lib.getId() + ", Название: " + lib.getName() + ", Адрес: " + lib.getAddress());
                        }
                    }else{
                        System.out.println("you dont have a library");
                    }

                }

                case 3 -> {
                    System.out.print("Full name: ");
                    String fullName = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Phone number: ");
                    String phoneNumber = scanner.nextLine();

                    System.out.print("Gender (MALE/FEMALE): ");
                    Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

                    Reader reader = new Reader(fullName, email, phoneNumber, gender);
                    readerService.saveReader(reader);
                    System.out.println("Reader added successfully.");
                }

                case 4 -> {
                    for (Reader reader : readerService.getAllReaders()) {
                        System.out.println("📖 Reader ID: " + reader.getId() + ", Имя: " + reader.getFullName() + ", Email: " + reader.getEmail() + ", Пол: " + reader.getGender());
                    }
                }

                case 5 -> {
                    System.out.println("👋 Завершение программы...");
                    return;
                }

                default -> System.out.println("⚠️ Неверный выбор! Попробуйте снова.");
            }
        }
    }
}
