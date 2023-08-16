package com.team5.mapper;

import java.util.List;

import com.team5.vo.Table_2_VO;

public interface Table_2_Mapper {
	List<Table_2_VO> selectTableList (Table_2_VO table);
	Table_2_VO selectTable(int biNum);
	int insertTable (Table_2_VO table);
	int updateTable (Table_2_VO table);
	int deleteTable (int biNum);

}
