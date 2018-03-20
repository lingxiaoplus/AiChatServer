package com.lingxiao.web.achat.push.bean.db;



import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_USER")
public class UserDb {
    //这是主键
    @Id
    @PrimaryKeyJoinColumn
    //主键生成的存储类型是uuid
    @GeneratedValue(generator = "uuid")
    //把uuid的生成器定义为uuid2，uuid2是常规的uuid tostring
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    //不允许更改，不允许为空
    @Column(updatable = false,nullable = false)
    private String id;

    //用户名必须唯一
    @Column(nullable = false,length = 128,unique = true)
    private String name;

    //电话号码必须唯一
    @Column(nullable = false,length = 62,unique = true)
    private String phone;

    //密码
    @Column(nullable = false)
    private String password;

    //头像
    @Column
    private String portrait;

    @Column
    private String description;

    @Column(nullable = false)
    private int sex = 0;

    //token必须唯一
    @Column(unique = true)
    private String token;

    @Column(unique = true)
    private String pushId;

    //定义为创建时间戳，在创建时就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creatAt = LocalDateTime.now();


    //定义为更新时间戳，在创建时就写入
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();


    //最后一次收到消息的时间戳
    @Column
    private LocalDateTime lastReceivedAt = LocalDateTime.now();

    @JoinColumn(name = "originId")
    //懒加载 默认加载user信息的时候不查询这个集合
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<UserFollowDb> following = new HashSet<>();


    @JoinColumn(name = "targetId")
    //懒加载 默认加载user信息的时候不查询这个集合
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<UserFollowDb> followers = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public LocalDateTime getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(LocalDateTime creatAt) {
        this.creatAt = creatAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getLastReceivedAt() {
        return lastReceivedAt;
    }

    public void setLastReceivedAt(LocalDateTime lastReceivedAt) {
        this.lastReceivedAt = lastReceivedAt;
    }

    public Set<UserFollowDb> getFollowing() {
        return following;
    }

    public void setFollowing(Set<UserFollowDb> following) {
        this.following = following;
    }

    public Set<UserFollowDb> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<UserFollowDb> followers) {
        this.followers = followers;
    }
}
