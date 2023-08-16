package com.team5.mapper;

import java.util.List;

import com.team5.vo.UserInfoVO;

public interface UserInfoMapper {
	List<UserInfoVO> selectUserInfoList (UserInfoVO user);
	UserInfoVO selectUserInfo(int uiNum);
	int insertUserInfo(UserInfoVO user);
	int updateUserInfo(UserInfoVO user);
	int deleteUserInfo(int uiNum);
}
