package com.nklongyi.Respository;

import com.nklongyi.Dao.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by longyi on 2017/8/27.
 */
public interface ArticleRespository extends JpaRepository<Article,Long> {
    List<Article> findAll();
    Article findById(long id);
    Article save(Article article);
    void deleteById(long id);
}
