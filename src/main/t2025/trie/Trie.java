package main.t2025.trie;

import java.util.Arrays;

import static main.t2025.trie.Trie.TrieNode.insert;
import static main.t2025.trie.Trie.TrieNode.search;

public class Trie {

    private static final Integer ALPHABET_COUNT = 26;
     static TrieNode root;

     static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_COUNT];
        boolean isEndOfWord;

         public TrieNode() {
             Arrays.fill(children, null);
             this.isEndOfWord = false;
         }

         public static void insert(String key) {
             TrieNode pCrawl = root;
             for(int i = 0; i<key.length(); i++) {
                 int index = key.charAt(i) - 'a';
                 if(pCrawl.children[index] == null) {
                     pCrawl.children[index] = new TrieNode();
                 }
                 pCrawl = pCrawl.children[index];
             }

             pCrawl.isEndOfWord = true; ;
         }

         public static boolean search(String key) {
             TrieNode pCrawl = root;
             for(int i = 0; i<key.length(); i++) {
                 int index = key.charAt(i) - 'a';
                 if(pCrawl.children[index] == null) return false;
                 pCrawl = pCrawl.children[index];
             }

             return pCrawl.isEndOfWord;
         }
     }

    public static void main(String[] args) {
        String [] keys = {"the", "bye","by", "answer","a","any","there","their"};
        root = new TrieNode();
        for (int i = 0; i < keys.length ; i++)
            insert(keys[i]);
        String[] output = {"Not present in trie", "Present in trie"};
        if(search("the"))
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

    }
}
