package com.team5.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team5.common.Mybatis;
import com.team5.mapper.UserInfoMapper;
import com.team5.vo.UserInfoVO;

public class UserInfoService {
	
	public List<UserInfoVO> getUserInfos(UserInfoVO user){
		try(SqlSession session = Mybatis.getFactory().openSession()){
			UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
			return uiMapper.selectUserInfoList(user); 
			//인스턴스 명은 내마음대로 해놔서 살짝 달라보일수도 있으니 주의.. 
		}
	}
	
	public UserInfoVO getUserInfo(int uiNum) {
		try(SqlSession session = Mybatis.getFactory().openSession()){
			UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
			return uiMapper.selectUserInfo(uiNum);
		}
	}
	
	
}
