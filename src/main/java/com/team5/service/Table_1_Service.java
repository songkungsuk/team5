package com.team5.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team5.common.Mybatis;
import com.team5.mapper.Table_1_Mapper;
import com.team5.vo.Table_1_VO;

public class Table_1_Service {
	public List<Table_1_VO> selectTable_1_List(Table_1_VO table) {
		try(SqlSession session = Mybatis.getFactory().openSession(true)){
			Table_1_Mapper t1Mapper = session.getMapper(Table_1_Mapper.class);
			return t1Mapper.selectTable_1_List(table);
		}
		
	}

	public Table_1_VO selectTable_1(int biNum) {
		try(SqlSession session = Mybatis.getFactory().openSession(true)){
			Table_1_Mapper t1Mapper = session.getMapper(Table_1_Mapper.class);
			return t1Mapper.selectTable_1(biNum);
		}
		
	}

	public int insertTable_1(Table_1_VO table) {
		try(SqlSession session = Mybatis.getFactory().openSession(true)){
			Table_1_Mapper t1Mapper = session.getMapper(Table_1_Mapper.class);
			return t1Mapper.insertTable_1(table);
		}
	}

	public int updateTable_1(Table_1_VO table) {
		try(SqlSession session = Mybatis.getFactory().openSession(true)){
			Table_1_Mapper t1Mapper = session.getMapper(Table_1_Mapper.class);
			return t1Mapper.updateTable_1(table);
		}
	}

	public int deleteTable_1(int biNum) {
		try(SqlSession session = Mybatis.getFactory().openSession(true)){
			Table_1_Mapper t1Mapper = session.getMapper(Table_1_Mapper.class);
			return t1Mapper.deleteTable_1(biNum);
		}
	}

}
