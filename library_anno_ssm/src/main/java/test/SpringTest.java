package test;

import cn.ssm.service.BookService;
import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void testService() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bs = (BookService) ac.getBean("BookService");
        bs.findAllBooks();
    }


}
