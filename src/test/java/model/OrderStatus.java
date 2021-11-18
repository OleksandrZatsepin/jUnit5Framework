package model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {
    PLACED("placed"), APPROVED("approved"), DELIVERED("delivered");

    private final String orderStatus;
    OrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

    @JsonValue
    public String getStatus() {
        return orderStatus;
    }
}
