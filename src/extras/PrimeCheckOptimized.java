package extras;

import java.util.Scanner;

public class PrimeCheckOptimized {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your number: ");
        int input = scanner.nextInt();

        boolean isPrime = true;

        if(input <= 1){
            isPrime = false;
        } else {
          for (int i = 2; i <= Math.sqrt(input); i++){
              if (input % i == 0){
                  isPrime = false;
                  break;
              }
          }
        }
        if(isPrime){
            System.out.println(input + " is Prime number!");
        }else {
            System.out.println(input + " is not Prime number!");
        }

    }
}
