package com.lingxiao.web.achat.push.service;


import com.google.gson.annotations.Expose;
import com.lingxiao.web.achat.push.bean.api.account.RegisterModel;
import com.lingxiao.web.achat.push.bean.db.UserDb;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//实际访问的地址是：localhost/api/account
@Path("/account")
public class AccountService {

    //注解  来回都是json格式
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RegisterModel register(RegisterModel model){
        /*UserDb user = new UserDb();
        user.setName(model.getName());
        user.setSex(2);*/
        return model;
    }

}
