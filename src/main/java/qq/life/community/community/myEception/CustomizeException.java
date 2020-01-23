package qq.life.community.community.myEception;

public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;

    public CustomizeException (String msg){
        this.message=msg;
    }
    public CustomizeException(ICustomizeErrorCode customizeErrorCode) {
        this.message = customizeErrorCode.getMessage();
        this.code = customizeErrorCode.getCode();
    }
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
