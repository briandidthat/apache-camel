package com.templates.consumer.domain;

public class Message {
    private Long id;
    private String from;
    private String to;
    private String text;

    public Message() {}

    public Message(Long id, String from, String to, String text) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
