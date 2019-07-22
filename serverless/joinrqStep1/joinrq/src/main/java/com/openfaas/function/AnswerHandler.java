package com.openfaas.function;

import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import okhttp3.*;


public class AnswerHandler implements com.openfaas.model.IHandler {

    public Response Handle(IRequest req) {

        String compid= req.getQuery().get("compid");
        String answer= req.getQuery().get("answer");
        String joinid= req.getQuery().get("joinid");
        Response res = new Response();
        String id = Utils.userUtils.getId(req.getHeader("Authorization").split(" ")[1])  ;


        try {

            OkHttpClient client = new OkHttpClient.Builder()
                    .build();

            RequestBody formBody = new FormBody.Builder()
                    .add("joinid", joinid)
                    .build();


            Request request = new Request.Builder()
                    .url("http://device-notification-microservice-service.default.svc.cluster.local:8085/joinrq/delete")
                    .header("Authorization",req.getHeader("Authorization"))
                    .delete(formBody)
                    .build();

            String rs = client.newCall(request).execute().body().string();

        if (answer.equals("Accept")) {
            HttpUrl.Builder urlBuilder = HttpUrl.parse("http://ewallet-management-profil.default.svc.cluster.local:8000/employee/employee" )
                    .newBuilder();
            urlBuilder.addQueryParameter("param","idCompany");
            urlBuilder.addQueryParameter("value",compid);

             request = new Request.Builder()
                    .url(urlBuilder.build().toString())
                    .header("Authorization",req.getHeader("Authorization"))
                    .build();

             rs = client.newCall(request).execute().body().string();



        }

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
