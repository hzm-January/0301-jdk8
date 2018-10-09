package houzm.game.spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Package: houzm.game.spring.annotation
 * Author: houzm
 * Date: Created in 2018/8/13 18:05
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 模拟Spring @RequestMapping注解
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HRequestParam {

    String name() default "";
    String value() default "";

}
