import java.util.*;
public class PerfectNumber {
    public static boolean isPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter a number");
        int num = s.nextInt(); 
        if (isPerfectNumber(num)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
