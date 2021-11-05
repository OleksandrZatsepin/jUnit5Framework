/*
  Doesn't work yet
 */

package util;

import io.qameta.allure.Step;

public class AllureStepLogger {
    private AllureStepLogger() {}

    @Step("{0}")
    public static void log(final String message) {
        // Should be empty, only step annotation will be used.
    }
}
