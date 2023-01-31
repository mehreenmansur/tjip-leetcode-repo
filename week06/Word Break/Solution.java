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

    public boolean wordBreakSearch(String word) {
        TrieNode rootWord = root;
        for(int i=0; i< word.length(); i++){
            int c = word.charAt(i) - 'a';
            if(rootWord.children[c] != null){
                rootWord = rootWord.children[c];
            } else {
                return false;
            }
            if((rootWord.isEndOfWord == true) && (i != word.length() - 1) && (rootWord.children[c].isEndOfWord == false)) {
                System.out.println("-----rootWord----" + rootWord);
                rootWord = root;
            }
        }
        if(rootWord.isEndOfWord == true) return true ; 
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] wordDict = {"aaaa","aaa"};
        String s = "aaaaaaa";
        for(int i = 0; i<wordDict.length; i++){
            trie.insert(wordDict[i]);
        }
        boolean answer = trie.wordBreakSearch(s);
        
        // boolean answer = trie.search("apple"); 
        System.out.println("----answer-----" + answer);
        // boolean startsWith = trie.startsWith("app"); 
        // System.out.println("-----startsWith----" + startsWith);
    }
}
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Trie trie = new Trie();
//         String s = "catsandog";
//         for(int i = 0; i<wordDict.size(); i++){
//             trie.insert(wordDict.get(i));
//         }
//         return trie.wordBreakSearch(s);

//     }
//     public static void main(String[] args) {
//         wordBreak()
//         Trie trie = new Trie();
//         String[] wordDict = {"cats","dog","sand","and","cat"};
//         String s = "catsandog";
//         for(int i = 0; i<wordDict.length; i++){
//             trie.insert(wordDict[i]);
//         }
//         boolean answer = trie.wordBreakSearch(s);
        
//         // boolean answer = trie.search("apple"); 
//         System.out.println("----answer-----" + answer);
//         // boolean startsWith = trie.startsWith("app"); 
//         // System.out.println("-----startsWith----" + startsWith);
//     }
// }