package Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import src.Model.Payment;
import src.Model.Register;


public class RegisterTest {
    @BeforeEach
    void setup() {}

    @AfterEach
    void tearDown() {}

    //Test getRegisterBalance
    @Test
    void getRegisterBalanceTest() {
        Register registerTest = new Register();
        double expected = 0;
        double actual = registerTest.getRegisterBalance();
        assertEquals(expected, actual, "getRegisterBalance fails!");
    }

    //Test update the register balance
        @Test
        void updateRegisterBalanceTest() {
            Register registerTest = new Register();
            Payment payment = new Payment(900, 500);
            registerTest.updateRegisterBalance(payment);
            double expected = 500;
            double actual = registerTest.getRegisterBalance();
            assertEquals(expected, actual, "Update the register balancee fails!");
        }
    
}
