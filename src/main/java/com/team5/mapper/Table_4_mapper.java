package com.team5.mapper;

import java.util.List;

import com.team5.vo.Table_4_VO;

public interface Table_4_mapper {
	List<Table_4_VO> selectInfoList(Table_4_VO table);

	Table_4_VO selecttInfoList(int uiNum);

	int insertTable_4(Table_4_VO table);

	int updateTable_4(Table_4_VO table);

	int deleteTable_4(int uiNum);

}
