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
    void correctPassword() {
        Password password = new Password();
        boolean testCase = password.checkPassword("H@23u2anAsd");
        assertTrue(testCase);
    }

    @Test
    @DisplayName("checking return false because the password is to short")
    void toShortPassword () {
        Password password = new Password();
        boolean testCase = password.checkPassword("H@23u");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("checking return false because the password is to long")
    void toLongPassword () {
        Password password = new Password();
        boolean testCase = password.checkPassword("H@23ukasdlnlknasdklnasdlkn");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("checking if there is a uppercase letter and return true")
    void UpperCase () {
        Password password = new Password();
        boolean testCase = password.checkPassword("H@ksjd34s");
        assertTrue(testCase);
    }
    @Test
    @DisplayName("checking if there is a uppercase letter and return false because there are only lowercase")
    void noUpperCase () {
        Password password = new Password();
        boolean testCase = password.checkPassword("h@ksjd34ss");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("checking if there is a lowercase letter and return false because there are only uppercase")
    void noLowerCase () {
        Password password = new Password();
        boolean testCase = password.checkPassword("HSJ@2LAN982");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("There are only lowercase letters and return false")
    void onlyLowerCase () {
        Password password = new Password();
        boolean testCase = password.checkPassword("asjnsdnflksdf");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("There are only UPPERCASE letters and return false")
    void onlyUpperCase () {
        Password password = new Password();
        boolean testCase = password.checkPassword("ASDASFDSGSGÖKSDÖLKS");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("checking if there is a special sign and return false because no special sign")
    void noSpecialSign () {
        Password password = new Password();
        boolean testCase = password.checkPassword("HSJkla2LAN982");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("only special signs so it returns false")
    void allSpecialSigns () {
        Password password = new Password();
        boolean testCase = password.checkPassword("()#$?!%/@");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("Thera are a false special Sign and return false")
    void falseSpecialSigns () {
        Password password = new Password();
        boolean testCase = password.checkPassword("HSJkla2LAN982+");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("the password is emtpy and return false")
    void emptyPassword() {
        Password password = new Password();
        boolean testCase = password.checkPassword("");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("there is a space on position 6 and return false")
    void whiteSpace() {
        Password password = new Password();
        boolean testCase = password.checkPassword("HSJk@ la2LAN982");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("there is a space on position 1 and return false")
    void spaceBegin() {
        Password password = new Password();
        boolean testCase = password.checkPassword(" HSJk@la2LAN982");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("there is a space on position 15 and return false")
    void spaceEnd() {
        Password password = new Password();
        boolean testCase = password.checkPassword("HSJk@la2LAN982 ");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("there are two consecutive Numbers and it will be ok and return true")
    void consecutiveNumbers() {
        Password password = new Password();
        boolean testCase = password.checkPassword("HSJk@l12u");
        assertTrue(testCase);
    }
    @Test
    @DisplayName("there are two reverse consecutive Numbers and it will be ok and return true")
    void consecutiveNumbers1() {
        Password password = new Password();
        boolean testCase = password.checkPassword("HSJk@l21k");
        assertTrue(testCase);
    }
    @Test
    @DisplayName("there are three reverse consecutive Numbers and it will be not ok and return true")
    void consecutiveNumbers2() {
        Password password = new Password();
        boolean testCase = password.checkPassword("HSJk@l321");
        assertTrue(testCase);
    }
    @Test
    @DisplayName("there are three  consecutive Numbers and it will be ok and return false")
    void consecutiveNumbers3() {
        Password password = new Password();
        boolean testCase = password.checkPassword("HSJk@l123");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("Two times the same number and return true")
    void repeatedNumbers() {
        Password password = new Password();
        boolean testCase = password.checkPassword("HSJk@l133");
        assertTrue(testCase);
    }
    @Test
    @DisplayName("Four times the same number and return false")
    void repeatedNumbers1() {
        Password password = new Password();
        boolean testCase = password.checkPassword("H@23u2anAs9999");
        assertFalse(testCase);
    }
    @Test
    @DisplayName("Three times the same letter and return true")
    void repeatedLetters() {
        Password password = new Password();
        boolean testCase = password.checkPassword("HSJk@l103aaa");
        assertTrue(testCase);
    }
    @Test
    @DisplayName("Three times the same special Sign and return true")
    void repeatedSigns() {
        Password password = new Password();
        boolean testCase = password.checkPassword("HSJk@l1033@@@");
        assertTrue(testCase);
    }
    @Test
    @DisplayName("Only numbers but not consecutive and not repeating")
    void onlyNumbers() {
        Password password = new Password();
        boolean testCase = password.checkPassword("14129482912093");
        assertFalse(testCase);
    }


}
