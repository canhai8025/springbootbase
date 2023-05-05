package com;

import com.aldeng.SpringbootApplication;
import com.aldeng.dao.BookDao;
import com.aldeng.entity.TypeEntity;
import com.aldeng.service.ITypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest(classes = SpringbootApplication.class)
//@ContextConfiguration(classes = SpringbootApplication.class)
public class TestB {
	@Autowired
	com.aldeng.service.ITypeService typeService;
	//1.注入运行的对象
	@Autowired
	private BookDao bookDao;
	//2.执行对象的方法
	@Test
	void contextLoads() {
		bookDao.save();
	}
	// 查询题目类型
	@Test
	void testSelectType() {
		List<TypeEntity> typeEntityList = typeService.list(new QueryWrapper<TypeEntity>().eq("id",1L));
		typeEntityList.forEach((item)-> {
			System.out.println(item);
		});
		System.out.println("查询成功");
	}
	@org.junit.Test
	public void test01(){
		TypeEntity typeEntity = new TypeEntity();
		typeEntity.setType("javaBasic222");
//        typeService.save(typeEntity);
		System.out.println("创建成功");
	}
}
