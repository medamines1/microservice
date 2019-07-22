package io.kubeless;





import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;


public class Requests {

    private String test() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()

                .url("https://www.vogella.com/index.html")

                .build();

        Response response = client.newCall(request).execute();

        String a =response.body().toString();


//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        UriComponentsBuilder builder;
//        ResponseEntity<ResponseModel> responseMS;
//
//        String answer = "Accept";
//        String sender = "f38bcd8d-2f1b-4032-954f-89798c5575a5";
//        String receiver = "";
//        String JoinId = "";
//        HttpEntity<ResponseModel> entity = new HttpEntity<>(headers);
//
//        //getReceiver
//        builder = UriComponentsBuilder.fromHttpUrl("http://127.0.0.1:8085/JoinRq/findByUserId")
//            .queryParam("id", receiver);
//        responseMS  = restTemplate.exchange( builder.toUriString(),HttpMethod.GET, entity, ResponseModel.class);


//        //getSender
//        builder = UriComponentsBuilder.fromHttpUrl("http://127.0.0.1:8085/JoinRq/findByUserId")
//                .queryParam("id", sender);
//        responseMS  = restTemplate.exchange( builder.toUriString(),HttpMethod.GET, entity, ResponseModel.class);
//
//
//
//        //update request
//        responseMS  = restTemplate.exchange(String.format( "http://127.0.0.1:8085/JoinRq/updByUserId/$S/status/$S",JoinId,answer),HttpMethod.PUT, entity, ResponseModel.class);
//
//        System.out.println(responseMS);





//        //update user status
//        String param = "id";
//        String value = "company-id";
//        builder = UriComponentsBuilder.fromHttpUrl("http://10.20.0.170:8000/employee/employee/"+sender)
//                .queryParam("param", param)
//                .queryParam("value", value);
//
//        System.out.println(builder.toUriString());
//
//
//
//        System.out.println(restTemplate.exchange(builder.toUriString() ,HttpMethod.PUT, entity, String.class));


//
//        //update balance
//        String wallet_id = "fe9f6c4a-d7cc-477c-a66b-eace73d2aa35";


     //   OkHttpClient client = new OkHttpClient();

//        Map<String, String> param = new HashMap<String, String>();
//
//        RequestBody formBody = new FormBody.Builder()
//                .add("id", "Your message")
//                .add("param", "Your message")
//                .add("value", "Your message")
//                .build();
//
//      param.put("id","10");

//        Request request = new Request.Builder()
//                .url("http://127.0.0.1:8083/wallet/updById/a695719a-fd85-4c62-9ef3-10717b762320/MinusAmount/-10")
//                .put(formBody)
//
//
//                .build();
//
//        Response response = client.newCall(request).execute();
//
//        assert response.body() != null;
//        System.out.println(response.body().string());


        return "it works ! ";
    }



     public String add(io.kubeless.Event event, io.kubeless.Context context) throws Exception {


            BasicConfigurator.configure();
            System.out.println(event + " // " + context);


            HttpResponse<JsonNode> jsonResponse = Unirest.post("http://httpbin.org/post")
                    .header("accept", "application/json")
                    .queryString("apiKey", "123")
                    .field("parameter", "value")
                    .field("foo", "bar").asJson();


            System.out.println("done");
            System.out.println(jsonResponse.getBody());

//        Map<String, String> param = new HashMap<String, String>();
//
//        RequestBody formBody = new FormBody.Builder()
//                .add("id", "Your message")
//                .add("param", "Your message")
//                .add("value", "Your message")
//                .build();
//
//      param.put("id","10");

//        Request request = new Request.Builder()
//                .url("http://127.0.0.1:8083/wallet/updById/a695719a-fd85-4c62-9ef3-10717b762320/MinusAmount/-10")
//                .put(formBody)
//
//
//                .build();
//
//        Response response = client.newCall(request).execute();
//
//        assert response.body() != null;
//        System.out.println(response.body().string());

            return "hello";
     }

    public static  void main (String []args) throws Exception {

        Requests r = new Requests();

       System.out.println(r.add(null,null));
    }

//
//    public class ResponseModel<T> {
//        private response_status status;
//        private T result;
//        private String err;
//        public ResponseModel(response_status status,T result){
//            this.status = status;
//            this.result = result;
//            this.err = "";
//        }
//
//
//        public ResponseModel(response_status status,T result,String err){
//            this.status = status;
//            this.result = result;
//            this.err = err;
//        }
//
//        @Override
//        public String toString(){
//            // assign result to your intended string
//            return this.result + " "+ this.status + " " + this.err  ;
//        }
//    }
//
//
//    public enum response_status {
//        success,
//        fail
//    }


}
