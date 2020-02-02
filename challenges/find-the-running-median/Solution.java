import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

/**
 * HackerRank Find The Running Median
 *
 * @link https://www.hackerrank.com/challenges/find-the-running-median/problem
 */
public class Solution {

  static double[] runningMedian(int[] a) {

    if (a.length == 0) {
      return new double[0];
    }

    PriorityQueue<Double> minHeap = new PriorityQueue<Double>();
    PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(new Comparator<Double>() {
      @Override
      public int compare(Double d1, Double d2) {
        return d2.compareTo(d1);
      }
    });

    double[] result = new double[a.length];

    result[0] = (double) a[0];

    if (a.length < 2) {
      return result;
    }

    if (a.length > 1) {
      result[1] = ((double) (a[0] + a[1])) / 2.0;
    }

    double min, max;
    min = Math.min(a[0], a[1]);
    max = Math.max(a[0], a[1]);

    maxHeap.add((double) min);
    minHeap.add((double) max);

    for (int i = 2; i < a.length; i++) {

      if (a[i] < maxHeap.peek()) {
        maxHeap.add((double) a[i]);
      } else {
        minHeap.add((double) a[i]);
      }

      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.add(maxHeap.poll());
      } else if (minHeap.size() > maxHeap.size() + 1) {
        maxHeap.add(minHeap.poll());
      }

      if (minHeap.size() == maxHeap.size()) {
        result[i] = (minHeap.peek() + maxHeap.peek()) / 2.0;
      } else if (minHeap.size() > maxHeap.size()) {
        result[i] = minHeap.peek();
      } else {
        result[i] = maxHeap.peek();
      }

      System.out.println(result);

    }

    return result;

  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int aCount = Integer.parseInt(scanner.nextLine().trim());

    int[] a = new int[aCount];

    for (int aItr = 0; aItr < aCount; aItr++) {
      int aItem = Integer.parseInt(scanner.nextLine().trim());
      a[aItr] = aItem;
    }

    double[] result = runningMedian(a);

    for (int resultItr = 0; resultItr < result.length; resultItr++) {
      bufferedWriter.write(String.valueOf(result[resultItr]));

      if (resultItr != result.length - 1) {
        bufferedWriter.write("\n");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();
  }
}
