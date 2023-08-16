package com.team5.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team5.common.Mybatis;
import com.team5.mapper.Table_4_mapper;
import com.team5.vo.Table_4_VO;

public class Table_4Service {

	public List<Table_4_VO> getTable_4(Table_4_VO table){
		try(SqlSession session = Mybatis.getFactory().openSession()){
			Table_4_mapper tiMapper = session.getMapper(Table_4_mapper.class);
			return tiMapper.selectInfoList(table);
		}	
	}
	
	public Table_4_VO getTable_4(int uiNum) {
		try(SqlSession session = Mybatis.getFactory().openSession()){
			Table_4_mapper tiMapper = session.getMapper(Table_4_mapper.class);
			return tiMapper.selecttInfoList(uiNum);
		}
	}
	
	
	
}
