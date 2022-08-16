package com.dyne.viid.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author cm_fighting
 * @since 2022-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("vms_notification_log")
@ApiModel(value="VmsNotificationLog对象", description="")
public class VmsNotificationLog implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "ID", type = IdType.AUTO)
    private Long ID;

    private String DeviceID;

    private String ObjectID;

    private String SubscribeID;

    private String NotificationID;

    private String Result;

    private String ForwardTime;

      @TableField(fill = FieldFill.INSERT)
    private Date CreateTime;


}
