package com.dong.trie;

/**
 * 测试
 * @version 1.0 2021/5/10
 * @author dongliyang
 */
public class TestHashMapTrie {
    public static void main(String[] args) {
        ITrie trie = new HashMapTrie();
        trie.insert("apple");
        System.out.println("trie.search(\"apple\") = " + trie.search("apple"));
        System.out.println("trie.search(\"app\") = " + trie.search("app"));
        System.out.println("trie.startsWith(\"app\") = " + trie.startsWith("app"));
        trie.insert("app");
        System.out.println("trie.search(\"app\") = " + trie.search("app"));

        trie.insert("中国人");
        System.out.println("trie.search(\"中国人\") = " + trie.search("中国人"));
        System.out.println("trie.startsWith(\"中国\") = " + trie.startsWith("中国"));
    }
}
