package NumberTheory;
import java.util.Scanner;

// Links :  https://cp-algorithms.com/algebra/primality_tests.html


/*
This is a primality test.
 */

public class PrimalityTestSqrtN {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPrime(n));
        System.out.println(isPrimeNaive(n));
    }

    /*
This is a primality test in O(SQRT(N)) time complexity.
 */
    static String isPrime(int n){

        for (int i = 2 ; i*i <= n ; i++){
            if(n%i==0) return "Composite";
        }
        return "Prime";
    }


/*
Naive method : This is a primality test in O((N)) time complexity.
 */

    static String isPrimeNaive(int n ){
        int count = 1;
        for (int i = 2 ; i <= n ; i++){
            if(n%i == 0 ) count++;
        }
        if(count>2) return "Composite";
        else return "Prime";
    }

}






