package com.team5.mapper;

import java.util.List;

import com.team5.vo.Table_1_VO;

public interface Table_1_Mapper {
	List<Table_1_VO> selectTable_1_List(Table_1_VO table);
	Table_1_VO selectTable_1(int biNum);
	int insertTable_1(Table_1_VO table);
	int updateTable_1(Table_1_VO table);
	int deleteTable_1(int biNum);
	
}
