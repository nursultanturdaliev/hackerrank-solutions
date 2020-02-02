import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

/**
 * Hackerrank Jesse and Cookies
 */
public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0].trim());

    int k = Integer.parseInt(nk[1].trim());

    int[] A = new int[n];

    for (int AItr = 0; AItr < n; AItr++) {
      queue.add(scanner.nextInt());
    }

    int operations = 0;
    while (queue.size() > 1 && queue.peek() < k) {
      queue.add(queue.poll() + 2 * queue.poll());
      operations++;
    }

    if (queue.peek() < k) {
      operations = -1;
    }

    bufferedWriter.write(String.valueOf(operations));
    bufferedWriter.newLine();

    bufferedWriter.close();
  }
}
