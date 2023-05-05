package com.aldeng.dao.impl;

import com.aldeng.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
	@Override
	public void save() {
		System.err.println("this is BookDaoImpl....");
	}
}
