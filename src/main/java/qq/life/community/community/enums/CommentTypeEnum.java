package qq.life.community.community.enums;

/**
 * 枚举类，列举出评论类型
 */
public enum CommentTypeEnum {
    QUESTION (1),COMMENT(2);
    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type=type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if(commentTypeEnum.getType()==type){
                return true;
            }
        }
        return false;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
