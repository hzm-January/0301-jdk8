package houzm.game.map;

import java.lang.annotation.Documented;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Package: houzm.game.map
 * Author: houzm
 * Date: Created in 2018/8/20 13:58
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public abstract class AbstractDocument implements Document {

    private Logger LOGGER = LoggerFactory.getLogger(AbstractDocument.class);
    private Map<String, Object> properties;
    private ObjectMapper jsonUtil = new ObjectMapper();

    protected AbstractDocument(Map<String, Object> properties) {
        Objects.requireNonNull(properties, "properties map is required");
        this.properties = properties;
    }

    @Override
    public Void put(String key, Object object) {
        properties.put(key, object);
        return null;
    }

    @Override
    public Object get(String key) {
        return properties.get(key);
    }

    @Override
    public <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor) {
        Object children = get(key); //子节点List<Map<String, Object>>
        try {
            LOGGER.info("children: {},{}", jsonUtil.writeValueAsString(children));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Stream.of(children).filter(e1 -> e1 != null).forEach(e1 -> {
            try {
                LOGGER.info("child-e1 : {}", jsonUtil.writeValueAsString(e1));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        Optional<List<Map<String, Object>>> any = Stream.of(children).filter(e1 -> e1 != null).map(e1 -> (List<Map<String, Object>>) e1).findAny();
        try {
            LOGGER.info("any.get(): {}", jsonUtil.writeValueAsString(any.get()));
            LOGGER.info("any.get().stream().map(constructor): {} ", jsonUtil.writeValueAsString(any.get().stream().map(constructor).collect(Collectors.toList())));

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return any.isPresent() ? any.get().stream().map(constructor) : Stream.empty();
    }
}
