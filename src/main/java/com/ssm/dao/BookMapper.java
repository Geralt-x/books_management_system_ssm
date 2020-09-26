package com.ssm.dao;

import com.ssm.pojo.Books;

import java.util.List;

public interface BookMapper {

    //增加
    int addBook(Books book);

    //根据id删除一种书
    int deleteBookById(int id);

    //更新
    int updateBook(Books books);

    //根据id查询,返回一个book
    Books queryBookById(int id);

    //查询所有Books
    List<Books> queryAllBook();

    //根据书名查询书籍
    Books queryBookByName(String bookName);

    //模糊查询
    List<Books> findByName(String bookName);


}
