package com.sample.blogsearch.domain;

public record SearchKeywordDto(
        Long id,
        String keyword,
        long searchedCnt
) {
    public static SearchKeywordDto fromEntity(SearchKeyword searchKeyword) {
        return new SearchKeywordDto(
                searchKeyword.getId(),
                searchKeyword.getKeyword(),
                searchKeyword.getSearchedCnt()
        );
    }
}
