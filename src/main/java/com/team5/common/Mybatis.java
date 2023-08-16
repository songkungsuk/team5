package com.team5.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.team5.mapper.Table_3_mapper;
import com.team5.mapper.Table_2_Mapper;
import com.team5.mapper.UserInfoMapper;
import com.team5.vo.Table_3_VO;
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
//		SqlSession session = ssf.openSession(true);
//		Table_3_mapper t3Mapper = session.getMapper(Table_3_mapper.class);
//		System.out.println(t3Mapper.selectBoardInfoList(null));
//		System.out.println(t3Mapper.selectBoardInfo(1));
//		Table_3_VO t3 = new Table_3_VO();
//		t3.setBiTitle("test1");
//		t3.setBiContent("test1");
//		t3.setUiNum(3);
//		t3.setUiName("test1");
//		System.out.println(t3Mapper.insertBoardInfo(t3));
//		t3.setBiNum(5);
//		System.out.println(t3Mapper.updateBoardInfo(t3));
//		System.out.println(t3Mapper.deleteBoardInfo(t3));
		SqlSession session = ssf.openSession();
		Table_2_Mapper tMapper = session.getMapper(Table_2_Mapper.class);
		System.out.println(tMapper.selectTableList(null));
	}
}
