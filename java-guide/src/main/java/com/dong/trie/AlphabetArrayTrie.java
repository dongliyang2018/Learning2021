package com.dong.trie;

/**
 * 前缀树
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * @version 1.0 2021/5/10
 * @author dongliyang
 */
public class AlphabetArrayTrie implements ITrie {
    //当前这个实现方式，只能存放英文单词

    /** 用于存放26个字母 */
    private AlphabetArrayTrie[] children;
    /** 是否是一个单词的结尾 */
    private boolean isEnd;

    public AlphabetArrayTrie() {
        children = new AlphabetArrayTrie[26];
        isEnd = false;
    }

    @Override
    public void insert(String word) {
        AlphabetArrayTrie node = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                //不为null，说明这个地方有字母了
                node.children[index] = new AlphabetArrayTrie();
            }
            //移动节点
            node = node.children[index];
        }
        node.isEnd = true;
    }

    @Override
    public boolean search(String word) {
        AlphabetArrayTrie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    @Override
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private AlphabetArrayTrie searchPrefix(String prefix) {
        AlphabetArrayTrie node = this;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
