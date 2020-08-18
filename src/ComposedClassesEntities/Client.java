package ComposedClassesEntities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Client {

    private String name;
    private String email;
    private Date birthdate;

    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");

    public Client() {
    }

    public Client(String name, String email, Date birthdate) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return name + " (" + simpleDateFormat.format(birthdate) + ") - " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getName().equals(client.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
