package inheritance;

public class Programmer extends Person{
    private String companyName;

    public Programmer() {
    }

    public Programmer(String companyName) {
        this.companyName = companyName;
    }

    public Programmer(String name, String level, String companyName) {
        super(name, level);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void eat() {
        System.out.println("programmer eating");
    }

    @Override
    public void walk() {
        System.out.println("programmer walking");
    }

    @Override
    public void learn() {
        System.out.println("programmer learning");
    }
    public void coding(){
        System.out.println(getName() + "coding in " + companyName + "company");
    }


}
