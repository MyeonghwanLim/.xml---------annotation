package com.lim.biz.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.lim.biz.common.JDBCUtil;
import com.lim.biz.member.MemberVO;

 //메모리관리를 효율적으로 하기위해 DAO에서 사용하는것이라고 말해줘야한다.
//@Component라고 써주어도 메모리가 적재되어 코드가 돌아간다 하지만, 어떤 용도로 사용되는지 알기 위해 정확히 구분지어 @ 사용한다.
public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	final String sql_selectOne="SELECT * FROM MEMBER WHERE MID=? AND MPW=?"; //로그인
	final String sql_selectAll="SELECT * FROM MEMBER ORDER BY MID DESC";
	final String sql_insert="INSERT INTO MEMBER VALUES(?,?,?,?)"; // 회원가입
	final String sql_update="UPDATE MEMBER SET MPW=?,NAME=? WHERE MID=?"; //회원정보 변경
	final String sql_delete="DELETE FROM MEMBER WHERE MID=? AND MPW=?"; //회원탈외
	public MemberVO selectOne(MemberVO vo) {
		
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMid(rs.getString("MID"));
				data.setName(rs.getString("NAME"));
				data.setMpw(rs.getString("MPW"));
				data.setRole(rs.getString("ROLE"));
				return data;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return null;
	}
	public boolean insert(MemberVO vo) {
		
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean update(MemberVO vo) {
		System.out.println("??");
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getMpw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean delete(MemberVO vo) {
		
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_delete);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public ArrayList<MemberVO> selectAll(MemberVO vo){
		
		ArrayList<MemberVO> datas=new ArrayList<MemberVO>();
		conn=JDBCUtil.connect();
		try {
			
			pstmt=conn.prepareStatement(sql_selectAll);
			
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMid(rs.getString("MID"));
				data.setMpw(rs.getString("MPW"));
				data.setName(rs.getString("NAME"));
				data.setRole(rs.getString("ROLE"));
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}		
		return datas;
	}
}

