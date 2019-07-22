package com.openfaas.function;

import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


public class CreateHandler implements com.openfaas.model.IHandler {

    public Response Handle(IRequest req) {

        String userid= req.getQuery().get("userid");
        Response res = new Response();
        String id = Utils.userUtils.getId(req.getHeader("Authorization").split(" ")[1])  ;


        try {

            OkHttpClient client = new OkHttpClient.Builder()
                    .build();

            RequestBody formBody = new FormBody.Builder()
                    .add("userid", userid)
                    .build();


            Request request = new Request.Builder()
                    .url("http://device-notification-microservice-service.default.svc.cluster.local:8085/joinrq/insert")
                    .header("Authorization",req.getHeader("Authorization"))
                    .post(formBody)
                    .build();

            String rs = client.newCall(request).execute().body().string();

    //            Gson g = new Gson();
    //            ResponseModel p = g.fromJson(rs, ResponseModel.class);
    //            if (p.getStatus().compareTo(response_status.success) > 0)


            res.setBody(rs);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return res;
    }

}
