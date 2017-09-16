package com.TheIronYard;

public class ReversePolishCalc {

    int stackTop = 0;

    private String[] tokens;

    private String[] stack;

    public double calculate(String input) {

        tokens = input.split(",");


        stack = new String[tokens.length];

        // 3. write the algorithm
        for (int i = 0; i < tokens.length; ++i) {
            // calls to push() and pop() and do the math here

            if (ReversePolishCalc.isANumber(tokens[i])) {
                double toStack = Double.parseDouble(tokens[i]);
                push(toStack);
            } else {
                String operand = tokens[i];
                double num1 = pop();
                double num2 = pop();
                switch(operand){
                    case "+":
                        push(num2+num1);
                        break;
                    case "-":
                        push(num2-num1);
                        break;
                    case "*":
                        push(num2*num1);
                        break;
                    case "/":
                        push(num2/num1);
                        break;
                }
            }
        }
        return pop();
    }

    public static boolean isANumber(String string) {
        try {
            double inputDouble = Double.parseDouble(string);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }


    private void push(String number) {

        stack[stackTop++] = number;

    }

    private void push(double d) {
        push(d + "");
    }



    private double pop() {

        double removeString = Double.parseDouble(stack[--stackTop]);

        return removeString;


    }
}
