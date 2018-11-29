package houzm.accumulation.jdk8.validate;

import com.sun.istack.internal.NotNull;

/**
 * Package: houzm.accumulation.jdk8
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 17:57
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： NotNullDemoObj
 */
public class NotNullValidateObj extends BaseObj {

    @NotNull
    private String  id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
