package apap.ta.sifactory.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse<T>{
    private int status;
    private String message;
    private T result;

    // Mengembalikan status
    public int getStatus() {
        return status;
    }

    // Mengembalikan message
    public String getMessage() {
        return message;
    }

    // Mengembalikan hasil
    public T getResult() {
        return result;
    }

    // Mengembalikan status untuk di-set
    public void setStatus(int status) {
        this.status = status;
    }

    // Mengembalikan message untuk di set
    public void setMessage(String message) {
        this.message = message;
    }

    // Mengembalikan hasil untuk di set
    public void setResult(T result) {
        this.result = result;
    }
}
