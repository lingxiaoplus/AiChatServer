package com.lingxiao.web.achat.push.service;


import com.lingxiao.web.achat.push.bean.db.UserDb;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//实际访问的地址是：localhost/api/account
@Path("/account")
public class AccountService {

    @GET
    @Path("/login")
    public String get(){
        return "You are login";
    }


    //注解  来回都是json格式
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDb post(){
        UserDb user = new UserDb();
        user.setName("美女");
        user.setSex(2);
        return user;
    }

}
