package com.dong.test;

import com.dong.mapper.ArticleMapper;
import com.dong.mapper.BookMapper;
import com.dong.mapper.UserMapper;
import com.dong.model.Article;
import com.dong.model.Book;
import com.dong.model.User;
import com.dong.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    private SqlSession sqlSession;
    private UserMapper userMapper;
    private BookMapper bookMapper;
    private ArticleMapper articleMapper;

    @Before
    public void before() {
        System.out.println("invoke before");
        sqlSession = SqlSessionFactoryUtils.getInstance().openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        bookMapper = sqlSession.getMapper(BookMapper.class);
        articleMapper = sqlSession.getMapper(ArticleMapper.class);
    }

    @Test
    public void getAllUser() {
        List<User> userList = userMapper.getAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserById() {
        User user = userMapper.getUserById(1L);
        System.out.println(user);
    }

    @Test
    public void getUserOrderBy() {
        List<User> userList = userMapper.getUserOrderBy("username");
        for (User user : userList) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void getUserNameContains() {
        List<User> userList = userMapper.getUserNameContains("wang");
        for (User user : userList) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void updateUsernameById() {
        Integer result = userMapper.updateUsernameById("zhangsan", 1L);
        sqlSession.commit();
        System.out.println("result = " + result);
    }
    
    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("jerry");
        user.setAddress("usa");
        userMapper.addUser(user);
        sqlSession.commit();
        System.out.println("user = " + user);
    }

    @Test
    public void getUserCount(){
        Long userCount = userMapper.getUserCount();
        System.out.println("userCount = " + userCount);
    }

    @Test
    public void getAllBooks() {
        List<Book> allBooks = bookMapper.getAllBooks();
        for (Book book : allBooks) {
            System.out.println("book = " + book);
        }
    }

    @Test
    public void getBooksByPage() {
        List<Book> allBooks = bookMapper.getBooksByPage(3,3);
        for (Book book : allBooks) {
            System.out.println("book = " + book);
        }
    }

    @Test
    public void getBooksByPage2() {
        List<Book> allBooks = bookMapper.getBooksByPage(null,null);
        for (Book book : allBooks) {
            System.out.println("book = " + book);
        }
    }

    @Test
    public void getBookByNameOrAuthor() {
        Book book = new Book();
        book.setName("book-01");
        List<Book> allBooks = bookMapper.getBookByNameOrAuthor(book);
        for (Book b : allBooks) {
            System.out.println("b = " + book);
        }
    }


    @Test
    public void updateBook() {
        Book book = new Book(1L, "book-01","vendor-01-update");
        Integer affect = bookMapper.updateBook(book);
        sqlSession.commit();
        System.out.println("affect = " + affect);
    }

    @Test
    public void getBooksByIds() {
        List<Book> booksByIds = bookMapper.getBooksByIds(Arrays.asList(1L, 2L));
        System.out.println("booksByIds = " + booksByIds);
    }

    @Test
    public void batchAddBook() {
        Integer affectCount = bookMapper.batchAddBook(Arrays.asList(new Book("book-03", "vendor-03"),
                new Book("book-04", "vendor-04")));
        sqlSession.commit();
        System.out.println("affectCount = " + affectCount);
    }

    @Test
    public void updateBook2() {
        Map<String,Object> map = new HashMap<>();
        map.put("book_name", "book-name-update-2021");
        map.put("vendor", "vendor-update-2021");
        Integer affect = bookMapper.updateBook2(map,1L);
        sqlSession.commit();
        System.out.println("affect = " + affect);
    }

    @Test
    public void getBooksByVendor() {
        List<Book> books = bookMapper.getBooksByVendor("vendor");
        System.out.println("books = " + books);
    }

    @Test
    public void getArticleById() {
        Article article = articleMapper.getArticleById(1L);
        System.out.println("article = " + article);
    }

    @Test
    public void getArticleById2() {
        Article article = articleMapper.getArticleById2(1L);
        System.out.println("article = " + article);
    }

    @Test
    public void getArticleById3() {
        Article article = articleMapper.getArticleById3(1L);
        System.out.println("article = " + article);
    }

    @Test
    public void getArticleById4() {
        Article article = articleMapper.getArticleById4(1L);
        System.out.println("article.getTitle() = " + article.getTitle());
        System.out.println("article.getAuthor().getAge() = " + article.getAuthor().getAge());
    }

    @Test
    public void getAllUsersWithRole() {
        List<User> allUsersWithRole = userMapper.getAllUsersWithRole();
        System.out.println("allUsersWithRole = " + allUsersWithRole);
    }

    @Test
    public void getAllUsersWithRole2() {
        List<User> allUsersWithRole = userMapper.getAllUsersWithRole2();
        for (User user : allUsersWithRole) {
            System.out.println("user.getUsername() = " + user.getUsername());
//            System.out.println("user = " + user);
        }
    }


    @Test
    public void getAllUsersWithRole3() {
        List<User> allUsersWithRole = userMapper.getAllUsersWithRole3();
        for (User user : allUsersWithRole) {
            System.out.println(user);
        }
    }

    @Test
    public void addUser3() {
        userMapper.addUser3(new User("jack", "beijing", 1, Arrays.asList("computer","song","dance","pingpang")));
        sqlSession.commit();
    }

    @Test
    public void getAllUserByPage() {
        List<User> allUserByPage = userMapper.getAllUserByPage(new RowBounds(1, 2));
        for (User user : allUserByPage) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void allBooks() {
        List<Map<String, Object>> maps = bookMapper.allBooks();
        for (Map<String, Object> map : maps) {
            System.out.println("map = " + map);
        }
    }

    @Test
    public void testPage() {
        List<User> allUserByPage = userMapper.getAllUserByPage(new RowBounds(1, 2));
        for (User user : allUserByPage) {
            System.out.println("user = " + user);
        }
    }

    @After
    public void after() {
        System.out.println("invoke after");
        sqlSession.close();
    }
}
