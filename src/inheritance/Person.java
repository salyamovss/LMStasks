package inheritance;

public class Person {
    private String name;
    private String level;

    public Person() {
    }

    public Person(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    public void learn(){
        System.out.println("learning");
    }
    public void walk(){
        System.out.println("walking");
    }

    public void eat(){
        System.out.println("eating");
    }


    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", level='" + level + '\'' +
               '}';
    }
}
