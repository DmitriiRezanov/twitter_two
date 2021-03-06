package com.example.servingwebcontent.domain;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;

    //Одному пользователю соответствует много сообщений
    @ManyToOne (fetch = FetchType.EAGER)//Каждый раз когда мы получаем сообщение, мы получаем информацию об авторе
    @JoinColumn (name = "user_id") //в БД поле будет называться user_id, а не author_id
    private User author;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "community_id")
    private Community community;

    private String filename;

    public Message(){}

    public Message(String text, String tag, User user) {
        this.text = text;
        this.tag = tag;
        this.author = user;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>"; //Условие на проверку наличия автора сообщения, если нет, то <none>
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
}