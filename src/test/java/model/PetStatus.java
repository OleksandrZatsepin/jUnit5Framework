package model;

public enum PetStatus {
    AVAILABLE("available"), PENDING("pending"), SOLD("sold");
    private final String status;
    PetStatus(String status) {
        this.status = status;
    }
    public String toString(){
        return status;
    }
}
