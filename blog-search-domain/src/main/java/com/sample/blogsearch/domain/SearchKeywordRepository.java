package com.sample.blogsearch.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SearchKeywordRepository extends JpaRepository<SearchKeyword, Long> {

    SearchKeyword findByKeyword(String keyword);

    List<SearchKeyword> findTop10ByOrderBySearchedCntDesc();
}
