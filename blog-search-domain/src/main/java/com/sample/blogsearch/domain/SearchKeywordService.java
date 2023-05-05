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
    public void increaseSearchedCnt(String keyword, long searchedCnt) {
        SearchKeyword searchKeyword = Optional.ofNullable(searchKeywordRepository.findByKeyword(keyword)).orElse(new SearchKeyword(keyword));
        searchKeyword.increaseSearchedCnt(searchedCnt);
        searchKeywordRepository.save(searchKeyword);
    }

    @Transactional
    public List<SearchKeywordDto> getTopKeywords() {
        return searchKeywordRepository.findTop10ByOrderBySearchedCntDesc().stream().map(SearchKeywordDto::fromEntity).toList();
    }
}
