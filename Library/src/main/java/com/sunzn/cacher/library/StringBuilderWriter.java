package com.sunzn.cacher.library;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.io.Writer;

public class StringBuilderWriter extends Writer implements Serializable {

    private static final long serialVersionUID = -146927496096066153L;

    private final StringBuilder builder;

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    public StringBuilderWriter(int capacity) {
        this.builder = new StringBuilder(capacity);
    }

    public StringBuilderWriter(StringBuilder builder) {
        this.builder = builder != null ? builder : new StringBuilder();
    }

    @NonNull
    public Writer append(char value) {
        this.builder.append(value);
        return this;
    }

    @NonNull
    public Writer append(CharSequence value) {
        this.builder.append(value);
        return this;
    }

    @NonNull
    public Writer append(CharSequence value, int start, int end) {
        this.builder.append(value, start, end);
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(@NonNull String value) {
        this.builder.append(value);
    }

    public void write(@NonNull char[] value, int offset, int length) {
        this.builder.append(value, offset, length);
    }

    public StringBuilder getBuilder() {
        return this.builder;
    }

    @NonNull
    public String toString() {
        return this.builder.toString();
    }
}
