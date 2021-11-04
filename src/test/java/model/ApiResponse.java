package model;

public class ApiResponse {
    String type;
    ApiQuote value;

    public ApiResponse(String type, ApiQuote value) {
        this.type = type;
        this.value = value;
    }

    public ApiResponse() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ApiQuote getValue() {
        return value;
    }

    public void setValue(ApiQuote value) {
        this.value = value;
    }
}
