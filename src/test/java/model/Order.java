package model;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import util.DataGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Order {

    private Long id;
    private Long petId;
    private Integer quantity;
    private DateAndTime shipDate;
//    private String shipDate;
    private OrderStatus status;
    private Boolean complete;

    public static Order getDefaultOrder(OrderStatus status) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sZ");
        Date date = new Date(System.currentTimeMillis());
        final Order order = new Order();
        order.setId(DataGenerator.randomId());
        order.setPetId(DataGenerator.randomId());
        order.setQuantity(new Random().nextInt());
//        order.setShipDate();
        order.setStatus(status);
        order.setComplete(true);
        return order;
    }
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

//    public String getShipDate() {
//        return shipDate;
//    }
//
//    public void setShipDate(String shipDate) {
//        this.shipDate = shipDate;
//    }

    public DateAndTime getShipDate() {
        return shipDate;
    }

    public void setShipDate(DateAndTime shipDate) {
        this.shipDate = shipDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }


}
