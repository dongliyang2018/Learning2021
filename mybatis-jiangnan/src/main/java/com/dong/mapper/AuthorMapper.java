package com.dong.mapper;

import com.dong.model.Article;
import com.dong.model.Author;

/**
 * AuthorMapper
 * @version 1.0 2021/4/25
 * @author dongliyang
 */
public interface AuthorMapper {

    Author getAuthorById(Long id);
}
