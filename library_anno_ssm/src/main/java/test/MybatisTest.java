package test;

import cn.ssm.dao.BookDao;
import cn.ssm.domain.Books;
import cn.ssm.service.BookService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void MybatisTest() throws IOException {


        //加载mybatis配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlsession对象
        SqlSession sqlSession = factory.openSession(true);
        //获取代理对象
        BookDao dao = sqlSession.getMapper(BookDao.class);

        List<Books> books = dao.findAllBooks();
        for (Books book : books) {
            System.out.println(book);

        }

        sqlSession.close();
        in.close();

    }
}
