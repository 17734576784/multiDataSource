package com.ke;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ke.ds1.mapper.Ds1CommonMapper;
import com.ke.ds2.mapper.CommonMapper;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = MultiDataSourceApplication.class)
public class MultiDataSourceApplicationTests {
	
	@Resource
	private Ds1CommonMapper ds1CommonMapper;
	
	@Resource
	private CommonMapper ds2CommonMapper;
	@Test
	void contextLoads() {
		System.out.println("DS1: fist   "+ ds1CommonMapper.getFisrtRtu());
		System.out.println("DS2: last   "+ ds2CommonMapper.getLastRtu());
	}

}
