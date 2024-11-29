package com.yvh.vision.core.model.exception;

public class VisionException extends RuntimeException {
    private final VisionError visionError;

    public VisionException(VisionError visionError) {
        this.visionError = visionError;
    }

    public VisionError getVisionError() {
        return visionError;
    }
}
