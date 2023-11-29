package com.ohgiraffers.section01.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceFiled")    // 서비스 계층임을 알려주는 어노테이션
public class BookService {

    @Autowired  // 자동으로 찾아서 의존성을 주입해준다.
    private BookDAO bookDAO;

//    public BookService(BookDAO bookDAO) {
//        this.bookDAO = bookDAO;
//    }

    public List<BookDTO> selectAllBook(){
        return bookDAO.selectBookList();
    }

    public BookDTO selectOneBook(int seq){
        return bookDAO.selectOneBook(seq);
    }
}
