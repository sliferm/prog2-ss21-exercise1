import java.util.regex.*;
import java.lang.String;


public class Password {
    public boolean checkPassword(String password) {
        int i,j;
        char[] checkPassword = password.toCharArray();
        boolean enter = false;
        boolean repeatedNumbers = true;
        boolean consecutiveNumbers = true;
        String strRegEx = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[()#$?!%/@])[a-zA-Z0-9!@#$%^&*](?=\\S+$).{8,15}$";
        String[] strPasswords = {password};
        String check1 = password;
        Pattern stringPattern = Pattern.compile("\\b([0-9])\\1\\1+\\b");
        Matcher m = stringPattern.matcher(check1);

        // Check if more than 4 numbers
        for(i = 0; i < checkPassword.length -3; i++){
            if(Character.isDigit(checkPassword[i]) && Character.isDigit(checkPassword[i+1]) && Character.isDigit(checkPassword[i+2]) && Character.isDigit(checkPassword[i+3]) && checkPassword[i] == checkPassword[i+1] && checkPassword[i] == checkPassword[i+2] && checkPassword[i] == checkPassword[i+3]){
                repeatedNumbers=false;
            }
        }

        // Check upper, lower Case and special sign
        for (String check : strPasswords) {
            if (check.matches(strRegEx)) {
                enter = true;
            } else {
                enter = false;
            }
        }
        //check if consecutive Numbers
        for(j = 0; j < password.length() - 2; j++){
            if(Character.isDigit(checkPassword[i]) && Character.isDigit(checkPassword[i+1]) && Character.isDigit(checkPassword[i+2]) && checkPassword[i] + 1 == checkPassword[i+1] && checkPassword[i+1] + 1 == checkPassword[i+2]){
                consecutiveNumbers = false;
            }
        }

        // Final query and repeat true or false for the question
        if (enter == true && check1.length() >= 8 && check1.length() <= 25 && repeatedNumbers == true && consecutiveNumbers==true) {
            return true;
        } else {
            return false;
        }
    }

}

