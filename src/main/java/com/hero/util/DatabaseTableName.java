package com.hero.util;

import java.lang.annotation.*;

/**

 * @ClassName: DatabaseTableName
 * @Description: 读取表名
 * @author: chenwenwei
 * @date: 2018.05.05


 */

@Target(ElementType.TYPE)//用在那里
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DatabaseTableName {
    String value() default "";
}
