package com.cc.project;

import com.cc.project.service.KafkaService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class KafkaTest {
    @Autowired
    KafkaService kafkaService;

    @Test
    @Ignore
    public void kafka(){
        kafkaService.send2("test111","hello123");
    }

}
