package com.wred.choa.chat;


public class ChatModel {

    private String messageText;
    private String messageSender;
    private String messageReciever;
    private String messageTime;
    boolean isSeen;

    public ChatModel() {
    }

    public ChatModel(String messageText, String messageSender, String messageReciever, String messageTime, boolean isSeen) {
        this.messageText = messageText;
        this.messageSender = messageSender;
        this.messageReciever = messageReciever;
        this.messageTime = messageTime;
        this.isSeen = isSeen;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(String messageSender) {
        this.messageSender = messageSender;
    }

    public String getMessageReciever() {
        return messageReciever;
    }

    public void setMessageReciever(String messageReciever) {
        this.messageReciever = messageReciever;
    }

    public String  getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String  messageTime) {
        this.messageTime = messageTime;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }
}

