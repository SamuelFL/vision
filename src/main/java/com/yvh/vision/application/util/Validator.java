package com.yvh.vision.application.util;

import java.security.InvalidParameterException;
import java.util.Collection;

public class Validator {

    private Validator() {
    }

    public static void notNull(Object obj, String name) {
        if (obj == null)
            throwException(name + " cannot be null.");
    }

    public static void notEmpty(Collection collection, String name) {
        notNull(collection, name);
        if (collection.isEmpty()) throwException(name + " cannot be empty.");
    }

    private static void throwException(String message) {
        throw new InvalidParameterException(message);
    }
}
