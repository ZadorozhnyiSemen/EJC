package epam.core.classwork1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClassroomTest1 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String userInput = reader.readLine();
            // UNCOMMENT 1 TO TEST
            //getOnlyOddChars1(userInput);
            //getOnlyOddChars2(userInput);
            //System.out.println(isPolarEqual1(userInput));
            //System.out.println(isPolarEqual2(userInput));
            //System.out.println(isPolarEqual3(userInput) == 0 ? "DADADA" : "NET");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPolarEqual1(String userInput) {
        userInput = userInput.replace(" ", "");
        StringBuilder stringBuilder = new StringBuilder(userInput);
        return stringBuilder.equals(stringBuilder.reverse());
    }

    private static boolean isPolarEqual2(String userInput) {
        userInput = userInput.replace(" ", "");
        System.out.println(userInput);
        StringBuilder sb = new StringBuilder(userInput);
        String temp = sb.reverse().toString();
        System.out.println(temp);
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) != temp.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static int isPolarEqual3(String userInput) {
        userInput = userInput.replace(" ", "");
        StringBuilder stringBuilder = new StringBuilder(userInput);
        return stringBuilder.toString().compareTo(stringBuilder.reverse().toString());
    }

    private static void getOnlyOddChars1(String userInput) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder resultString = new StringBuilder();
            char[] oddChars = userInput.toCharArray();
            for (int i = 0; i < oddChars.length; i++) {
                if (i % 2 == 0) {
                    resultString.append(oddChars[i]);
                }
            }
            System.out.println(resultString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getOnlyOddChars2(String userInput) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder resultString = new StringBuilder();
            for (int i = 0; i < userInput.length(); i+=2) {
                resultString.append(userInput.charAt(i));
            }
            System.out.println(resultString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
