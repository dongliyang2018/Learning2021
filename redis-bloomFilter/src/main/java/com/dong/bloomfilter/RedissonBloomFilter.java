package com.dong.bloomfilter;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * 基于Redis的布隆过滤器，使用redisson库
 * @version 1.0 2021/5/7
 * @author dongliyang
 */
public class RedissonBloomFilter {

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.140.129:6379")
                .setPassword("123456789");

        RedissonClient redisson = Redisson.create(config);

        //布隆过滤器
        RBloomFilter<Object> bloomFilter = redisson.getBloomFilter("phoneList");
        //初始化布隆过滤器，预计元素为100000000L(1亿)，误差率为3%
        bloomFilter.tryInit(100000000L,0.03);

        //将号码10086插入到布隆过滤器中
        bloomFilter.add("10086");

        //判断下面的号码是否在布隆过滤器中
        //false
        System.out.println(bloomFilter.contains("123456"));
        //true
        System.out.println(bloomFilter.contains("10086"));
    }
}
