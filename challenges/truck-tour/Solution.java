import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 * Hackerrank Truck Tour
 *
 * @link https://www.hackerrank.com/challenges/truck-tour/problem
 */
public class Solution {
    static class Pump {
        public int amount;
        public int distance;
        public int i;
        public Pump(int amount, int distance, int i){
            this.amount = amount;
            this.distance = distance;
            this.i = i;
        }
    }
    
    static int truckTour(int[][] petrolpumps) {
        ArrayDeque<Pump> queue = new ArrayDeque<Pump>();
        ArrayDeque<Pump> tempQueue = new ArrayDeque<Pump>();
        int position = 0, sum = 0, count = 0;

        for(int i =0 ;i< petrolpumps.length; i++) {
            tempQueue.add(new Pump(petrolpumps[i][0],petrolpumps[i][1], i));
        }
        Pump pump, queuePump;
        while(!tempQueue.isEmpty()) {
            pump = tempQueue.pollFirst();
            queue.addLast(pump);
            sum = sum + pump.amount - pump.distance;
            while(sum<0 && !queue.isEmpty()) {
                pump = queue.pollFirst();
                sum = sum - pump.amount + pump.distance;
            }

        }

        return queue.getFirst().i;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] petrolpumps = new int[n][2];

        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
            String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

            for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
                petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
            }
        }

        int result = truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
