//package com.mycloudbackup.model;
//
//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Table;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="DATABASE")
//public class Database {
//    @Id
//    @GeneratedValue
//    @Column(name="database_id")
//    public Long getId() { return id; }
//    private Long id;
//
//    @Column(name="name")
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//    private String name;
//
//    @Column(name="path")
//    public String getPath() { return path; }
//    public void setPath(String path) { this.path = path; }
//    private String path;
//
//    @ManyToOne
//    @JoinColumn(name="user_id")
//    public User getUser() { return user; }
//    public void setUser(User user) { this.user = user; }
//    private User user;
//
//    public Database(String name, String path, User user) {
//        this.name = name;
//        this.path = path;
//        this.user = user;
//    }
//}
