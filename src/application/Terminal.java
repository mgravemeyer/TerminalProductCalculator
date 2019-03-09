package application;

import java.util.InputMismatchException;
import java.util.Scanner;

    public class Terminal {

        //TERMINAL HANDLES ALL USER INPUTS, CHECKS, AND PRINT MESSAGES

        private Scanner scanner = new Scanner(System.in);
        private Calculator calculator = new Calculator();

        Terminal() {
            print("start");
            while (true) {
                productSelection();
            }
        }

        //IF PRODUCT SELECTION IS VALID, GO TO -> AMOUNT SELECTION
        void productSelection() {
            print("select");
            String inputSelection = scanner.next();
            if (checkSelectionValidation(inputSelection)) {
                amountSelection(inputSelection);
            } else {
                productSelection();
            }
        }

        //CHECK IF PRODUCT SELECTION IS VALID TO THE LIST OF PRODUCTS
        boolean checkSelectionValidation(String inputSelection) {
            if (inputSelection.equals("One") || inputSelection.equals("Two")) {
                return true;
            } else {
                return false;
            }
        }

        //INPUT SELECTION, CHECK IF m2 IS A DOUBLE, GO TO -> CALC
        void amountSelection(String inputSelection) {
            try {
                print("inputAmount");
                Double inputAmount = scanner.nextDouble();
                calc(inputSelection, inputAmount);
            } catch (InputMismatchException b) {
                resetAmountSelection(inputSelection);
            }
        }

        //RESET THE INPUT SCANNER
        void resetAmountSelection(String inputSelection) {
            print("error");
            scanner.nextLine();
            amountSelection(inputSelection);
        }

        //CALCULATE THE PRICE FOR THE SELECTED PRODUCT, PRINT FINAL MESSAGE
        void calc(String inputSelection, Double inputAmount) {
            switch(inputSelection) {
                case "One":
                    calculator.kompakt(inputAmount);
                    break;
                case "Two":
                    calculator.optimal(inputAmount);
                    break;
            }
            print("result");
            calculator.setResult(0);
        }

        //PRINT MESSAGES TO CONSOLE
        void print(String command) {
            switch(command) {
                case "start":
                    System.out.println("Applications starts...");
                    break;
                case "select":
                    System.out.println("Chose: One || Two.");
                    System.out.print("Please Enter Your Choice: ");
                    break;
                case "inputAmount":
                    System.out.print("Input: ");
                    break;
                case "error":
                    System.out.println("Wrong Input. Please Try Again.");
                    break;
                case "result":
                    System.out.println("Calculated Number: " + calculator.getResult());
                    break;
            }
        }

}
