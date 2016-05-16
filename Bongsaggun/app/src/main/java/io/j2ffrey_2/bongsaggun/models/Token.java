package io.j2ffrey_2.bongsaggun.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dong on 2015-11-27.
 */
public class Token {

    int status;

    @SerializedName("msg")
    String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Token(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
