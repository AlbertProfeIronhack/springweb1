package com.example.korber.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.korber.entity.Article;
import com.example.korber.services.ArticleManager;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ArticleController {
    @Autowired
    private ArticleManager articleManager;


    // GET ONE BY ID
    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable UUID id) {
        return articleManager.getArticle(id);
    }

    // POST
    @PostMapping("/article")
    public Article createArticle(@RequestBody Article article) {
        return articleManager.createArticle(article);
    }

    // PUT (it uses the same method as POST)
    @PutMapping("/article/{id}")
    public Article createArticle(@PathVariable UUID id, @RequestBody Article article) {
        return articleManager.createArticle(article); 
    }

    // DELETE
    @DeleteMapping("/article/{id}")
    public void deleteArticle(@PathVariable UUID id) {
        articleManager.deleteArticle(id);
    }

}
