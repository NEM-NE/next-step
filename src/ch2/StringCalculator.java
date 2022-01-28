package ch2;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String text) {
        int[] inputAry = this.splitInput(text);
        int sum = inputAry[0];

        for(int i = 1; i < inputAry.length; i++){
            sum += inputAry[i];
        }

        return sum;
    }

    int[] splitInput(String text) {
        String[] strAry = this.detectDelimiter(text);
        int[] inputAry = new int[strAry.length];

        for(int i = 0; i < strAry.length; i++){
            inputAry[i] = Integer.parseInt(strAry[i]);
        }

        return inputAry;
    }

    String[] detectDelimiter(String input) {
        if(Pattern.matches("^//.\\n.+", input))
            return input
                    .substring(4, input.length())
                    .split(input.substring(2, 3));

        return input.split(",|:");
    }

}
