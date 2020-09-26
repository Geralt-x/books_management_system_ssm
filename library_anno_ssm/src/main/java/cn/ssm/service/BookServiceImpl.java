package cn.ssm.service;

import cn.ssm.dao.BookDao;
import cn.ssm.domain.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public int addBooks(Books book) {
        return bookDao.addBooks(book);
    }

    @Override
    public int deleteBooks(int bookId) {
        return bookDao.deleteBooks(bookId);
    }

    @Override
    public int updateBooks(Books books) {
        return bookDao.updateBooks(books);
    }

    @Override
    public List<Books> findAllBooks() {
        System.out.println("Service:findAllBooks()");
        return bookDao.findAllBooks();
    }

    @Override
    public Books findBooksById(int BookId) {
        return bookDao.findBooksById(BookId);
    }

    @Override
    public Books findBookByName(String bookName) {
        return bookDao.findBookByName(bookName);
    }
}
