package startSuite;

import Utils.Library;
import Utils.TEmulatorUtils;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import Utils.LocalTestConfig;

@DisplayName("Monitoring of different class types")
public class LoginWithGoogle extends LocalTestConfig{

    @DisplayName("Send Several Tests Suites")
    @Test
    public void testLogIn() throws InterruptedException {

        Thread.sleep(1500);
        //TEmulatorUtils.executeOperation(Library.PAYMENT);

        TEmulatorUtils.executeOperation(Library.LOGIN_URL_STRINGS_CLASS);

        TEmulatorUtils.executeOperation(Library.INNERC_LASS_LIBRARY);

        runOperationXtimes(2, Library.SECOND_LEVEL_PKG_CLASS);
        Thread.sleep(1500);
    }

    private void runOperationXtimes (int numOfItr, Library operation) {
        for (int i=0; i < numOfItr; i++) {
            TEmulatorUtils.executeOperation(operation);
        }
    }
}
