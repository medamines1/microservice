package com.proxymit.ewallet.ewalletmanagementcompanyapi.ReqNResp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseModel<T> {
    private response_status status;
    private T result;
    private String err;
    private String trace;

    public ResponseModel(response_status status,T result){
        this.status = status;
        this.result = result;
        this.err = "";
        this.trace = "";
    }

    public ResponseModel(response_status status,T result,String err){
        this.status = status;
        this.result = result;
        this.err = err;
    }

    public ResponseModel(response_status status,T result,String err,String trace){
        this.status = status;
        this.result = result;
        this.err = err;
        this.trace = trace;
    }
}

