package qq.life.community.community.myEception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"该问题不存在"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中要回复的问题或评论"),
    NO_LOGIN(2003,"未登录"),
    TYPE_PARAM_WRONG(2004,"评论类型错误"),
    COMMENT_NOT_FOUND(2005,"该评论不存在");
    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
