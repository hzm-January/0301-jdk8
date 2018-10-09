package houzm.game.hello.json;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Package: houzm.game.hello.json
 * Author: houzm
 * Date: Created in 2018/7/7 18:38
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class TestJsonDemo {
    public static void main(String[] args) {
//        testPut();
        String jsonStr = "{\"name\":\"houzm\",\"age\":\"12\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonStr);
            JsonNode sss = jsonNode.findValue("sss");
            if (sss == null) {
                System.out.println("====");
                ((ObjectNode)jsonNode).put("sss", "add");
                ((ObjectNode)jsonNode).put("sss", "abb"); //会覆盖
                System.out.println(jsonNode.toString());
//                JsonNodeFactory jsonNodeFactory = JsonNodeFactory.instance;
//                ObjectNode jsonNodes = jsonNodeFactory.objectNode();
            }
            //获取节点，如果没有添加节点
            JsonNode ddd = jsonNode.findValue("sss");
            System.out.println(sss);
            System.out.println(ddd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testPut() {
        String jsonStr = "{\"name\":\"houzm\",\"age\":\"12\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonStr);
            JsonNode name = jsonNode.findValue("name");
            JsonNode age = jsonNode.findValue("age");
            JsonNode sss = jsonNode.findValue("sss");
            if (sss == null) {
                System.out.println("====");
                ((ObjectNode)jsonNode).put("sss", "add");
                System.out.println(jsonNode.toString());
//                JsonNodeFactory jsonNodeFactory = JsonNodeFactory.instance;
//                ObjectNode jsonNodes = jsonNodeFactory.objectNode();
            }
            //获取节点，如果没有添加节点
            JsonNode ddd = jsonNode.findValue("sss");
            System.out.println(name);
            System.out.println(age);
            System.out.println(sss);
            System.out.println(ddd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
