package com.dong.trie;

/**
 * 前缀树接口
 * @version 1.0 2021/5/10
 * @author dongliyang
 */
public interface ITrie {
    public void insert(String word);
    public boolean search(String word);
    public boolean startsWith(String prefix);
}
