package java.epam.core.classwork2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String inputString = "jvvskljshhhhbvlsekrjjjjjvsvnjklrsnjfjgjgffkfdkr";
        int maxAppears = main.findMaxAppear(inputString);
        System.out.println(maxAppears);

        String oddSymbolsCount = "asdfghjkllkjhgfdsa";
        int oddSymbols = main.countMaxOddSymbols(oddSymbolsCount);
        System.out.println(oddSymbols);
    }

    private int countMaxOddSymbols(String inputString) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            if (!list.contains(inputString.charAt(i))) {
                list.add(inputString.charAt(i));
            }
        }
        return list.size();
    }

    private int findMaxAppear(String inputString) {
        int counter = 1;
        int tempMax = 0;
        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.codePointAt(i - 1) == inputString.codePointAt(i)) {
                counter++;
            } else {
                tempMax = counter > tempMax ? counter : tempMax;
                counter = 1;
            }
        }
        return tempMax;
    }
}