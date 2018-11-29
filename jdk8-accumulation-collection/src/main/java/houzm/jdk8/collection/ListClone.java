package houzm.jdk8.collection;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: houzm.jdk8.collection
 * Author: houzm
 * Date: Created in 2018/10/18 10:39
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： List clone
 */
public class ListClone {
    private static Logger logger = LoggerFactory.getLogger(ListClone.class);
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        logger.debug("original : {}", integers);

        List<Integer> integersClone = new ArrayList<>(integers);
        integersClone.remove(0);
        logger.debug("after remove print original : {}", integers);
        logger.debug("after remove print the list by clone : {}", integersClone);
    }
}
