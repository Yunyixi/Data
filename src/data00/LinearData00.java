package data00;

public class LinearData00 {
    private String name;

    public LinearData00() {

    }

    public LinearData00(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LinearData00{" +
                "name='" + name + '\'' +
                '}';
    }
}
