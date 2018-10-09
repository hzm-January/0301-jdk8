package houzm.game.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Package: houzm.game.reflection
 * Author: houzm
 * Date: Created in 2018/8/14 17:38
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class ReflectionOfGame {
    public static void main(String[] args) throws Exception {

        Class<GameDO> gameDOClass = GameDO.class;
        GameDO gameDO = gameDOClass.newInstance();
        Field[] fields = gameDOClass.getFields();
        /**
         *  Field[]	getFields()
         *      返回一个包含某些 Field 对象的数组，这些对象反映此 Class 对象所表示的类或接口
         *      (包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口)的所有可访问公共字段。
         */
        System.out.println("Class  getFields() :  "+Arrays.toString(fields));
        /**
         * Field[]	getDeclaredFields()
         *      返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口
         *      (不包含从超类和超接口继承)所声明的所有字段。
         */
        Field[] declaredFields = gameDOClass.getDeclaredFields();
        System.out.println("Class  getDeclaredFields() :  "+Arrays.toString(declaredFields));

        /**
         * Method[]	getMethods()
         *        返回一个包含某些 Method 对象的数组，这些对象反映此 Class 对象所表示的类或接口
         *      （包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法。
         */
        Method[] getMethods = gameDOClass.getMethods();
        System.out.println("Class  getMethods() ： "+ Arrays.toString(getMethods));

        /**
         * Method[]	getDeclaredMethods()
         *          返回 Method 对象的一个数组，这些对象反映此 Class 对象表示的类或接口声明的所有方法，
         *          包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
         */
        Method[] declaredMethods = gameDOClass.getDeclaredMethods();
        System.out.println("Class  getDeclaredMethods() ： "+ Arrays.toString(declaredMethods));


        Method enclosingMethod = gameDOClass.getEnclosingMethod();
        System.out.println("Class  getEnclosingMethod() ： "+ new ObjectMapper().writeValueAsString(enclosingMethod));





        Method showPublic = gameDOClass.getMethod("show", String.class, Double.class);
        System.out.println(showPublic);
//        showPublic.invoke(gameDO, new Object[]{12.3D, "魂斗罗"}); //java.lang.IllegalArgumentException: argument type mismatch
        showPublic.invoke(gameDO, new Object[]{"魂斗罗", 12.3D});

        Method showPublic2 = gameDOClass.getMethod("show", String.class, Double.class, String.class);
        Class<?>[] parameterTypes = showPublic2.getParameterTypes();
        System.out.println("Method  getParameterTypes() ： "+ Arrays.toString(parameterTypes));


    }
}
