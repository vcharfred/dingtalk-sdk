package com.dingtalk.param;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * <p> 文件消息 </p>
 *
 * @author vchar fred
 * @version 1.0
 * @create_date 2019/7/25 10:09
 */
public class TextMessage implements Serializable {

    private String content;
    private At at;

    public JSONObject toJson(){
        JSONObject textMessage = new JSONObject();
        textMessage.put("msgtype", "text");
        JSONObject contentJson = new JSONObject();
        contentJson.put("content", content);
        textMessage.put("text", contentJson);
        if(at.isAtAll()){
            at.setAtMobiles(null);
        }
        textMessage.put("at", at);
        return textMessage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public At getAt() {
        return at;
    }

    public void setAt(At at) {
        this.at = at;
    }
}
