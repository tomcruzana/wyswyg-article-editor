package com.wyswyg.dao;

import java.sql.SQLException;
import java.util.List;

public interface DomainDao {
	public int add(Object emp) throws SQLException;

	public void delete(int id) throws SQLException;

	public Object getEmployee(int id) throws SQLException;

	public List<Object> getEmployees() throws SQLException;

	public void update(Object emp) throws SQLException;
}
