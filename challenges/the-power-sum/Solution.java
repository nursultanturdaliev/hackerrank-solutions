import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Hackerrank Minimum Average Waiting Time
 *
 * @link https://www.hackerrank.com/challenges/the-power-sum/problem
 */
public class Solution {

    // Complete the powerSum function below.
    static int powerSum(int X, int N) {
        return calculatePowerSum(X, N, 1);
    }

    static int calculatePowerSum(int X, int N,int current) {
        int pw =(int)Math.pow(current,N);
        if(pw> X)
        {
            return 0;
        }else if(pw == X){
            return 1;
        }

        return calculatePowerSum(X, N, current+1)+calculatePowerSum(X-pw, N, current+1);
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
