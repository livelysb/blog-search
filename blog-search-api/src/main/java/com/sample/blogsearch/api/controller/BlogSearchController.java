package com.sample.blogsearch.api.controller;

import com.sample.blogsearch.api.controller.requst.BlogSearchApiRequest;
import com.sample.blogsearch.api.controller.response.BlogSearchApiResponse;
import com.sample.blogsearch.api.controller.response.TopKeywordApiResponse;
import com.sample.blogsearch.domain.SearchKeywordService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BlogSearchController {

    SearchKeywordService searchKeywordService;

    @Operation(summary = "블로그 검색")
    @GetMapping("/search/blog")
    public BlogSearchApiResponse searchBlog(
            @Valid @ModelAttribute BlogSearchApiRequest blogSearchApiRequest
    ) {
        searchKeywordService.increaseSearchedCnt(blogSearchApiRequest.query(), 1L);
        return null;
    }

    @Operation(summary = "인기 검색어 목록(최대 10개 검색어 제공)")
    @GetMapping("/top-keywords")
    public List<TopKeywordApiResponse> getTopKeywords() {
        return searchKeywordService.getTopKeywords().stream().map(TopKeywordApiResponse::fromDto).toList();
    }
}
