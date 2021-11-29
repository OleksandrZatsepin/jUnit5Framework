package page.bwapp.main;

public enum MainSectionPath {

    HOME_PAGE_PATH("index.htm"),
    BUGS_PAGE_PATH("bugs.htm"),
    DOWNLOAD_PAGE_PATH("download.htm"),
    TRAINING_PAGE_PATH("training.htm");

    private final String mainSectionPath;

    MainSectionPath(String mainSectionPath) {
        this.mainSectionPath = mainSectionPath;
    }

    public String getMainSectionPath() {
        return mainSectionPath;
    }
}
