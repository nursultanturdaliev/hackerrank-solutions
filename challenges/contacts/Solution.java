import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 * Hackerrank Contacts
 * @link https://www.hackerrank.com/challenges/contacts/problem
 */
public class Solution {

  static class TrieNode {
    private HashMap<Character, TrieNode> children;
    private boolean endOfWord;
    private char ch;
    private int count;
    public TrieNode() {
      endOfWord = false;
      children = new HashMap<Character, TrieNode>();
      count = 0;
    }
    public TrieNode(char ch) {
      endOfWord = false;
      children = new HashMap<Character,TrieNode>();
      this.ch = ch;
      count = 0;
    }

    public void incrementCount(){
      this.count++;
    }

    public int getCount() {
      return this.count;
    }

    public HashMap<Character, TrieNode> getChildren() {
      return children;
    }
  }

  static class Trie {
    private TrieNode root;
    public Trie(){
      root = new TrieNode();
    }

    void insert(String word) {
      TrieNode current = root;
      for(int i =0 ;i< word.length(); i++) {
        char ch = word.charAt(i);
        TrieNode node = current.getChildren().get(ch);
        if(node == null) {
          node = new TrieNode(ch);
          current.getChildren().put(ch, node);
        }
        node.incrementCount();
        current = node;
      }
    }

    int findPrefixCount(String word) {
      TrieNode current = root;
      for(int i = 0; i< word.length();i++) {
        current = current.getChildren().get(word.charAt(i));
        if(current == null){
          return 0;
        }
      }
      return current.getCount();
    }
  }

  /*
   * Complete the contacts function below.
   */
  static int[] contacts(String[][] queries) {
    Trie trie = new Trie();
    ArrayList<Integer> result = new ArrayList<Integer>();
    for(int i = 0; i< queries.length; i++){
      String command = queries[i][0];
      String word = queries[i][1];
      if(command.equals("add")){
        trie.insert(word);
      } else {
        int count = trie.findPrefixCount(word);
        result.add(count);
      }
    }
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int queriesRows = Integer.parseInt(scanner.nextLine().trim());

    String[][] queries = new String[queriesRows][2];

    for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
      String[] queriesRowItems = scanner.nextLine().split(" ");

      for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
        String queriesItem = queriesRowItems[queriesColumnItr];
        queries[queriesRowItr][queriesColumnItr] = queriesItem;
      }
    }

    int[] result = contacts(queries);

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
