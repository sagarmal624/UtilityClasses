package com.sagarandcompany;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static <T extends List> List<T> unique(T source) {
        if (Objects.nonNull(source))
            return (List<T>) source.stream().distinct().collect(Collectors.toList());
        else
            return null;
    }

    public static <T extends List> T removeDuplicate(T source) {
//        if (Objects.nonNull(source))
        Map<Object, Long> map = new HashMap<>();
        for (Object obj : source) {
            if (map.containsKey(obj)) {
                Long counter = map.get(obj);
                map.put(obj, ++counter);
            } else
                map.put(obj, 1L);
        }
        source.clear();
        for (Map.Entry<Object, Long> entry : map.entrySet()) {
            if (entry.getValue() == 1L)
                source.add(entry.getKey());
        }
        return source;
    }

}

