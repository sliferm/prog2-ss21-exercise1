import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PasswordTest {
    @BeforeAll
    static void init() {}

    @BeforeEach
    void setUp() {}

    @Test
    @DisplayName("checking return true, is all fine")
    void testCheckLength1() {
        //check length --> too short
        Password password = new Password();
        boolean actual = password.checkPassword("H@23uabwekl");
        assertTrue(actual);
    }
}
