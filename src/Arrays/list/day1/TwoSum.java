package day1;

import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String [] parts = scanner.nextLine().split(" ");
       int [] nums = new int [parts.length];
       for(int i = 0; i < parts.length; i++){
    nums [i] = Integer.parseInt(parts[i]);
        }
        int target = scanner.nextInt();
for(int i = 0; i < nums.length; i++){
    for(int j = i + 1; j < nums.length; j++){
        if (nums[i] + nums[j] == target){
            System.out.println("[" + i + "," + j + "]");
            return;

        }

        }
        }
        System.out.println("No valid pair found");
    }
}



