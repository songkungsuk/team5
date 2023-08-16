package com.team5.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.team5.mapper.Table_2_Mapper;
import com.team5.mapper.UserInfoMapper;

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
		Table_2_Mapper tMapper = session.getMapper(Table_2_Mapper.class);
		System.out.println(tMapper.selectTableList(null));
	}
}
