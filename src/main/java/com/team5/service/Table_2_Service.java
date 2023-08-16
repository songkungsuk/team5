package com.team5.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team5.common.Mybatis;
import com.team5.mapper.Table_2_Mapper;
import com.team5.vo.Table_2_VO;

public class Table_2_Service {
	
	public List<Table_2_VO> getTables(Table_2_VO table){
		try(SqlSession session = Mybatis.getFactory().openSession()){
			Table_2_Mapper tMapper = session.getMapper(Table_2_Mapper.class);
			return tMapper.selectTableList(table);
		}
	}
		
	public Table_2_VO getTable(int biNum) {
		try(SqlSession session = Mybatis.getFactory().openSession()){
			Table_2_Mapper tMapper = session.getMapper(Table_2_Mapper.class);
			return tMapper.selectTable(biNum);
		}
	}
	public int insertTable(Table_2_VO table) {
		try(SqlSession session = Mybatis.getFactory().openSession(true)){
			Table_2_Mapper tMapper = session.getMapper(Table_2_Mapper.class);
			return tMapper.insertTable(table);
		}
		
	}
	public int updateTable(Table_2_VO table) {
		try(SqlSession session = Mybatis.getFactory().openSession(true)){
			Table_2_Mapper tMapper = session.getMapper(Table_2_Mapper.class);
			return tMapper.updateTable(table);
		}
	}
	public int deleteTable(int biNum) {
		try(SqlSession session = Mybatis.getFactory().openSession(true)){
			Table_2_Mapper tMapper = session.getMapper(Table_2_Mapper.class);
			return tMapper.deleteTable(biNum);
		}
	}
}
