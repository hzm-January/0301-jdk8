package houzm.accumulation.jdk8.validateCustom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Package: houzm.accumulation.jdk8.validateCustom
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 18:23
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Documented
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface Ano {
    String value() default "";
}
