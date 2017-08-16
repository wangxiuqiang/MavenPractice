package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void lessMoney() {
        String sql = "update user set money=money-? where id =?";
        jdbcTemplate.update(sql, 1000,"1");
	}

	public void moreMoney() {
		String sql = "update user set money=money+? where id =?";
        jdbcTemplate.update(sql, 1000,"2");
	}
}
