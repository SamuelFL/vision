package com.yvh.vision.core.model.exception;

import org.springframework.http.HttpStatus;

public enum VisionError {
    NO_TARGETS_FOUND("No targets found", HttpStatus.BAD_REQUEST, "No valid target found for given protocols");
    private final String title;

    private final HttpStatus status;

    private final String detail;

    VisionError(String title, HttpStatus status, String detail) {
        this.title = title;
        this.status = status;
        this.detail = detail;

    }

    public String getTitle() {
        return title;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }
}
