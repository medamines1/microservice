package ReqNResp;



public class ResponseModel<T> {
    private response_status status;
    private T result;
    private String err;
    public ResponseModel(response_status status,T result){
        this.status = status;
        this.result = result;
        this.err = "";
    }

    public ResponseModel(response_status status,T result,String err){
        this.status = status;
        this.result = result;
        this.err = err;
    }
}

