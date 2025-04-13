package inheritance;

public class Main {
    public static void main(String[] args) {
        Person programmer = new Programmer("Symbat", "Developer", "Peaksoft");
        programmer.eat();
        System.out.println(programmer);
    }
}
