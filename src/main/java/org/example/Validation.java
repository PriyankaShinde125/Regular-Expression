package org.example;

@FunctionalInterface
public interface Validation<T> {
     boolean validate(T input);
}
