package com.sample.blogsearch.api.controller.requst;

import com.sample.blogsearch.domain.common.SearchSort;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BlogSearchApiRequest(
        @Schema(description = "검색어", example = "Hamilton Island")
        @NotBlank(message = "검색어는 필수로 입력해야 합니다.")
        String query,
        @Schema(description = "검색결과 정렬방식", example = "ACCURACY")
        @NotNull(message = "검색결과 정렬방식을 필수로 입력해야 합니다.")
        SearchSort searchSort,
        @Schema(description = "검색페이지", example = "1", defaultValue = "1", nullable = true)
        @Min(value = 1, message = "검색페이지는 1 이상의 값을 입력해야 합니다.")
        @Max(value = 50, message = "검색페이지는 50 이하의 값을 입력해야 합니다.")
        Integer page,
        @Schema(description = "검색사이즈", example = "10", defaultValue = "10", nullable = true)
        @Min(value = 1, message = "검색사이즈는 1 이상의 값을 입력해야 합니다.")
        @Max(value = 50, message = "검색사이즈는 50 이하의 값을 입력해야 합니다.")
        Integer size
) {
    public BlogSearchApiRequest {
        page = page != null ? page : 1;
        size = size != null ? size : 10;
    }
}
