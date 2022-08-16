package com.dyne.viid.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("vms_image")
@ApiModel(value = "VmsFaceImage对象", description = "")
public class VmsImage implements Serializable {

    private static final long serialVersionUID = 2675667400410859661L;

    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    private Long ID;

    // 上报来源 1人形 2 人脸 3 机动车 4 非机动车
    private Integer FromType;

    @ApiModelProperty(value = "图像标识")
    private String ImageID;

    @ApiModelProperty(value = "事件分类")
    private Integer EventSort;

    @ApiModelProperty(value = "设备编码")
    private String DeviceID;

    @ApiModelProperty(value = "存储路径")
    private String StoragePath;

    @ApiModelProperty(value = "信息分类 ")
    private Integer InfoKind;

    @ApiModelProperty(value = "图片类型")
    private String Type;

    @ApiModelProperty(value = "文件格式")
    private String FileFormat;

    @ApiModelProperty(value = "拍摄时间")
    private LocalDateTime ShotTime;

    @ApiModelProperty("Title")
    @JsonProperty("Title")
    private String Title;

    @ApiModelProperty("密级代码")
    @JsonProperty("SecurityLevel")
    private String SecurityLevel;

    @ApiModelProperty("拍摄地点区划内详细地址")
    @JsonProperty("ShotPlaceFullAdress")
    private String ShotPlaceFullAdress;

    @ApiModelProperty("内容描述")
    @JsonProperty("ContentDescription")
    private String ContentDescription;

    private Integer Width;

    private Integer Height;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date CreateTime;

}
