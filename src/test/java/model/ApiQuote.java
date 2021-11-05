package model;

public class ApiQuote {
    private Integer id;
    String quote;

    public ApiQuote(Integer id, String quote) {
        this.id = id;
        this.quote = quote;
    }

    public ApiQuote() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
