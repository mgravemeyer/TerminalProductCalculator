package application;

    public class Calculator {

        private double result;
        final int productPriceOne = 650;
        final int productPriceTwo = 700;

        Calculator(){
            this.result = 0;
        }

        double getResult () {
            return result;
        }

        void setResult (double input) {
            this.result = input;
        }

        //KOMPAKT PRODUCT
        void kompakt (double betrag) {
            this.result = betrag * productPriceOne;
        }

        //OPTIMAL PRODUCT
        void optimal (double betrag) {
            this.result = betrag * productPriceTwo;
        }
    }

