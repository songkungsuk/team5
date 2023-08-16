package com.team5.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team5.common.Mybatis;
import com.team5.mapper.Table_3_mapper;
import com.team5.vo.Table_3_VO;

public class Table_3_Service {
	public List<Table_3_VO> selectBoardInfoList(Table_3_VO t3) {
		try(SqlSession session = Mybatis.getFactory().openSession()) {
			Table_3_mapper t3Mapper = session.getMapper(Table_3_mapper.class);
			return t3Mapper.selectBoardInfoList(t3);
		}
	}
	
	public Table_3_VO selectBoardInfo(int biNum) {
		try(SqlSession session = Mybatis.getFactory().openSession()) {
			Table_3_mapper t3Mapper = session.getMapper(Table_3_mapper.class);
			return t3Mapper.selectBoardInfo(biNum);
		}
	}
	
	public int insertBoardInfo(Table_3_VO t3) {
		try(SqlSession session = Mybatis.getFactory().openSession(true)) {
			Table_3_mapper t3Mapper = session.getMapper(Table_3_mapper.class);
			return t3Mapper.insertBoardInfo(t3);
		}
	}
	
	public int updateBoardInfo(Table_3_VO t3) {
		try(SqlSession session = Mybatis.getFactory().openSession(true)) {
			Table_3_mapper t3Mapper = session.getMapper(Table_3_mapper.class);
			return t3Mapper.updateBoardInfo(t3);
		}
	}
	
	public int deleteBoardInfo(int biNum) {
		try(SqlSession session = Mybatis.getFactory().openSession(true)) {
			Table_3_mapper t3Mapper = session.getMapper(Table_3_mapper.class);
			return t3Mapper.deleteBoardInfo(biNum);
		}
	}
}
