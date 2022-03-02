package com.instaclustr.kafka.connect.s3;

public class JsonSerializationException extends RuntimeException {
    public JsonSerializationException(final String message) {
        super(message);
    }
}
