package model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PetStatus {
    AVAILABLE("available"), PENDING("pending"), SOLD("sold");

    private final String petStatus;

    PetStatus(String petStatus) {
        this.petStatus = petStatus;
    }

    @JsonValue
    public String getStatus() {
        return petStatus;
    }
}
