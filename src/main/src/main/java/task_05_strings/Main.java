package task_05_strings;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Methods of String class
 */
public class Main {
    private static final String REG_EXP_WHAT = "[\\w]*";
    private static final String CHAR_SEQ = "[\\w]*";
    private static final String DELIMITER = "-----------------------------------";

    public static void main(String[] args) {
        replaceVsReplaceAll();
        System.out.println(DELIMITER);
        try {
            methodsOfString();
        } catch (UnsupportedEncodingException e) {
            System.err.println("Exception while working with strings: " + e);
        }
    }

    /**
     * (Not) cool example with replace and replaceAll methods
     */
    private static void replaceVsReplaceAll() {
        String exampleString = "This gonna stay? [\\w]*";
        System.out.println(exampleString.replace(CHAR_SEQ, "Yes"));
        System.out.println(exampleString.replaceAll(REG_EXP_WHAT, "What??")
                + "\nBe always careful");
    }

    /**
     * Almost all String class methods in action
     * Sorry for code conventions but there is to much boilerplate code
     *
     * @throws UnsupportedEncodingException throws in Constructor with charsetName argument to avoid typo
     */
    private static void methodsOfString() throws UnsupportedEncodingException {
        //Preparations
        StringBuilder builder = new StringBuilder("Hello from builder").append("!");
        StringBuffer buffer = new StringBuffer("Hello from buffer!").append(" don't use me like this :)");
        String workString = "Here Is An Example";
        String workString2 = "here is an example";
        String dummy = "dummy";

        // Constructors
        String string1 = new String();
        String string2 = new String(new char[]{'s','t','r','i','n','g','2'});
        String string3 = new String(new char[]{'s','t','r','i','n','g','3'}, 2, 5);
        String string4 = new String(new int[]{115, 116, 114, 105}, 2, 2);
        String string5 = new String(new byte[]{62, 118, 101, 114, (byte) 196, (byte) 195}, 1, 5,"UTF-8");
        String string6 = new String(new byte[]{62, 118, 101, 114, (byte) 196, (byte) 195}, 1, 5, StandardCharsets.UTF_16);
        String string7 = new String(builder);
        String string8 = new String(buffer);

        // Methods
        String copyExample = String.copyValueOf(new char[] {'h','e','l','l','o'});
        String formatResult = String.format("Hello this is work string 1 %s, and this is dummy %s", workString, dummy);

        // Console output
        // Constructors
        System.out.println("Constructor");
        System.out.println(DELIMITER);
        System.out.println(string1);
        System.out.println(string2);
        System.out.println(string3);
        System.out.println(string4);
        System.out.println(string5);
        System.out.println(string6);
        System.out.println(string7);
        System.out.println(string8);
        System.out.println();
        //Methods
        System.out.println("Methods");
        System.out.println(DELIMITER);
        System.out.println(workString.charAt(4));
        System.out.println(workString.codePointAt(4));
        System.out.println(workString.codePointBefore(5));
        System.out.println(workString.codePointCount(0,3));
        System.out.println(workString.compareTo(workString2));
        System.out.println(workString.compareToIgnoreCase(workString2));
        System.out.println(workString.concat(" " + dummy));
        System.out.println(workString.contains("Example"));
        System.out.println(workString.contentEquals("Example"));
        System.out.println(copyExample);
        System.out.println(workString.endsWith("something?"));
        System.out.println(workString.equals(workString2));
        System.out.println(workString.equalsIgnoreCase(workString2));
        System.out.println(formatResult);
        System.out.println(Arrays.toString(workString.getBytes()));
        System.out.println(workString.hashCode());
        System.out.println(workString.indexOf('E'));
        System.out.println(workString.indexOf('e', 3));
        System.out.println(dummy.intern());
        System.out.println(string1.isEmpty());
        System.out.println(String.join(";","asdfgh"));
        System.out.println(dummy.lastIndexOf("m"));
        System.out.println(dummy.lastIndexOf("mm"));
        System.out.println(dummy.length());
        System.out.println("abcdefg".matches("abcdefg"));
        System.out.println("Hello".replace("e","a"));
        System.out.println(Arrays.toString("Holalala".split("a*")));
        System.out.println("asdfghhjk".substring(4));
        System.out.println(workString.toLowerCase());
        System.out.println(workString.toUpperCase());

    }
}
