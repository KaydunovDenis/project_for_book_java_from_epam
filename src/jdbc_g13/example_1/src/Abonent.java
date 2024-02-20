package jdbc_g13.example_1.src;

public class Abonent extends jdbc_g13.example_1.src.Entity
{
    private int id;
    private String name;
    private int phone;

    public Abonent(int id, String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String toString() {
        return new StringBuilder("Abonent{")
                .append("id=")
                .append(id)
                .append(", name='")
                .append(name)
                .append('\'')
                .append(", phone=")
                .append(phone)
                .append('}')
                .toString();
    }
}
