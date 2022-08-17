package com.dyne.viid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("vms_server")
@JsonRootName(value = "server")
public class VmsServer implements Serializable {

    private static final long serialVersionUID = -7313929918356268434L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String ip;

    private String port;

    private Integer type; // 上级 下级

    private String apsId; // 采集系统ID

    private Boolean online; // 平台在线状态

    private String username;

    private String password;

    private Boolean status; // 状态 级联状态

    private Date registerTime;

    private Date keepaliveTime;

    private Date createTime;
}
