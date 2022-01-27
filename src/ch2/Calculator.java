package ch2;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Calculator {
    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    int add(int i, int j) {
        return i + j;
    }

    int subtract(int i, int j){
        return i - j;
    }

    int multiply(int i, int j) {
        return i * j;
    }

    int divide(int i, int j) {
        return i / j;
    }

    int[] splitInput() {
        String[] strAry = this.detectDelimiter(this.input);
        int[] inputAry = new int[strAry.length];

        for(int i = 0; i < strAry.length; i++){
            inputAry[i] = Integer.parseInt(strAry[i]);
        }

        return inputAry;
    }

    String[] detectDelimiter(String input) {
        if(Pattern.matches("^//.\\n.+", input)) {
            String delimiter = input.substring(2, 3);
            return input.substring(4, input.length()).split(delimiter);
        }else {
            return input.split(",|:");
        }
    }

    int calWithAdd() {
        int[] inputAry = this.splitInput();
        int sum = inputAry[0];

        for(int i = 1; i < inputAry.length; i++){
            sum = this.add(sum, inputAry[i]);
        }

        return sum;
    }
}
