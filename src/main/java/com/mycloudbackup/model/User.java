//package com.mycloudbackup.model;
//
//        import org.hibernate.annotations.Entity;
//        import org.hibernate.annotations.Table;
//
//        import javax.persistence.*;
//        import java.util.Set;
//
///**
// * Created by albagnj on 28/05/15.
// */
//@Entity
//@Table(name="USER")
//public class User {
//    @Id
//    @GeneratedValue
//    @Column(name="user_id")
//    public Long getId() { return id; }
//    private Long id;
//
//    @Column(name="email")
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//    private String email;
//
//    @Column(name="password")
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
//    private String password;
//
//    @OneToMany(mappedBy="user")
//    public Set<Backup> getDatabases() { return databases;}
//    public void setDatabases(Set<Backup> databases) { this.databases = databases; }
//    private Set<Backup> databases;
//
//    public User(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//}
