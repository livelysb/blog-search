package com.sample.blogsearch.api.controller.response;

import com.sample.blogsearch.domain.common.ErrorType;

public record ErrorApiResponse(
        ErrorType errorType,
        String errorMessage
) {

    public String getErrorDescription() {
        return errorType.getDescription();
    }
}
