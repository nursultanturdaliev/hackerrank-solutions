import java.io.*;
import java.util.*;

public class Solution {

  public static class KeyValue {

    public Integer key;
    public String value;

    public KeyValue(Integer key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) throws IOException {
    Stack<KeyValue> stack = new Stack<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int Q = Integer.parseInt(br.readLine()), endIndex;
    String line;
    String value;
    StringBuilder S = new StringBuilder();
    String[] split;
    int command;
    for (int i = 0; i < Q; i++) {
      split = br.readLine().split(" ");
      //   System.out.println("Line =>" + line);
      if (split.length == 2) {
        command = Integer.parseInt(split[0]);
        value = split[1];
        //append
        if (command == 1) {
          S.append(value);
          //   System.out.println("Append =>" + value);
          //   System.out.println("S => " + S);
          stack.push(new KeyValue(command, value));
        }
        //delete
        else if (command == 2) {
          endIndex = Integer.parseInt(value);
          //   System.out.println("Deleting => " +S);
          String sV = S.substring(S.length() - endIndex, S.length());
          S = new StringBuilder(S.substring(0, S.length() - endIndex));
          //   System.out.println("After Delete =>" + S);
          //   System.out.println("Saved Delete =>" + sV);
          stack.push(new KeyValue(command, sV));
        }
        //print
        else if (command == 3) {
          // System.out.println("Printing =>");
          System.out.println(S.charAt(Integer.parseInt(value) - 1));
        }
      } else {
        //   System.out.println("Undo =>");
        KeyValue kv = stack.pop();
        if (kv.key == 2) {
          // System.out.println("Undoing Delete =>" + kv.value);
          S.append(kv.value);
          // System.out.println("After Undoing Delete =>" + S);
        } else if (kv.key == 1) {
          // System.out.println("Undoing Append =>" + kv.value);
          S = new StringBuilder(S.substring(0, S.lastIndexOf(kv.value)));
          // System.out.println("After Undoing Append =>" + S);
        }
      }
    }

  }
}

