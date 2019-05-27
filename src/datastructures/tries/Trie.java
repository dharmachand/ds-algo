package datastructures.tries;

import java.util.HashMap;
import java.util.Scanner;

public class Trie {
    public static final Scanner scanner = new Scanner(System.in);

    class TrieNode {
        Character c;
        Boolean isLeaf = false;
        HashMap<Character, TrieNode> children = new HashMap<>();
        public TrieNode() {}
        public TrieNode(Character c) {
            this.c = c;
        }
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insertWord(String word) {
        if(word == null || word.length() < 1) return;
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = cur.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                cur = children.get(c);
            } else {
                TrieNode n = new TrieNode(c);
                children.put(c, n);
                cur = n;
            }
            children = cur.children;

            if (i == word.length() - 1) {
                cur.isLeaf = true;
            }
        }
    }

    public Boolean searchWord(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = cur.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                cur = children.get(c);
                children = cur.children;
            } else {
                return false;
            }
        }
        return cur.isLeaf;
    }

    public Boolean searchPrefix(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = cur.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                cur = children.get(c);
                children = cur.children;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        //FIRES FRIES FIR WORD CRY CRATE CREATER WORM WORLD DREAM DRUM

        System.out.println("Enter a word: ");
        String[] words = scanner.nextLine().split(" ");

        Trie trie = new Trie();
        for (String word: words) {
            trie.insertWord(word);
        }

        System.out.println("Search word: ");
        String searchWord = scanner.nextLine();

        System.out.println("Word found: " + trie.searchWord(searchWord));

        System.out.println("Search prefix: ");
        String searchPrefix = scanner.nextLine();

        System.out.println("prefix found: " + trie.searchPrefix(searchPrefix));

    }

}
