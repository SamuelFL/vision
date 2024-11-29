package com.yvh.vision.configuration;

import com.yvh.vision.core.model.exception.VisionError;
import com.yvh.vision.core.model.exception.VisionException;
import com.yvh.vision.web.rest.model.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.yvh")
public class VisionExceptionHandler {

    @ExceptionHandler(VisionException.class)
    public ResponseEntity<ErrorResponseDto> handleVisionException(VisionException exception) {
        VisionError visionError = exception.getVisionError();
        ErrorResponseDto errorResponseDto =
                new ErrorResponseDto(visionError.getTitle(), visionError.getStatus(), visionError.getDetail());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(errorResponseDto, httpHeaders, errorResponseDto.getStatus());
    }
}
