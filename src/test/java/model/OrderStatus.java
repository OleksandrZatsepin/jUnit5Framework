package model;

public enum OrderStatus {
    PLACED("placed"), APPROVED("approved"), DELIVERED("delivered");
    private final String status;
    OrderStatus(String status) {
            this.status = status;
        }
    public String toString(){
            return status;
        }
}
