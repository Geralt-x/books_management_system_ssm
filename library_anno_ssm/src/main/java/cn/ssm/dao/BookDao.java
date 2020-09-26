package cn.ssm.dao;

import cn.ssm.domain.Books;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {

    @Insert("insert into books(bookName,bookCounts,detail) values(#{bookName},#{bookCounts},#{detail})")
    int addBooks(Books book);

    @Delete("delete from books where bookID = #{bookId}")
    int deleteBooks(int bookId);

    @Update("update books set bookName = #{bookName},bookCounts = #{bookCounts},detail = #{detail} where bookID = #{bookID}")
    int updateBooks(Books books);

    @Select("select * from books")
    List<Books> findAllBooks();

    @Select("select * from books where bookID = #{BookId}")
    Books findBooksById(int BookId);

    @Select("select * from books where bookName = #{bookName}")
    Books findBookByName(String bookName);
}
