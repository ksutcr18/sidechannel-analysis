package tests.password;
import java.nio.file.*;
import java.util.*;
import java.security.*;
import java.io.*;

public class PasswordConstantNoLengthCheck implements PasswordChecker {
    private static Dictionary d = new Dictionary();

    public static void main(String[] args) throws IOException {
        d.run(new PasswordConstantNoLengthCheck());
    }

    public boolean checkPassword(String s, final String password){
        int res = 0;
         int min = Math.min(s.length(), password.length());
            if (min > 4){
            min = 4;
        }
        for (int i = 0; i < min; i++){
            /*try {
                Thread.sleep(1);
            } catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }*/
            res |= s.charAt(i) ^ password.charAt(i);
        }
        return res == 0;
    }
}