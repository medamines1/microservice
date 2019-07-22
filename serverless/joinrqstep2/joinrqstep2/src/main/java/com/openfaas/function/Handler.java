package com.openfaas.function;


import ReqNResp.ResponseModel;
import ReqNResp.response_status;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import okhttp3.*;


public class Handler implements com.openfaas.model.IHandler {


    public Response Handle(IRequest req) {
        Response res = new Response();

        try {
            String compid= req.getQuery().get("compid");
            String answer= req.getQuery().get("answer");
            String joinid= req.getQuery().get("joinid");
            String id = Utils.userUtils.getId(req.getHeader("Authorization").split(" ")[1])  ;

            OkHttpClient client = new OkHttpClient.Builder()
                    .build();

            RequestBody formBody = new FormBody.Builder()
                    .add("id", joinid)
                    .build();


            Request request = new Request.Builder()
                    .url("http://device-notification-microservice-service.default.svc.cluster.local:8085/joinrq/delById")
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

                urlBuilder = HttpUrl.parse("http://ewallet-management-profil.default.svc.cluster.local:8000/employee/update" )
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
            e.printStackTrace();
            res.setBody(new ResponseModel(response_status.fail,"",e.getMessage()).toString());
        }
        return res;
    }

}
