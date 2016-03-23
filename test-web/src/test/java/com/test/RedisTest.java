package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by lihuiyan on 2016/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring/spring-config.xml")
public class RedisTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private JedisPool jedisPool;

    @Test
    public void testRedis() {
        Jedis jedis = jedisPool.getResource();

        jedis.set("person.001.name", "frank");
        jedis.set("person.001.city", "beijing");

        String name = jedis.get("person.001.name");
        String city = jedis.get("person.001.city");

        jedis.del("person.001.name");
        Boolean result = jedis.exists("person.001.name");

        result = jedis.exists("person.001.city");
        jedis.close();

    }
}
