package com.sample.blogsearch.api.controller.response;

public record ErrorApiResponse(
        String errorCode,
        String errorMessage
) {
}
