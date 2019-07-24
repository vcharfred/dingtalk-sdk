# 钉钉自定义机器人发送消息SDK-JAVA版
当需要将系统的一些预警等信息推送到钉钉群时，我们可以通过开启自定义机器人来通过API接口推送钉钉消息。 

* [钉钉开放平台-自定义机器人说明文档](https://open-doc.dingtalk.com/microapp/serverapi3/iydd5h)
* [钉钉SDK下载地址](https://open-doc.dingtalk.com/microapp/faquestions/vzbp02)

> 注意：使用手机添加机器人后，需要登录PC版钉钉获取相关的链接
> 不使用钉钉提供的SDK也可以，不过需要自己去实现请求（即自己组装相关参数发送POST请求）。

官方提供的的SDK包有其他依赖，本项目已将其他移除，同时需要添加日志实现的jar包，项目已将日志切换为slf4j-api，使用时请引入日志实现包如log4j、logback等日志框架

项目编译版本：```taobao-sdk-java-auto_1479188381469-20190719```


## 使用说明
当前自定义机器人支持文本 (text)、链接 (link)、markdown(markdown)、ActionCard、FeedCard消息类型；
<span style="color:red">每个机器人每分钟最多发送20条。</span>消息发送太频繁会严重影响群成员的使用体验，大量发消息的场景 (譬如系统监控报警) 可以将这些信息进行整合，通过markdown消息以摘要的形式发送到群里。

### 发送普通消息

    @Test
    public void textMessage() throws ApiException {
        //这个是通过钉钉获取的机器人的连接，需要PC版才可以
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=2324980345ufnklasjnfaiopuw3rnq9o32874yq29035ryhvq2");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("测试文本消息");
        request.setText(text);

        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setIsAtAll("true");//设置@所有的人
        request.setAt(at);
        OapiRobotSendResponse response = client.execute(request);
        System.out.println(response.getErrcode());
    }

### 发送link消息
    
    @Test
    public void linkMessage() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=2324980345ufnklasjnfaiopuw3rnq9o32874yq29035ryhvq2");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("link");
        OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
        link.setMessageUrl("https://www.dingtalk.com/");
        link.setPicUrl("");
        link.setTitle("时代的火车向前开");
        link.setText("这个即将发布的新版本，创始人陈航（花名“无招”）称它为“红树林”。\n" +
                "而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是“红树林");
        request.setLink(link);

        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(Arrays.asList("13672384534"));//设置@那些人，使用的是手机号
        request.setAt(at);
        OapiRobotSendResponse response = client.execute(request);
        System.out.println(response.getErrcode());
    }

### 发送markdown消息

    @Test
    public void markdownMessage() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=2324980345ufnklasjnfaiopuw3rnq9o32874yq29035ryhvq2");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle("杭州天气");
        markdown.setText("#### 杭州天气 @156xxxx8827\n" +
                "> 9度，西北风1级，空气良89，相对温度73%\n\n" +
                "> ![screenshot](https://gw.alipayobjects.com/zos/skylark-tools/public/files/84111bbeba74743d2771ed4f062d1f25.png)\n"  +
                "> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n");
        request.setMarkdown(markdown);
        OapiRobotSendResponse response = client.execute(request);
        System.out.println(response.getErrcode());
        System.out.println(response.getErrmsg());
    }


