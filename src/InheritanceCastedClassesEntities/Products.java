package InheritanceCastedClassesEntities;

import java.util.Objects;

public class Products {

    private String name;
    private Double price;

    public Products() {
    }

    public Products(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String tag() {
        return name + " - " + String.format("%.2f", price) +"€";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products)) return false;
        Products products = (Products) o;
        return getName().equals(products.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
