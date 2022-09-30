package lib;
import java.util.*;

public class Main {

    public static void main(String[] args){
        problem10 solution = new problem10(2000000);
        long sum_of_primes = solution.get_sum_of_primes_below_number();
        System.out.println(sum_of_primes);
    }
}
