package com.lim.biz.member.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lim.biz.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String sql_selectOne="SELECT * FROM MEMBER WHERE MID=? AND MPW=?"; //로그인
	final String sql_selectAll="SELECT * FROM MEMBER ORDER BY MID DESC";
	final String sql_insert="INSERT INTO MEMBER VALUES(?,?,?,?)"; // 회원가입
	final String sql_update="UPDATE MEMBER SET MPW=?,NAME=? WHERE MID=?"; //회원정보 변경
	final String sql_delete="DELETE FROM MEMBER WHERE MID=? AND MPW=?"; //회원탈외
	 MemberVO selectOne(MemberVO vo) {
		Object[] args= {vo.getMid(),vo.getMpw()};
		return jdbcTemplate.queryForObject(sql_selectOne,args,new MemberRowMapper());
		
	}
	 void insert(MemberVO vo) {
		
		jdbcTemplate.update(sql_insert,vo.getMid(),vo.getMpw(),vo.getName(),vo.getRole());
	}
	 void update(MemberVO vo) {
		jdbcTemplate.update(sql_update,vo.getMpw(),vo.getName(),vo.getMid());
		
	}
	 void delete(MemberVO vo) {
		jdbcTemplate.update(sql_delete,vo.getMid(),vo.getMpw());
		
	}
	List<MemberVO> selectAll(MemberVO vo){
		return jdbcTemplate.query(sql_selectAll,new MemberRowMapper());
		
}
}
class MemberRowMapper implements RowMapper<MemberVO>{

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MemberVO data=new MemberVO();
		data.setMid(rs.getString("MID"));
		data.setMpw(rs.getString("MPW"));
		data.setName(rs.getString("NAME"));
		data.setRole(rs.getString("ROLE"));
		
		return data;
	}

	}
	

