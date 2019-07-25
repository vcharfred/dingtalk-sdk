package com.dingtalk.util;

import com.dingtalk.param.DingTalkResponse;
import com.dingtalk.param.TextMessage;

/**
 * <p> 钉钉发送消息工具类 </p>
 *
 * @author vchar fred
 * @version 1.0
 * @create_date 2019/7/25 9:49
 */
public class DingTalkUtil {

    public static DingTalkResponse sendTextMessage(String url, TextMessage textMessage){
        String result = HttpClientUtil.sendPost(url, textMessage.toJson().toJSONString());
        System.out.println(result);
        return null;
    }


}
