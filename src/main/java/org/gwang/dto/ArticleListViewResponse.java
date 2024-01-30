package org.gwang.dto;

import lombok.Getter;
import org.gwang.domain.Article;

import java.time.LocalDateTime;

@Getter
public class ArticleListViewResponse {
    private final long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
