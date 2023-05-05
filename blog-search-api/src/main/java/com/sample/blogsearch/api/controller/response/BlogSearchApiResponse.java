package com.sample.blogsearch.api.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;


public record BlogSearchApiResponse(
        @Schema(description = "블로그 리스트") List<Blog> blogList,
        @Schema(description = "검색된 문서 수") long totalCnt,
        @Schema(description = "다음페이지 존재 유무") boolean hasNext
) {
    private record Blog(
            @Schema(description = "블로그 이름", example = "Kevin Seokbum Lee") String blogName,
            @Schema(description = "블로그 글 제목", example = "[15.5.11.~15.6.6., D+172] The begining of part 3 on Hamilton Island") String title,
            @Schema(description = "블로그 글 요약", example = "시드니는 여기에 비해서는 천국 어쨋든 긴 Break을 마치고 호주 워홀의 part 3를... 워홀의 part 3가 너무 금방 끝나버릴 수도 있었지만 꾹꾹 참고 이대로 포기하지 않고...") String contents,
            @Schema(description = "블로그 글 url", example = "https://blog.naver.com/livelysb/220382501743") String url,
            @Schema(description = "블로그 글 대표 섬네일", example = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20150606_229%2Flivelysb_1433595574978MTWo7_JPEG%2F1431304725523.jpeg%23550x412&amp;type=ff264_180") String thumbnail,
            @Schema(description = "블로그 글 작성일시") LocalDateTime createdAt
    ) {
    }
}
