package org.lvtinger.paladin.value;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Result<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 4610727154690449265L;

    private int code;
    private T content;
    private String message;

    public static <T extends Serializable> Result<T> success() {
        return new Result<T>().touchCode(SUCCESS);
    }

    public static <T extends Serializable>Result<T> success(T content){
        return new Result<T>().touchCode(SUCCESS).touchContent(content);
    }

    public static <T extends Serializable> Result<T> warning() {
        return new Result<T>().touchCode(WARRING);
    }

    public static <T extends Serializable> Result<T> auth(){
        return new Result<T>().touchCode(AUTH);
    }

    public static <T extends Serializable> Result<T> feature() {
        return new Result<T>().touchCode(FEATURE);
    }

    public Result<T> touchCode(int code) {
        this.code = code;
        return this;
    }

    public Result<T> touchMessage(String message) {
        this.message = message;
        return this;
    }

    public Result<T> touchContent(T content) {
        this.content = content;
        return this;
    }

    public boolean error(){
        return this.code != SUCCESS;
    }

    public static final int SUCCESS = 2000;
    public static final int FEATURE = 5000;
    public static final int WARRING = 4000;
    public static final int AUTH = 9000;
}
