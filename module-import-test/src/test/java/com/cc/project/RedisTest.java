package com.cc.project;

import com.cc.framework.redis.service.RedisService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTest {
    @Autowired
    RedisService redisService;

    @Test
    public void redisTest(){
        final String msg =  "hello_world你好";

        redisService.set("1", msg);

        System.out.println(redisService.get("1"));
        Assert.assertEquals(msg,redisService.get("1"));
    }
}
