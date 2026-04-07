//find closest to n 

import java.util.*;

public class ClosestDivisible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int r = n % m;

        int lower = n - r;
        int upper = lower + m;

        int result;

        if (n - lower < upper - n)
            result = lower;
        else if (n - lower > upper - n)
            result = upper;
        else
            result = (Math.abs(lower) > Math.abs(upper)) ? lower : upper;

        System.out.println(result);
    }
}
