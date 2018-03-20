package com.lingxiao.web.achat.push.bean.db;

import com.lingxiao.web.achat.push.bean.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_FOLLOW")
public class UserFollowDb {
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

    //定义一个发起人，你关注某人，就是你
    //optional不可选，必须存储，也就是说必须要有一个“你”
    @ManyToOne(optional = false)
    //定义关联的表字段名为originId，对应的是user.id
    @JoinColumn(name = "originId")
    private User origin;
    @Column(nullable = false,updatable = false,insertable = false)
    private String originId;
    //被关注的人
    @ManyToOne(optional = false)
    @JoinColumn(name = "targetId")
    private User target;
    @Column(nullable = false,updatable = false,insertable = false)
    private String targetId;

    //备注 --别名
    @Column
    private User alias;

    //定义为创建时间戳，在创建时就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creatAt = LocalDateTime.now();


    //定义为更新时间戳，在创建时就写入
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();
}
