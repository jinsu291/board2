package com.example.board2.app.comment.service;

import com.example.board2.app.article.entity.Article;
import com.example.board2.app.comment.entity.Comment;
import com.example.board2.app.comment.repository.CommentRepository;
import com.example.board2.app.exception.DataNotFoundException;
import com.example.board2.app.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    // 답변 저장하기
    public void create(Article article, String content, SiteUser author) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCreateDate(LocalDateTime.now());
        comment.setArticle(article);
        comment.setAuthor(author);
        this.commentRepository.save(comment);
    }

    public Comment getComment(Integer id) {
        Optional<Comment> comment = this.commentRepository.findById(id);
        if (comment.isPresent()) {
            return comment.get();
        } else {
            throw new DataNotFoundException("comment not found");
        }
    }

    public void modify(Comment comment, String content) {
        comment.setContent(content);
        comment.setModifyDate(LocalDateTime.now());
        this.commentRepository.save(comment);
    }

    public void delete(Comment comment) {
        this.commentRepository.delete(comment);
    }
}
