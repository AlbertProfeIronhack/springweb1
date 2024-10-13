package com.example.korber.services;

import java.util.UUID;

import com.example.korber.entity.Article;

public interface ArticleManager {
    Article createArticle(Article article);
    Article getArticle(UUID id);
    void deleteArticle(UUID id);
}
