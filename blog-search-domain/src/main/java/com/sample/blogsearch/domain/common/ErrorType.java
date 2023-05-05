package com.sample.blogsearch.domain.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public enum ErrorType {
    BAD_REQUEST("BAD_REQUEST", "잘못된 요청입니다.");

    String code;
    String description;
}
