package com.example.korber.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.korber.entity.Article;

@Service
public class ArticleManagerImpl implements ArticleManager {
     private List<Article> articles = new ArrayList<>();

    @Override
    public Article getArticle(UUID id) {
        for (Article article : articles) {
            if (article.getId().equals(id)) {
                return article; // retorns article 
            }
        }
        return null; // retorns 'null' if can't find the id
    }

    @Override
    public Article createArticle(Article article) {
        articles.add(article);
        System.out.println("New article created!");
        return article;
    }

    
    @Override
    public void deleteArticle(UUID id) {
        boolean removed = articles.removeIf(article -> article.getId().equals(id));
        if (removed) {
            System.out.println("Article removed!");
        } else {
            System.out.println("Article not found!");
        }
    }
    
}
