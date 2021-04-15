package ru.vilgor.bustracker.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {

    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    private List<ApiSubError> subErrorList;

    public static class Builder {
        private HttpStatus status;
        private String message;
        private String debugMessage;

        private LocalDateTime timestamp = LocalDateTime.now();

        public Builder() {

        }

        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder debugMessage(Throwable ex) {
            this.debugMessage = ex.getLocalizedMessage();
            return this;
        }

        public ApiError build() {
            return new ApiError(this);
        }
    }

    private ApiError(Builder builder) {
        status = builder.status;
        message = builder.message;
        debugMessage = builder.debugMessage;
        timestamp = builder.timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public List<ApiSubError> getSubErrorList() {
        return subErrorList;
    }

    public void setSubErrorList(List<ApiSubError> subErrorList) {
        this.subErrorList = subErrorList;
    }
}
