package jdbc_g13.example_6.model;

public class Abonent extends Entity
{
    private int id;
    private String name;
    private int phone;

    public Abonent()
    {
    }

    public Abonent(int id, String name, int phone)
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getPhone()
    {
        return phone;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public String toString()
    {
        return new StringBuilder("\nAbonent{").append("id=").append(id).append(", name='")
            .append(name).append('\'').append(", phone=").append(phone).append('}').toString();
    }
}
