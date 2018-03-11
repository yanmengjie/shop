package com.edu.ldu.core.common.entity;

/**
 * 界面通知信息
 *
 * @author yanmengjie
 * 2018/3/6
 */
public class Message {
    /**
     * 操作结果
     */
    private Boolean success;
    /**
     * 标题
     */
    private String title;
    /**
     * 提示消息
     */
    private String msg;
    /**
     * 对象实体
     */
    private Object bean;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle() {
        this.title = "ERROR";
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    @Override
    public String toString() {
        return "Message [success=" + success + ", message=" + msg + "]";
    }

    public Message() {
        super();
        this.success = success;
        this.msg = msg;
    }

    public Message(Boolean success, String message, Object bean) {
        super();
        this.success = success;
        this.msg = message;
        this.bean = bean;
    }

    public Message(String title, String message) {
        super();
        this.title = "操作提示";
        this.msg = message;
    }

    public Message(Exception ex) {
        super();
        this.success = false;
        this.msg = ex.getMessage();
    }

    public static Message success() {
        Message message = new Message();
        message.setSuccess(true);
        message.setMsg("操作成功");
        return message;
    }

    public static Message success(String msg) {
        Message message = new Message();
        message.setSuccess(true);
        message.setMsg(msg);
        return message;
    }

    public static Message fail(String msg) {
        Message message = new Message();
        message.setSuccess(false);
        message.setMsg(msg);
        message.setTitle();
        return message;
    }

    public static Message fail() {
        return fail("操作失败");
    }


}