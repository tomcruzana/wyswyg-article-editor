package com.wyswyg.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao <T>{
	public int add(T obj) throws SQLException;

	public void delete(String id) throws SQLException;

	public T get(String id) throws SQLException;

	public List<T> getAll() throws SQLException;

	public void update(T course) throws SQLException;
}
