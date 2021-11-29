package page.bwapp.main;

public enum MainSectionHeader {

    HOME_PAGE_H1("Home"),
    BUGS_PAGE_H1("Bugs"),
    DOWNLOAD_PAGE_H1("Download"),
    TRAINING_PAGE_H1("Talks & Training"),
    BLOG_PAGE_H1("Blog");

    private final String mainSectionHeader;

    MainSectionHeader(String mainSectionHeader) {
        this.mainSectionHeader = mainSectionHeader;
    }

    public String getMainSectionHeader() {
        return mainSectionHeader;
    }
}
