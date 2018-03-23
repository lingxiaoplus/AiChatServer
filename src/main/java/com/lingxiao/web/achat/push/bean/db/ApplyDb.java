package com.lingxiao.web.achat.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_APPLY")
public class ApplyDb {
    private static final int TYPE_ADD_USER = 1; // 添加好友
    private static final int TYPE_ADD_GROUP = 2; //添加群组
    //这是主键
    @Id
    @PrimaryKeyJoinColumn
    //不自动生成 由客户端生成id避免复杂的映射关系
    /*//主键生成的存储类型是uuid
    @GeneratedValue(generator = "uuid")
    //把uuid的生成器定义为uuid2，uuid2是常规的uuid tostring
    @GenericGenerator(name = "uuid",strategy = "uuid2")*/
    //不允许更改，不允许为空
    @Column(updatable = false,nullable = false)
    private String id;

    //申请信息的描述  eg：我想加你为好友
    @Column(nullable = false)
    private String description;

    //附件，如图片 可为空
    @Column(columnDefinition = "TEXT")
    private String attach;

    //申请类型
    @Column(nullable = false)
    private int type;

    //目标id，不进行强关联
    //type->user  user.id
    //type->group group.id
    @Column(nullable = false)
    private String targetId;



    //定义为创建时间戳，在创建时就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creatAt = LocalDateTime.now();


    //定义为更新时间戳，在创建时就写入
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    //申请人，可以为空  一个人有多个申请
    @ManyToOne
    @JoinColumn(name = "applicantId")
    private UserDb applicant;
    @Column(updatable = false,insertable = false)
    private String applicantId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
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

    public UserDb getApplicant() {
        return applicant;
    }

    public void setApplicant(UserDb applicant) {
        this.applicant = applicant;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }
}
