package qq.life.community.community.myEception;

public class CustomizeException extends RuntimeException {
    private String message;
    public CustomizeException (String msg){
        this.message=msg;
    }

    public String getMessage() {
        return message;
    }
}
