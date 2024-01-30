package org.gwang.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter     // getId(), getTitle(), getContent() 생성 대체
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 기본 생성자 protected Article() { } 대체
public class Article {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false)
        private Long id;

        @Column(name = "title", nullable = false)
        private String title;

        @Column(name = "content", nullable = false)
        private String content;

        @Column(name = "author", nullable = false)
        private String author;

        @CreatedDate    // 엔티티가 생성될 때 생성 시간 저장
        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @LastModifiedDate       // 엔티티가 수정될 때 수정 시간 저장
        @Column(name = "updated_at")
        private LocalDateTime updatedAt;


        /* 빌더 패턴으로 객체 생성 - 객체를 유연하고 직관적으로 생성할 수 있음. 직관적임
         new Article("abc", "def"); -> Article.builder().title("abc").content("def").build(); */
        @Builder
        public Article(String author, String title, String content) {
                this.author = author;
                this.title = title;
                this.content = content;
        }

        public void update(String title, String content) {
                this.title = title;
                this.content = content;
        }


}
