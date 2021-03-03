// Truman Johnston, tjohn54@uwo.ca, 250965084

public class asn1_a {

    //recursive fibonacci function
    private static long fib(int n) {
//        F(n) = F(n − 1) + F(n − 2), n > 1; F(1) = 1; F(0) = 0.
//        a). Write a recursive function to compute F(n) using the above definition directly.
//                Implement your solution and print F(i ∗ 5), where 0 ≤ i ≤ 10, as output.
        switch (n) {
            //if n = 0 return 0
            case 0:
                return 0;

            //if n = 1 return 1
            case 1:
                return 1;

            //if n > 1 then call the function twice(n-1 and n-2) and sum the results
            default:
                return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println("f(" + i*5 + ") = " + fib(i * 5));
        }
        System.out.println("The program has finished running.");

    }
}

