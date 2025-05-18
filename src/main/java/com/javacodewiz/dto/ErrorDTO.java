package com.javacodewiz.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    private String apiPath;
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;
}
