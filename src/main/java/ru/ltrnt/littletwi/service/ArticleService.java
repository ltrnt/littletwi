package ru.ltrnt.littletwi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ltrnt.littletwi.entity.Article;
import ru.ltrnt.littletwi.repository.ArticleRepository;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    public Article getArticleById(long id) {
        return articleRepository.getOne(id);
    }
}
