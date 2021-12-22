package com.sikiedu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sikiedu.model.Type;
import com.sikiedu.utils.DBUtil;

public class TypeDao {
	public List<Type> selectAll() throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from type";
		return r.query(sql, new BeanListHandler<Type>(Type.class));
	}
	public Type select(int id) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from type where id = ?";
		return r.query(sql, new BeanHandler<Type>(Type.class),id);
	}
	public void insert(Type t) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql = "insert into type(name) values(?)";
		r.update(sql,t.getName());
	}
	public void update(Type t) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql = "update type set name=? where id = ?";
		r.update(sql,t.getName(),t.getId());
	}
	public void delete(int id) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql = "delete from type where id = ?";
		r.update(sql,id);
	}
}
