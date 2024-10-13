package com.example.korber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.korber.entity.Article;
import com.example.korber.services.ArticleManager;
import com.example.korber.services.ArticleManagerImpl;

@SpringBootTest
class KorberApplicationTests {

	@Test
	void contextLoads() {
	}

	private ArticleManager articleManager;

    @BeforeEach
    void setUp() {
        articleManager = new ArticleManagerImpl();
    }

    // saving a new UUID to use it in all tests:
    UUID articleUuid = UUID.randomUUID();

    @Test
    void testCreateArticle() {
        Article article = new Article();
        
        article.setId(articleUuid);
        article.setDescription("Test Article");
        article.setWeight(10.0);
        article.setVolume(5.0);
        article.setActive(true);

        Article createdArticle = articleManager.createArticle(article);
        assertNotNull(createdArticle);
        assertEquals(article.getId(), createdArticle.getId());
    }
    
    
    @Test
    void testGetArticle() {
        Article article = new Article();
        article.setId(articleUuid);
        articleManager.createArticle(article);

        Article retrievedArticle = articleManager.getArticle(articleUuid);
        assertNotNull(retrievedArticle);
        assertEquals(article.getId(), retrievedArticle.getId());
    }


    @Test
    void testDeleteArticle() {
        Article article = new Article();

        articleManager.createArticle(article);


        articleManager.deleteArticle(articleUuid);
        article = null;

        assertTrue(article == null);
    }
  
}
