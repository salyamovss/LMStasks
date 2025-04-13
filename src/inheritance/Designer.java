package inheritance;

public class Designer extends Person{
    private String groupName;

    public Designer() {
    }

    public Designer(String groupName) {
        this.groupName = groupName;
    }

    public Designer(String name, String level, String groupName) {
        super(name, level);
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public void learn() {
        System.out.println("designer learning");
    }

    @Override
    public void walk() {
        System.out.println("designer walking");
    }

    @Override
    public void eat() {
        System.out.println("designer eating");
    }

    public void design(){
        System.out.println("designer working");
    }

    @Override
    public String toString() {
        return super.toString() + groupName;
    }
}
