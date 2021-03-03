// Truman Johnston, tjohn54@uwo.ca, 250965084


public class asn1_b {

    private static String[][] matrixMultiply(String[][] fib){
        String[][] matrix = {{"1","1"},{"1","0"}}; //the multiplier
        String[][] result = {{"0"},{"0"}}; //initialize the result

        // this multiplies the matrix in g(n) to g(n-1)
        result[0][0] = addStrings(multiply(fib[0][0], matrix[0][0]), (multiply(fib[1][0], matrix[0][1])));
        result[1][0] = addStrings(multiply(fib[0][0], matrix[1][0]), (multiply(fib[1][0], matrix[1][1])));

        return result;
        }

        //this function returns the string form product of two numbers in string form
    private static String multiply(String num1, String num2){


        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) return "0";


        int result[] = new int[len1 + len2];


        int i_n1 = 0;
        int i_n2 = 0;


        for (int i = len1 - 1; i >= 0; i--)
        {
            int carry = 0;
            int n1 = num1.charAt(i) - '0';

            i_n2 = 0;


            for (int j = len2 - 1; j >= 0; j--)
            {

                int n2 = num2.charAt(j) - '0';


                int sum = n1 * n2 + result[i_n1 + i_n2] + carry;


                carry = sum / 10;

                // Store result
                result[i_n1 + i_n2] = sum % 10;

                i_n2++;
            }


            if (carry > 0)
                result[i_n1 + i_n2] += carry;


            i_n1++;
        }

        int i = result.length - 1;
        while (i >= 0 && result[i] == 0)
            i--;

        if (i == -1)
            return "0";


        String s = "";

        while (i >= 0)
            s += (result[i--]);

        return s;
    }

    //This function returns the string form sum of two numbers that are in string form
    private static String addStrings(String a, String b) {


        StringBuilder result = new StringBuilder();

        int carry = 0;
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? a.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? b.charAt(p2) - '0' : 0;
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            result.append(value);
            p1--;
            p2--;
        }


        if (carry != 0)
            result.append(carry);



        return result.reverse().toString();
    }

    private static String[][] fib(int n) {

        if (n == 0) {
            String[][] result = {{"0"},{"0"}};
            return result;
        } else if (n == 1) {
            String[][] result = {{"1"},{"0"}};
            return result;

        }else if (n == 2) {
            String[][] result = {{"1"}, {"1"}};
            return result;
        }
            //if n>2
        else {
            String[][] result = matrixMultiply(fib(n-1));

            return result;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 25; i++){
            System.out.println("F("+ i*20 + ") = " + fib(i*20)[0][0]);
        }



    }
}

