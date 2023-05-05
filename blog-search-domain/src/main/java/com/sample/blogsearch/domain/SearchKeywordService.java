package com.sample.blogsearch.domain;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class SearchKeywordService {

    SearchKeywordRepository searchKeywordRepository;

    @Transactional
    public void increaseSearchCnt(String keyword, long searchCnt) {
        SearchKeyword searchKeyword = Optional.ofNullable(searchKeywordRepository.findByKeyword(keyword)).orElse(new SearchKeyword(keyword));
        searchKeyword.increaseSearchCnt(searchCnt);
        searchKeywordRepository.save(searchKeyword);
    }

    @Transactional
    public List<SearchKeywordDto> getTopKeywords() {
        return searchKeywordRepository.findTop10ByOrderBySearchCntDesc().stream().map(SearchKeywordDto::fromEntity).toList();
    }
}
