package houzm.accumulation.jdk8.validateCustom;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.sun.istack.internal.NotNull;

/**
 * Package: houzm.accumulation.jdk8.validate
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 18:00
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class BaseObj {

    public void validateForTheObj() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            String fieldName = field.getName();
            NotNull annotation = field.getAnnotation(NotNull.class);
            Annotation[] annotations = field.getAnnotations();
            boolean isAnnotationNotNull = field.isAnnotationPresent(NotNull.class);
            Object fieldValue = this.runGetter(field, this);
            if (annotation != null && fieldValue == null) {
                System.out.println(fieldName+" is null");
            }

        }
    }
    public Object runGetter(Field field, Object instance) {
        // MZ: Find the correct method
        for (Method method : instance.getClass().getDeclaredMethods()) {
            if ((method.getName().startsWith("get")) && (method.getName().length() == (field.getName().length() + 3))) {
                if (method.getName().toLowerCase().endsWith(field.getName().toLowerCase())) {
                    // MZ: Method found, run it
                    try {
                        return method.invoke(instance);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        System.out.println("Could not determine method: " + method.getName());
                    }
                }
            }
        }
        return null;
    }
}
