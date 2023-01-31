import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(N) N is word length
// MC: O(1) 
class TrieNode {
    int alphabets = 26;
    TrieNode[] children = new TrieNode[alphabets];
    boolean isEndOfWord;
    TrieNode(){
        isEndOfWord = false;
        for(int i = 0; i < alphabets; i++) {
            children[i] = null;
        }
    }
}
class Trie {
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode rootWord = root;

        for(int i=0; i< word.length(); i++){
            int c = word.charAt(i) - 'a';
            if(rootWord.children[c] == null){
                rootWord.children[c] = new TrieNode();
            }
            rootWord = rootWord.children[c];
        }
        rootWord.isEndOfWord = true;
        
    }
    
    public boolean search(String word) {
        TrieNode rootWord = root;
        for(int i=0; i< word.length(); i++){
            int c = word.charAt(i) - 'a';
            if(rootWord.children[c] != null){
                rootWord = rootWord.children[c];
            } else {
                return false;
            }
        }
        if(rootWord.isEndOfWord == true) return true ; 
        return false;
    }
    
    public boolean startsWith(String prefix) {
       TrieNode rootWord = root;
        for(int i=0; i< prefix.length(); i++){
            int c = prefix.charAt(i) - 'a';
            if(rootWord.children[c] != null){
                rootWord = rootWord.children[c];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean answer = trie.search("apple"); 
        System.out.println("----answer-----" + answer);
        boolean startsWith = trie.startsWith("app"); 
        System.out.println("-----startsWith----" + startsWith);
    }
}
