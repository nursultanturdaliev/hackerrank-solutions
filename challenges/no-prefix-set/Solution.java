import java.io.*;
import java.util.*;
import java.io.BufferedReader;

/**
 * Hackerrank No Prefix Set
 *
 * @link https://www.hackerrank.com/challenges/no-prefix-set/problem
 */
public class Solution {

  static class TrieNode {

    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean endOfWord;
    private char c;
    private int count;

    public TrieNode() {
      count = 0;
    }

    public TrieNode(char c) {
      this.endOfWord = false;
      this.c = c;
      this.count = 0;
    }

    Map<Character, TrieNode> getChildren() {
      return children;
    }

    boolean isEndOfWord() {
      return endOfWord;
    }

    void increment() {
      this.count += 1;
    }

    int getCount() {
      return count;
    }

    void setEndOfWord(boolean endOfWord) {
      this.endOfWord = endOfWord;
    }

    public String toString() {
      return "{\"char\":" + c + ", \"endOfWord\":" + endOfWord + ", \"children\" :" + children.toString() + "}";
    }
  }

  static class Trie {

    private TrieNode root;

    Trie() {
      root = new TrieNode();
    }

    void insert(String word) {
      Map<Character, TrieNode> children = root.getChildren();
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        TrieNode node;
        if (children.containsKey(c)) {
          node = children.get(c);
        } else {
          node = new TrieNode(c);
          children.put(c, node);
        }
        children = node.getChildren();

        if (i == word.length() - 1) {
          node.setEndOfWord(true);
          node.increment();
        }
      }
    }

    boolean containsWordWithPrefix(String prefixWord) {
      TrieNode current = root;
      int wordOccurence = 0;

      for (int i = 0; i < prefixWord.length(); i++) {
        current = current.getChildren().get(prefixWord.charAt(i));
        if (current.isEndOfWord() && current.getCount() > 1) {
          return true;
        }
        if ((current.isEndOfWord() && prefixWord.length() != i + 1) || (current.isEndOfWord()
                                                                            && prefixWord.length() == i + 1
                                                                            && !current.getChildren().isEmpty())) {
          wordOccurence++;
        }
      }
      if (wordOccurence > 0) {
        return true;
      }

      return false;
    }

    boolean isEmpty() {
      return root == null;
    }

    public String toString() {
      return "{" + this.root.getChildren().toString() + "}";
    }
  }

  public static void main(String[] args) throws IOException {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    ArrayList<String> words = new ArrayList<String>();
    Trie trie = new Trie();
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      words.add(s);
      trie.insert(s);
      if (trie.containsWordWithPrefix(s)) {
        System.out.println("BAD SET");
        System.out.println(s);
        return;
      }
    }

    System.out.println("GOOD SET");

  }
}
