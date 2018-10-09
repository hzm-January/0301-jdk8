package houzm.game.map;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Package: houzm.game.map
 * Author: houzm
 * Date: Created in 2018/8/20 13:56
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public interface Document {
    Void put(String key, Object object);
    Object get(String key);
    <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}
