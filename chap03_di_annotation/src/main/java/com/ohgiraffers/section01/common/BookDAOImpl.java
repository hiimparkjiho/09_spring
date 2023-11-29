package com.ohgiraffers.section01.common;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("bookDAO") // 데이터 계층 DB와 커넥션 맺는 계층
public class BookDAOImpl implements BookDAO{

    private Map<Integer, BookDTO> bookList;

    public BookDAOImpl() {
        bookList = new HashMap<>();
        bookList.put(1, new BookDTO(1, 123, "자바의 정석", "남궁성", "도우출판", new Date()));
        bookList.put(2, new BookDTO(1, 456, "칭찬은 고래도 춤추게 한다", "고래", "고래출판", new Date()));
    }

    @Override
    public List<BookDTO> selectBookList() {

        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO selectOneBook(int seq) {
        return bookList.get(seq);
    }
}
