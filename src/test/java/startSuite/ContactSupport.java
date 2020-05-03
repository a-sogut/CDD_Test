package startSuite;

import Utils.Library;
import Utils.TEmulatorUtils;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import Utils.LocalTestConfig;

import static org.junit.Assert.assertEquals;

@DisplayName("Monitoring of different class types")
public class ContactSupport extends LocalTestConfig{

    @DisplayName("Test For Validating Fail Heuristic")
    @Test
    public void testContact() throws InterruptedException {

        Thread.sleep(1500);
        TEmulatorUtils.executeOperation(Library.FAIL_SCENARIO);
        Thread.sleep(1500);

        assertEquals("Fail on purpose", 1, 0);
        Thread.sleep(1500);
    }
}
