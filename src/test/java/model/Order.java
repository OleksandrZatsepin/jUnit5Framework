package model;


import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import static java.time.format.DateTimeFormatter.ISO_INSTANT;

public class Order {
    public static final String PLACED_STATUS = "placed";
    public static final String APPROVED_STATUS = "approved";
    public static final String DELIVERED_STATUS = "delivered";

    private Long id;
    private Long petId;
    private Integer quantity;
//    private DateAndTime shipDate;
    private String shipDate;
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

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    //    public DateAndTime getShipDate() {
//        return shipDate;
//    }
//
//    public void setShipDate(DateAndTime shipDate) {
//        this.shipDate = shipDate;
//    }

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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sZ");
        Date date = new Date(System.currentTimeMillis());
        final Order order = new Order();
        order.setId(new Random().nextLong());
        order.setPetId(new Random().nextLong());
        order.setQuantity(new Random().nextInt());
        order.setShipDate(formatter.format(date));
        order.setStatus(PLACED_STATUS);
        order.setComplete(true);
        return order;
    }
}
