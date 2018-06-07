package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException(Enum type) {
        if (type == null) return new IllegalArgumentException();
        String message = type.name().charAt(0) + type.name().substring(1).toLowerCase().replace("_", " ");
        String className = type.getClass().getSimpleName();
        if (className.equals("ExceptionApplicationMessage")) {
            return new Exception(message);
        } else if (className.equals("ExceptionDBMessage")) {
            return new RuntimeException(message);
        } else if (className.equals("ExceptionUserMessage")) {
            return new Error(message);
        } else {
            return new IllegalArgumentException();
        }
    }
}
