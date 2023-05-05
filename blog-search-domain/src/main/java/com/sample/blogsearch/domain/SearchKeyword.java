package com.sample.blogsearch.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(
        indexes = {
                @Index(name = "idx_search_cnt", columnList = "searchCnt DESC"),
                @Index(name = "udx_keyword", columnList = "keyword", unique = true)
        }
)
@Getter
@NoArgsConstructor
public class SearchKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String keyword;

    private long searchCnt;

    public SearchKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void increaseSearchCnt(long searchCnt) {
        this.searchCnt += searchCnt;
    }
}
