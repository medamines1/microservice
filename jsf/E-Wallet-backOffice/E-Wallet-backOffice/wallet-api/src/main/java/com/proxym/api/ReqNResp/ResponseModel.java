package com.proxym.api.ReqNResp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseModel<T> {
    private response_status status;
    private T result;
    private String err;
    public ResponseModel(response_status status, T result){
        this.status = status;
        this.result = result;
        this.err = "";
    }

    public ResponseModel(response_status status, T result, String err){
        this.status = status;
        this.result = result;
        this.err = err;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public response_status getStatus() {
        return status;
    }

    public void setStatus(response_status status) {
        this.status = status;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}

