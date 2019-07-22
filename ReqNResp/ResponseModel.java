package ReqNResp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseModel<T> {
    private response_status status;
    private T result;
    private String err;
    public ResponseModel(response_status status,T result){
        this.status = status;
        this.result = result;
        this.err = "";
    }
}

