package page.bwapp.header;

public enum HeaderSectionHeader {

    HEADER_H1("bWAPP"),
    HEADER_H2("an extremely buggy web app !");

    private final String headerSectionHeader;

    HeaderSectionHeader(String headerSectionHeader) {
        this.headerSectionHeader = headerSectionHeader;
    }

    public String getHeaderSectionHeader() {
        return headerSectionHeader;
    }
}


