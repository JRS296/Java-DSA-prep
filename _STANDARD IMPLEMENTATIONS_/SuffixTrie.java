import java.util.*;

class Program {
  // Do not edit the class below except for the
  // populateSuffixTrieFrom and contains methods.
  // Feel free to add new properties and methods
  // to the class.
  static class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  }

  static class SuffixTrie {
    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public SuffixTrie(String str) {
      populateSuffixTrieFrom(str);
    }

    public void populateSuffixTrieFrom(String str) {
      // Write your code here.
      for(int i=0; i<str.length(); i++) {
        String temp = str.substring(i);
        TrieNode curr = root;
        for(char ch: temp.toCharArray()) {
        if(!curr.children.containsKey(ch)) {
          TrieNode tNew = new TrieNode();
          curr.children.put(ch, tNew);
        } 
        curr = curr.children.get(ch);
      }
      curr.children.put(endSymbol, null);
      }
    }

    public boolean contains(String str) {
      // Write your code here.
      TrieNode cur = root;
      for(char ch: str.toCharArray()) {
        if(!cur.children.containsKey(ch)) return false;
        cur = cur.children.get(ch);
      }
      if(cur.children.containsKey(endSymbol)) return true;
      return false;
    }
  }
}

