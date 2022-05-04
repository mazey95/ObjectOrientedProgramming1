package Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Integration.DiscountRegistry;



public class DiscountRegistryTest {
    @BeforeEach
    void setup() {}

    @AfterEach
    void tearDown() {}

    //Test checkIfDiscountAvailableTest to see if it returns the right discount when a correct customerID is used
    @Test
    void checkIfDiscountAvailableTest() {
        DiscountRegistry testRegistry = new DiscountRegistry();
        String ID = "1234567890";
        double expected = 0.1;
        double actual = testRegistry.checkIfDiscountAvailable(ID);
        assertEquals(expected, actual, "checkIfDiscountAvailableTest Fails");
    }

    //Test checkIfDiscountAvailableTest to see if it returns no discount if an invalid customerID is used
    @Test
    void checkIfDiscountAvailableTest2() {
        DiscountRegistry testRegistry = new DiscountRegistry();
        String ID = "1111111111";
        double expected = 1.0;
        double actual = testRegistry.checkIfDiscountAvailable(ID);
        assertEquals(expected, actual, "checkIfDiscountAvailableTest2 Fails!");
    }


}