package com.lingxiao.web.achat.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_MESSAGE")
public class MessageDb {
    private static int TYPE_STR = 1;  //字符串
    private static int TYPE_PIC = 2;  //图片
    private static int TYPE_FILE = 3;  //文件
    private static int TYPE_AUDIO = 4;  //语音
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

    //
    @Column(nullable = false,columnDefinition = "TEXT")
    private String content;

    @Column
    private String attach;

    @Column(nullable = false)
    private int type;

    //定义为创建时间戳，在创建时就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creatAt = LocalDateTime.now();


    //定义为更新时间戳，在创建时就写入
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "sendId")
    private UserDb sender;
    @Column(nullable = false,updatable = false,insertable = false)
    private String sendId;

    @ManyToOne
    @JoinColumn(name = "receiverId")
    private UserDb receiver;
    @Column(updatable = false,insertable = false)
    private String receiverId;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private GroupDb group;
    @Column(updatable = false,insertable = false)
    private String groupId;

    public static int getTypeStr() {
        return TYPE_STR;
    }

    public static void setTypeStr(int typeStr) {
        TYPE_STR = typeStr;
    }

    public static int getTypePic() {
        return TYPE_PIC;
    }

    public static void setTypePic(int typePic) {
        TYPE_PIC = typePic;
    }

    public static int getTypeFile() {
        return TYPE_FILE;
    }

    public static void setTypeFile(int typeFile) {
        TYPE_FILE = typeFile;
    }

    public static int getTypeAudio() {
        return TYPE_AUDIO;
    }

    public static void setTypeAudio(int typeAudio) {
        TYPE_AUDIO = typeAudio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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


}
