package com.dong.mapper;

import com.dong.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookMapper {

    public List<Book> getAllBooks();

    List<Book> getBooksByPage(@Param("start") Integer start, @Param("size") Integer size);

    List<Book> getBookByNameOrAuthor(Book book);

    Integer updateBook(Book book);

    Integer updateBook2(@Param("book")Map<String,Object> map,@Param("id") Long id);

    List<Book> getBooksByIds(@Param("ids") List<Long> ids);

    Integer batchAddBook(@Param("books") List<Book> books);

    List<Book> getBooksByVendor(String vendor);


    List<Map<String,Object>> allBooks();
}
