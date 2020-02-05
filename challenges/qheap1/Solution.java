import java.io.*;
import java.util.*;
import java.io.InputStreamReader;

/**
 * Hackerrank Minimum Average Waiting Time
 *
 * @link https://www.hackerrank.com/challenges/qheap1/problem
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
        int Q = Integer.parseInt(br.readLine()), tmp;
        String[] command;
        for(int i =0; i< Q;i++) {
            command = br.readLine().split(" ");
            if(command[0].equals("3")){
                System.out.println(pq.peek());
                continue;
            }
            tmp = Integer.parseInt(command[1]);
            if(command[0].equals("1")) {
                pq.add(tmp);
            }else if(command[0].equals("2")) {
                pq.remove(tmp);
            }
        }
        br.close();
    }
}