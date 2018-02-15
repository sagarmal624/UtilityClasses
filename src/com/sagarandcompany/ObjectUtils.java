package com.sagarandcompany;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

public class ObjectUtils {
    public static <T extends Object, Y extends Object> void copy(T from, Y to) {
        Field[] fields = from.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Field fieldFrom = from.getClass().getDeclaredField(field.getName());
                Field toField = to.getClass().getDeclaredField(field.getName());
                if (fieldFrom.getType().equals(toField.getType())) {
                    fieldFrom.setAccessible(true);
                    toField.setAccessible(true);
                    Object value = fieldFrom.get(from);
                    toField.set(to, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T extends Object, Y extends String> Object getProperty(T source, Y property) {
        try {
            Field field = source.getClass().getDeclaredField(property);
            field.setAccessible(true);
            return field.get(source);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isNull(Object object) {
        return Objects.isNull(object);
    }

    public static void populate(Object bean, Map<String, ? extends Object> properties) {
        Class<? extends Object> aClass = bean.getClass();
        Field[] fields = aClass.getDeclaredFields();
        try {
            for (Map.Entry<String, ? extends Object> entry : properties.entrySet()) {
                Field field = aClass.getDeclaredField(entry.getKey());
                if (field.getType().equals(entry.getValue().getClass())) {
                    field.setAccessible(true);
                    field.set(bean, entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
