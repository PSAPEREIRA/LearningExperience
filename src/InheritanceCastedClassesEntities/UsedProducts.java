package InheritanceCastedClassesEntities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class UsedProducts extends Products {

    private Date manufactureDate;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

    public UsedProducts() {
        super();
    }

    public UsedProducts(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String tag() {
        return  getName()
                + " - "
                + String.format("%.2f", getPrice())
                + "€"
                + "(Manufacture date:"
                + sdf.format(manufactureDate)
                +")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products)) return false;
        if (!super.equals(o)) return false;
        UsedProducts that = (UsedProducts) o;
        return super.getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), super.getName());
    }
}
