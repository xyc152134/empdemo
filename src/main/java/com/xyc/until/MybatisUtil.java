package com.xyc.until;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
    private static final boolean DEFAULT_AUTO_COMMIT=true;
    private static final SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(MybatisUtil.class.getClassLoader().getResourceAsStream("mybatis.xml"));
    public  static SqlSession getSqlSession(){
        return  factory.openSession(DEFAULT_AUTO_COMMIT);
    }
    public  static SqlSession getSqlSession(boolean autoCommit){
        return  factory.openSession(autoCommit);
    }
}
