package com.example.board2.app.article.repository;

import com.example.board2.app.article.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Page<Article> findAll(Pageable pageable);
}

