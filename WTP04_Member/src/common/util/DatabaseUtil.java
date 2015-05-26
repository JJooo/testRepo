package common.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DatabaseUtil {
	
	private static DatabaseUtil instance = new DatabaseUtil();
	private SqlSessionFactory factory;
	
	private DatabaseUtil(){
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		factory = new SqlSessionFactoryBuilder().build(is);
	}
	
	public static DatabaseUtil getInstance(){
		return instance;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		return factory;
	}

}