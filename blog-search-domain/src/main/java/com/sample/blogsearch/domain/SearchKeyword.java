package com.sample.blogsearch.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(
        indexes = {
                @Index(name = "idx_search_cnt", columnList = "searchedCnt DESC"),
                @Index(name = "udx_keyword", columnList = "keyword", unique = true)
        }
)
@Getter
@NoArgsConstructor
public class SearchKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;

    private long searchedCnt;

    public SearchKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void increaseSearchedCnt(long searchedCnt) {
        this.searchedCnt += searchedCnt;
    }
}
