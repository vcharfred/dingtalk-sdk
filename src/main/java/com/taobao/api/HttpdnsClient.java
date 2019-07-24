package com.taobao.api;

import java.util.concurrent.atomic.AtomicBoolean;

import com.taobao.api.internal.cluster.ClusterManager;
import com.taobao.api.internal.cluster.DnsConfig;
import com.taobao.api.internal.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpdnsClient {

    private static final AtomicBoolean  init      = new AtomicBoolean(false);
    private static final Logger log = LoggerFactory.getLogger(ClusterManager.class);
    
    public static void init(String appKey, String appSecret){
        
        if(init.compareAndSet(false, true)){
            WebUtils.setIgnoreHostCheck(true);
            ClusterManager.initRefreshThread(appKey, appSecret);
        }
    }

    public static String getUrl(String url){
        
        if(!init.get()){
            log.error("Taobao HttpdnsClient is not initialized...");
            return url;
        }
        DnsConfig dnsConfig = ClusterManager.GetDnsConfigFromCache();
        if (dnsConfig == null) {
            return url;
        } else {
            return dnsConfig.getVipUrl(url);
        }
    }

}
