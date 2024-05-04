package com.spring.boot.jpastudy.jpa07;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Intro {
    @Column(table = "writer_intro", name = "content_type")
    private String contentType;
    @Column(table = "writer_intro")
    private String content;

    protected Intro() {
    }

    public Intro(String contentType, String content) {
        this.contentType = contentType;
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Intro{" +
                "contentType='" + contentType + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
