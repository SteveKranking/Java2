public class Fizz {
    public void fizzBuzz(int number) {
        // fizzbuzz logic 
        if (number % 5 == 0 && number % 3 == 0) {
            System.out.println("FizzBuzz");
        }
        else if (number % 5 == 0) {
            System.out.println("Buzz");
        }
        else if (number % 3 == 0) {
            System.out.println("Fizz");
        }
        else if (number % 5 != 0 && number % 3 != 0) {
            System.out.println(number);
        }
    }
}