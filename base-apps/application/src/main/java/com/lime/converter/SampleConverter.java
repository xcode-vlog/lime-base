package com.lime.converter;


import com.lime.persistence.domain.response.SampleResponse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class SampleConverter {
    private SampleConverter() {}

    public static <T> T toDomain(SampleResponse response, Class<T> target) {
        try {
            Method from = target.getMethod("from", response.getClass());
            return (T) from.invoke(target, response);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
