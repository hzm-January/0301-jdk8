package houzm.game.hello.clone;

import houzm.game.hello.User;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;

/**
 * Package: houzm.game.hello.clone
 * Author: houzm
 * Date: Created in 2018/7/9 10:02
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class TestBeanUtilsOfApach {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("houzm", "12"),
                new User("sahuzm", "112"),
                new User("dddsouzm", "22"),
                new User("couzm", "52")
                ));
        try {
            System.out.println(users);
            ArrayList<User> users1 = new ArrayList<>();
            for (User user : users) {
                users1.add((User) BeanUtils.cloneBean(user));
            }
//            ArrayList<User> users1 = (ArrayList<User>) BeanUtils.cloneBean(users); //[]打印为空
            System.out.println(users1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
