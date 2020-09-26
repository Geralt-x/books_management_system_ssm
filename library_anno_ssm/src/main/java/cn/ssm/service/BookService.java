package cn.ssm.service;

import cn.ssm.domain.Books;

import java.util.List;

public interface BookService {

    int addBooks(Books book);

    int deleteBooks(int bookId);

    int updateBooks(Books books);

    List<Books> findAllBooks();

    Books findBooksById(int BookId);

    Books findBookByName(String bookName);
}
