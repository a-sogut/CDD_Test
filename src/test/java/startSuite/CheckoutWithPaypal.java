package startSuite;

import Utils.Library;
import Utils.TEmulatorUtils;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import Utils.LocalTestConfig;

@DisplayName("Monitoring of different class types")
public class CheckoutWithPaypal extends LocalTestConfig{
    
    public static String merchandId="fj7cjjbe4t56f";

    @DisplayName("Agent accept Start After Start Without Stop in the middle")
    @Test
    public void testCheckout() throws InterruptedException {

        Thread.sleep(1500);
        TEmulatorUtils.executeOperation(Library.PAYMENT);

        TEmulatorUtils.executeOperation(Library.CENTRAL_LIBRARY);
        Thread.sleep(1500);
    }
}
