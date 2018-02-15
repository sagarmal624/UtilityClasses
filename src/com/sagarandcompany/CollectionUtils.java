package com.sagarandcompany;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static <T extends List> List<T> unique(T source) {
        if (Objects.nonNull(source))
            return (List<T>) source.stream().distinct().collect(Collectors.toList());
        else
            return null;
    }

    public static <T extends List> void removeDuplicate(T source) {
//        if (Objects.nonNull(source))
        Map<Object, Long> map = new HashMap<>();
        for (Object obj : source) {
            if (map.containsKey(obj)) {

            }
        }

    }

}

