/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorsimulator;

import static calculatorsimulator.CalculatorSimulator.*;
import java.util.LinkedList;

/**
 *
 * @author laris
 */
public class Calculator {

    static boolean addition;
    static boolean substraction;
    static boolean division;
    static boolean multiplication;

    static LinkedList<Integer> numbers = new LinkedList<>();
    static LinkedList<String> operations = new LinkedList<>();

    static int firstNo, secondNo;
    static int result;
    static char operation;

    public Calculator() {
    }

    public void addNumber(int no) {
        numbers.add(no);
    }

    public void addOperation(String op) {
        operations.add(op);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {

            text.setText(text.getText().concat("Division by 0 impossible."));

            return 0;
        }
    }

    public long finalResult() {
        while (!operations.isEmpty()) {
            firstNo = numbers.remove();
            secondNo = numbers.remove();

            operation = operations.remove().charAt(0);

            switch (operation) {
                case '+':
                    result = add(firstNo, secondNo);
                    break;
                case '-':
                    result = substract(firstNo, secondNo);
                    break;
                case '/':
                    result = division(firstNo, secondNo);
                    break;
                case '*':
                    result = multiplication(firstNo, secondNo);
                    break;
                default:
                    break;
            }
            numbers.addFirst(result);
        }

        return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        text.setText(text.getText().concat(" " + calculator.finalResult()));
    }
}
