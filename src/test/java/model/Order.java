package model;


import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

import java.util.Random;

public class Order {
    public static final String PLACED_STATUS = "placed";
    public static final String APPROVED_STATUS = "approved";
    public static final String DELIVERED_STATUS = "delivered";

    private Long id;
    private Long petId;
    private Integer quantity;
    private DateAndTime shipDate;
    private String status;
    private Boolean complete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public DateAndTime getShipDate() {
        return shipDate;
    }

    public void setShipDate(DateAndTime shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public static Order getDefaultOrder() {
        final Order order = new Order();
        order.setId(new Random().nextLong());
        order.setPetId(new Random().nextLong());
        order.setQuantity(new Random().nextInt());
        order.setShipDate(new Faker().date());
        order.setStatus(PLACED_STATUS);
        order.setComplete(new Random().nextBoolean());
        return order;
    }
}
