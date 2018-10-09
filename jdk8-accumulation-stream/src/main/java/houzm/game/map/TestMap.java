package houzm.game.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Package: houzm.game.map
 * Author: houzm
 * Date: Created in 2018/8/20 13:20
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, Object> mapOfStudentsDa1 = new HashMap<>();
        Student s1 = new Student();
        s1.setName("zhangsan");
        s1.setAge(12);
        mapOfStudentsDa1.put("da1", s1);
        mapOfStudentsDa1.put("jinian", "da1");
        Map<String, Object> mapOfStudentsDa2 = new HashMap<>();
        Student s2 = new Student();
        s2.setName("zhangsan");
        s2.setAge(12);
        mapOfStudentsDa2.put("da1", s2);
        mapOfStudentsDa2.put("jinian", "da1");
        List<Map<String, Object>> mapOfStudents = Arrays.asList(
                mapOfStudentsDa1,
                mapOfStudentsDa2
        );
//        mapOfStudents.stream().map(Student::new).collect(Collectors.toList());
    }
}
