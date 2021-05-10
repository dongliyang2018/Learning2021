package com.dong.trie;

import java.util.HashMap;
import java.util.Map;

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
public class HashMapTrie implements ITrie {
    //使用HashMap存放子节点，可以存储任意字符

    /** 用于存储字符 */
    private Map<Character,HashMapTrie> children;
    /** 是否是一个单词的结尾 */
    private boolean isEnd;

    public HashMapTrie() {
        children = new HashMap<>();
        isEnd = false;
    }

    @Override
    public void insert(String word) {
        HashMapTrie node = this;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                //不为null，说明这个地方有字符了
                node.children.put(ch,new HashMapTrie());
            }
            //移动节点
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    @Override
    public boolean search(String word) {
        HashMapTrie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    @Override
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private HashMapTrie searchPrefix(String prefix) {
        HashMapTrie node = this;
        for (char ch : prefix.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return null;
            }
            node = node.children.get(ch);
        }
        return node;
    }
}
