package houzm.game.spring.controller;

import houzm.game.spring.annotation.HAutowired;
import houzm.game.spring.annotation.HController;
import houzm.game.spring.annotation.HRequestMapping;
import houzm.game.spring.annotation.HRequestParam;
import houzm.game.spring.annotation.HService;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Package: houzm.game.spring.controller
 * Author: houzm
 * Date: Created in 2018/8/13 20:20
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class HelloServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    private List<String> classes = new LinkedList<>();
    private Map<String, Object> keyInstance= new HashMap<String, Object>();
    private Map<String, Object> pathsOfMethods = new HashMap<String, Object>();
    private ObjectMapper jsonUtil = new ObjectMapper();

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 1.扫描路径
        scanPackage("houzm.game.spring");
        try {
            logger.info(jsonUtil.writeValueAsString(classes));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // 2.ioc初始化
        initInstance();
        try {
            logger.info(jsonUtil.writeValueAsString(keyInstance));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // 3.注入
        autowired();
        logger.info("autowired finished");
        // 4.handlerMapping
        urlMapping();
        logger.info("urlMapping");
//        try {
//            logger.info(jsonUtil.writeValueAsString(pathsOfMethods));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }

    private void urlMapping() {
        keyInstance.forEach((key, instance)->{
            try {
                System.out.println("key:"+key+", instance:"+jsonUtil.writeValueAsString(instance));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            Class<?> clazz = instance.getClass();
            if (clazz.isAnnotationPresent(HController.class)) {
                HRequestMapping requestMapping = clazz.getAnnotation(HRequestMapping.class);
                String pathOfClass = requestMapping.value();
                Method[] methodsOfClass = clazz.getMethods();
//                try {
//                    System.out.println("methods: "+jsonUtil.writeValueAsString(methodsOfClass));
//                } catch (JsonProcessingException e) {
//                    e.printStackTrace();
//                }
                for (Method method : methodsOfClass) {
                    if (method.isAnnotationPresent(HRequestMapping.class)) {
                        HRequestMapping requestMappingOfMethod = method.getAnnotation(HRequestMapping.class);
                        String pathOfMethod = requestMappingOfMethod.value();
                        pathsOfMethods.put(pathOfClass+pathOfMethod, method);
                    }
                }
            }
        });
    }

    private void autowired() {
        keyInstance.forEach((key,instance)->{
            Class<?> clazz = instance.getClass();
            if (clazz.isAnnotationPresent(HController.class)) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    HAutowired hAutowired = field.getAnnotation(HAutowired.class);
                    String valueOfAutowired = hAutowired.value();
                    field.setAccessible(true);
                    try {
                        field.set(instance, keyInstance.get(valueOfAutowired));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void initInstance() {
        classes.forEach(key->{
            String className = key.replace(".class", "");
            try {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(HController.class)) {
                    Object instance = clazz.newInstance();
                    HRequestMapping hRequestMapping = clazz.getAnnotation(HRequestMapping.class);
                    String keyOfPath = hRequestMapping.value();
                    keyInstance.put(keyOfPath, instance);
                } else if (clazz.isAnnotationPresent(HService.class)) {
                    Object instance = clazz.newInstance();
                    HService hService = clazz.getAnnotation(HService.class);
                    keyInstance.put(hService.value(), instance);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        });
    }

    private void scanPackage(String baskPackage) {
        URL resource = this.getClass().getClassLoader().getResource("/".concat(baskPackage.replaceAll("\\.", "/")));
        String resourcePath = resource.getFile();
        File fileOfResourcePath = new File(resourcePath);
        String[] filesStr = fileOfResourcePath.list();
        for (String path : filesStr) {
            File file = new File(resourcePath+"/"+path);
            if (file.isDirectory()) {
                scanPackage(baskPackage + "." + path);
            } else {
                classes.add(baskPackage+"."+file.getName());
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget");
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求路径
        System.out.println("handlerMapping：");
        String requestURI = req.getRequestURI();
        String requestUriPath = requestURI.replace(req.getContextPath(), "");
//        String requestURI = req.getServletPath();
        //2.从map中获取执行方法
        Method method = (Method) pathsOfMethods.get(requestUriPath); //获取到方法
        Object instance = keyInstance.get("/"+requestUriPath.split("/")[1]);
        //3.获取请求参数
        Object[] objects = hand(req, resp, method);

        try {
            method.invoke(instance, objects);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private Object[] hand(HttpServletRequest req, HttpServletResponse resp, Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes(); //获取所有参数类型
        Object [] objects = new Object[parameterTypes.length];
        int objIndex = 0;
        int index = 0;
        for (Class<?> parameterType : parameterTypes) {
            if (ServletRequest.class.isAssignableFrom(parameterType)) {
                objects[objIndex++] = req;
            } else if (ServletResponse.class.isAssignableFrom(parameterType)) {
                objects[objIndex++] = resp;
            } else {
                Annotation[] annotations = method.getParameterAnnotations()[index];
                for (Annotation annotation : annotations) {
                    if (HRequestParam.class.isAssignableFrom(annotation.getClass())) {
                        HRequestParam hRequestParam = (HRequestParam) annotation;
                        String value = hRequestParam.value();
                        objects[objIndex++] = req.getParameter(value);
                    }
                }
            }
            index++;
        }
        return objects;
    }
}
