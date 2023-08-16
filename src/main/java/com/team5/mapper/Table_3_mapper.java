package com.team5.mapper;

import java.util.List;

import com.team5.vo.Table_3_VO;

public interface Table_3_mapper {
	List<Table_3_VO> selectBoardInfoList(Table_3_VO t3);
	Table_3_VO selectBoardInfo(int biNum);
	int insertBoardInfo(Table_3_VO t3);
	int updateBoardInfo(Table_3_VO t3);
	int deleteBoardInfo(int biNum);
}
