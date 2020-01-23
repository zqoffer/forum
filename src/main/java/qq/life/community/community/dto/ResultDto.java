package qq.life.community.community.dto;

import qq.life.community.community.myEception.CustomizeErrorCode;


/**
 * 前后端分离开发，json数据交互，为了方便封装一个返回类型
 */
public class ResultDto {
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public static ResultDto errorOf(CustomizeErrorCode customizeErrorCode){
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(customizeErrorCode.getCode());
        resultDto.setMessage(customizeErrorCode.getMessage());
        return resultDto;

    }

    public static ResultDto okOf(){
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(200);
        resultDto.setMessage("请求成功");
        return resultDto;

    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
