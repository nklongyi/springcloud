package com.nklongyi.Service;

import com.nklongyi.Dao.Article;
import com.nklongyi.Respository.ArticleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by longyi on 2017/8/27.
 */
@Service
public class ArticleService{
    @Autowired
    ArticleRespository articleRespository;

    public List<Article> findAll(){
        return articleRespository.findAll();
    }

    public Article findById(long id){
        return articleRespository.findById(id);
    }

    public Article save(Article article){
        return articleRespository.save(article);
    }

    public void deleteById(long id){
        articleRespository.deleteById(id);
    }
}
