package ComposedClassesEntities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {

    private Date moment;
    private OrderStatus status;
    private Client client;
    private final List<OrderItem> listedOrderItems = new ArrayList<OrderItem>();

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getListedOrderItems() {
        return listedOrderItems;
    }

    public void addItem(OrderItem orderItem){
        listedOrderItems.add(orderItem);
    }

    public void removeItem(OrderItem orderItem){
        listedOrderItems.remove(orderItem);
    }

    public double total(){
        double totalOrderValue=0;
        for(OrderItem orderItem:listedOrderItems){
            totalOrderValue+=orderItem.subTotal();
        }
        return  totalOrderValue;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("Order moment: ");
        sb.append(simpleDateFormat.format(moment)).append("\n");
        sb.append("Order status: ");
        sb.append(status).append("\n");
        sb.append("Client: ");
        sb.append(client).append("\n");
        sb.append("Order items:\n");

        for (OrderItem item : listedOrderItems) {
            sb.append(item).append("\n");
        }
        sb.append("Total price:");
        sb.append(String.format("%.2f"+"€", total()));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getMoment().equals(order.getMoment()) &&
                getStatus() == order.getStatus() &&
                getClient().equals(order.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMoment(), getStatus(), getClient());
    }
}
