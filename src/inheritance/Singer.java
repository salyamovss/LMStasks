package inheritance;

public class Singer extends Person{
    private String bandName;


    public Singer() {
    }

    public Singer(String bandName) {
        this.bandName = bandName;
    }

    public Singer(String name, String level, String bandName) {
        super(name, level);
        this.bandName = bandName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    @Override
    public void learn() {
        super.learn();
    }

    @Override
    public void walk() {
        super.walk();
    }

    @Override
    public void eat() {
        super.eat();
    }

    public void sing(){
        System.out.println("singer singing");
    }

    public void playGuitar(){
        System.out.println("singer playing guitar");
    }

    @Override
    public String toString() {
        return super.toString() + bandName;
    }
}
