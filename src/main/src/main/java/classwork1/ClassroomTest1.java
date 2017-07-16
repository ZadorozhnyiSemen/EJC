package classwork1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClassroomTest1 {
    public static void main(String[] args) {
        ClassroomTest1 classroomTest1 = new ClassroomTest1();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String userInput = reader.readLine();
            classroomTest1.getOnlyOddChars1(userInput);
            classroomTest1.getOnlyOddChars2(userInput);
            System.out.println(classroomTest1.isPolarEqual1(userInput));
            System.out.println(classroomTest1.isPolarEqual2(userInput));
            System.out.println(classroomTest1.isPolarEqual3(userInput) == 0 ? "Yes" : "No");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Is input string is palindrome first version with equals
     * @param userInput user's string from console
     * @return true if palindrome, otherwise false
     */
    private boolean isPolarEqual1(String userInput) {
        userInput = userInput.replace(" ", "");
        StringBuilder stringBuilder = new StringBuilder(userInput);
        return stringBuilder.equals(stringBuilder.reverse());
    }

    /**
     * Is input string is palindrome second version with chars
     * @param userInput user's string from console
     * @return true if palindrome, otherwise false
     */
    private boolean isPolarEqual2(String userInput) {
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

    /**
     * Is input string is palindrome third version with compareTo
     * @param userInput user's string from console
     * @return true if palindrome, otherwise false
     */
    private int isPolarEqual3(String userInput) {
        userInput = userInput.replace(" ", "");
        StringBuilder stringBuilder = new StringBuilder(userInput);
        return stringBuilder.toString().compareTo(stringBuilder.reverse().toString());
    }

    /**
     * Prints in console only odd chars of given string
     * @param userInput user's string from console
     */
    private void getOnlyOddChars1(String userInput) {
        StringBuilder resultString = new StringBuilder();
        char[] oddChars = userInput.toCharArray();
        for (int i = 0; i < oddChars.length; i++) {
            if (i % 2 == 0) {
                resultString.append(oddChars[i]);
            }
        }
        System.out.println(resultString);
    }

    /**
     * Prints in console only odd chars of given string
     * (faster)
     * @param userInput user's string from console
     */
    private void getOnlyOddChars2(String userInput) {
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < userInput.length(); i += 2) {
            resultString.append(userInput.charAt(i));
        }
        System.out.println(resultString);
    }
}
