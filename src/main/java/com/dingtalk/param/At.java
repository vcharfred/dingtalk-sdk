package com.dingtalk.param;

import java.util.List;

/**
 * <p> @的人 </p>
 *
 * @author vchar fred
 * @version 1.0
 * @create_date 2019/7/25 10:17
 */
public class At {

    private boolean isAtAll = false;
    private List<String> atMobiles;

    public boolean isAtAll() {
        return isAtAll;
    }

    public void setAtAll(boolean atAll) {
        isAtAll = atAll;
    }

    public List<String> getAtMobiles() {
        return atMobiles;
    }

    public void setAtMobiles(List<String> atMobiles) {
        this.atMobiles = atMobiles;
    }
}
