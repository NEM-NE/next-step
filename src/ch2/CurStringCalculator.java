package ch2;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CurStringCalculator {

    public int add(String text) {
        if(isBlank(text)) {
            return 0;
        }

        return sum(toInts(split(text)));
    }

    private String[] split(String text) {
        if(Pattern.matches("^//.\\n.+", text))
            return text
                    .substring(4, text.length())
                    .split(text.substring(2, 3));
        return text.split(",|:");
    }

    private boolean isBlank(String text){
        return text == null || text.isEmpty();
    }

    private int[] toInts(String[] ary) {
        int[] numbers = new int[ary.length];

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = toPositive(ary[i]);
        }

        return numbers;
    }

    private int toPositive(String value){
        int number = Integer.parseInt(value);
        if(number < 0) throw new RuntimeException();

        return number;
    }

    private int sum(int[] ary) {
        int sum = 0;
        for(int num : ary) {
            sum += num;
        }

        return sum;
    }
}
