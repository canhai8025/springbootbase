package com.aldeng;

import com.aldeng.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

	//1.注入运行的对象
	@Autowired
	private BookDao bookDao;
	//2.执行对象的方法
	@Test
	void contextLoads() {
		bookDao.save();
	}

}
