package tests.uitest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import page.bwapp.main.MainSectionPath;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends BaseUiTest{

    @DisplayName("Check if Page opened by path:")
    @ParameterizedTest
    @EnumSource(MainSectionPath.class)
    void shouldOpenPageByPath(MainSectionPath mainSectionPath) {
        mainPage.open(mainSectionPath.getMainSectionPath());

        assertThat(driver.getCurrentUrl()).contains(mainSectionPath.getMainSectionPath());
    }
}
