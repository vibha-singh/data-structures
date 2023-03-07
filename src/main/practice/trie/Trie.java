package main.practice.trie;

public class Trie {
    static TrieNode root;
    static final int ALPHABETS_COUNT= 26;
    static class TrieNode {
        TrieNode[] children =  new TrieNode[ALPHABETS_COUNT];
        boolean isEndOfWord;
        TrieNode(){
            isEndOfWord = false;
            for(int i = 0; i<ALPHABETS_COUNT ; i++)
                children[i] = null;
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
    static void insert(String key) {
        TrieNode pCrawl = root;
        for(int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null){
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }
    static boolean search (String key) {
        TrieNode pCrawl = root;
        for(int i = 0; i< key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if(pCrawl.children[index] == null) return false;
            pCrawl = pCrawl.children[index];
        }
        return pCrawl.isEndOfWord;
    }
}
