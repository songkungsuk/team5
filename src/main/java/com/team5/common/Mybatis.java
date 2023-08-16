package com.team5.common;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.team5.mapper.UserInfoMapper;
import com.team5.vo.UserInfoVO;

public class Mybatis {
	private static SqlSessionFactory ssf;
	private static final String CONFIG_PATH = "config/mybatis-config.xml";
	
	static {
		try {
			InputStream is = Resources.getResourceAsStream(CONFIG_PATH);			
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			ssf = ssfb.build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static SqlSessionFactory getFactory() {
		return ssf;
	}
	
	public static void main(String[] args) {
		SqlSession session = ssf.openSession();
		UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
		System.out.println(uiMapper.selectUserInfoList(null));
	}
}
