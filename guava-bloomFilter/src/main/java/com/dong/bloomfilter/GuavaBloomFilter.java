package com.dong.bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * 布隆过滤器，使用Guava库
 * @version 1.0 2021/5/7
 * @author dongliyang
 */
public class GuavaBloomFilter {

    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 100000,0.01);

        bloomFilter.put("10086");

        //false
        System.out.println(bloomFilter.mightContain("123567"));
        //true
        System.out.println(bloomFilter.mightContain("10086"));
    }
}
