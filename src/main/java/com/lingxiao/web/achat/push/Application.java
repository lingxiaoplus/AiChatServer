package com.lingxiao.web.achat.push;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.lingxiao.web.achat.push.service.AccountService;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.logging.Logger;

public class Application extends ResourceConfig{

    public Application(){
        //注册逻辑处理的包名
        packages(AccountService.class.getPackage().getName());

        //注册json解析器
        register(JacksonJsonProvider.class);
        //注册日志打印
        register(Logger.class);
    }
}
