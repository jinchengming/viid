package com.dyne.viid.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述: 告警消息内容
 *
 * @author cm_fighting
 * @create 2022-07-06 下午4:31
 */
@Data
public class AlarmMsg implements Serializable {

    private static final long serialVersionUID = 4139813512095281879L;

    private String uid;

    private Long alarmTime;

    private String alarmType;

    /**
     * 消息类型
     */
    private Integer msgType;

    /**
     * 报警状态
     */
    private Integer alarmStatus;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 报警id : 设备端生成UUID
     */
    private String id;

    /**
     * 报警图片地址
     */
    private String imageUrl;

    /**
     * 报警位置
     */
    private String location;

    /**
     * 关联id
     */
    private String relationId;

    /**
     * 报警缩略图图片地址
     */
    private String smallImageUrl;

    /**
     * 消息创建时间
     */
    private Long createTime;

}
