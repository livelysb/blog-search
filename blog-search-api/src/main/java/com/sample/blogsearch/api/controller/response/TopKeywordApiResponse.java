package com.sample.blogsearch.api.controller.response;

import com.sample.blogsearch.domain.SearchKeywordDto;
import io.swagger.v3.oas.annotations.media.Schema;

public record TopKeywordApiResponse(
        @Schema(description = "검색어", example = "Hamilton Island")
        String keyword,
        @Schema(description = "검색횟수")
        Long searchedCnt
) {
    public static TopKeywordApiResponse fromDto(SearchKeywordDto searchKeywordDto) {
        return new TopKeywordApiResponse(
                searchKeywordDto.keyword(),
                searchKeywordDto.searchCnt()
        );
    }

}
