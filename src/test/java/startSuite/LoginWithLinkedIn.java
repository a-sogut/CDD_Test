package startSuite;

import Utils.Library;
import Utils.TEmulatorUtils;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import Utils.LocalTestConfig;

@DisplayName("Monitoring of different class types")
public class LoginWithLinkedIn extends LocalTestConfig{

    @DisplayName("Test Suite operate class type Anonymous Class")
    @Test
    public void testLogIn() throws InterruptedException {

        Thread.sleep(1500);
        TEmulatorUtils.executeOperation(Library.LOGIN_URL_STRINGS_CLASS);
        Thread.sleep(1500);
    }
}
