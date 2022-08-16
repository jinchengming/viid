package com.dyne.viid.entity;

import com.baomidou.mybatisplus.annotation.*;
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
 * @since 2022-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("vms_person")
@ApiModel(value = "VmsPerson对象", description = "")
public class VmsPerson implements Serializable {


    private static final long serialVersionUID = -5319220911104670205L;

    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    private Long ID;

    private String PersonID;

    @ApiModelProperty(value = "信息分类 ")
    private Integer InfoKind;

    @ApiModelProperty(value = "来源标识 ")
    private String SourceID;

    @ApiModelProperty(value = "设备编码")
    private String DeviceID;

    @ApiModelProperty(value = "拍摄时间")
    private LocalDateTime ShotTime;

    @ApiModelProperty(value = "左上角x坐标")
    private Integer LeftTopX;

    @ApiModelProperty(value = "左上角y坐标")
    private Integer LeftTopY;

    @ApiModelProperty(value = "右上角x坐标")
    private Integer RightBtmX;

    @ApiModelProperty(value = "右上角y坐标")
    private Integer RightBtmY;

    @ApiModelProperty(value = "位置标记时间")
    private LocalDateTime LocationMarkTime;

    @ApiModelProperty(value = "人员出现时间")
    private LocalDateTime PersonAppearTime;

    @ApiModelProperty(value = "人员消失时间")
    private LocalDateTime PersonDisAppearTime;

    @ApiModelProperty(value = "证件种类")
    private String IDType;

    @ApiModelProperty(value = "证件号码")
    private String IDNumber;

    @ApiModelProperty(value = "姓名")
    private String Name;

    @ApiModelProperty(value = "曾用名")
    private String UsedName;

    @ApiModelProperty(value = "绰号")
    private String Alias;

    @ApiModelProperty(value = "性别代码")
    private String GenderCode;

    @ApiModelProperty(value = "年龄上限")
    private Integer AgeUpLimit;

    @ApiModelProperty(value = "年龄下限")
    private Integer AgeLowerLimit;

    @ApiModelProperty(value = "民族代码")
    private String EthicCode;

    @ApiModelProperty(value = "国籍代码")
    private String NationalityCode;

    @ApiModelProperty(value = "籍贯省市县代码 ")
    private String NativeCityCode;

    @ApiModelProperty(value = "居住地省市区划")
    private String ResidenceAdminDivision;

    @ApiModelProperty(value = "汉语口音代码")
    private String ChineseAccentCode;

    @ApiModelProperty(value = "单位名称")
    private String PersonOrg;

    @ApiModelProperty(value = "职业类别代码 ")
    private String JobCategory;

    @ApiModelProperty(value = "同行人数")
    private Integer AccompanyNumber;

    @ApiModelProperty(value = "身高上限")
    private Integer HeightUpLimit;

    @ApiModelProperty(value = "身高下限")
    private Integer HeightLowerLimit;

    @ApiModelProperty(value = "体型")
    private String BodyType;

    @ApiModelProperty(value = "肤色")
    private String SkinColor;

    @ApiModelProperty(value = "发型")
    private String HairStyle;

    @ApiModelProperty(value = "发色")
    private String HairColor;

    @ApiModelProperty(value = "姿态")
    private String Gesture;

    @ApiModelProperty(value = "状态")
    private String Status;

    @ApiModelProperty(value = "脸型")
    private String FaceStyle;

    @ApiModelProperty(value = "脸部特征")
    private String FacialFeature;

    @ApiModelProperty(value = "体貌特征")
    private String PhysicalFeature;

    @ApiModelProperty(value = "体表特征")
    private String BodyFeature;

    @ApiModelProperty(value = "习惯动作")
    private String HabitualMovement;

    @ApiModelProperty(value = "行为")
    private String Behavior;

    @ApiModelProperty(value = "行为描述")
    private String BehaviorDescription;

    @ApiModelProperty(value = "附属物")
    private String Appendant;

    @ApiModelProperty(value = "附属物描述")
    private String AppendantDescription;

    @ApiModelProperty(value = "伞颜色")
    private String UmbrellaColor;

    @ApiModelProperty(value = "口罩颜色")
    private String RespiratorColor;

    @ApiModelProperty(value = "帽子款式")
    private String CapStyle;

    @ApiModelProperty(value = "帽子颜色")
    private String CapColor;

    @ApiModelProperty(value = "眼镜款式")
    private String GlassStyle;

    @ApiModelProperty(value = "眼镜颜色")
    private String GlassColor;

    @ApiModelProperty(value = "围巾颜色")
    private String ScarfColor;

    @ApiModelProperty(value = "包款式")
    private String BagStyle;

    @ApiModelProperty(value = "包颜色")
    private String BagColor;

    @ApiModelProperty(value = "上衣款式")
    private String CoatStyle;

    @ApiModelProperty(value = "上衣长度")
    private String CoatLength;

    @ApiModelProperty(value = "上衣颜色")
    private String CoatColor;

    @ApiModelProperty(value = "裤子款式")
    private String TrousersStyle;

    @ApiModelProperty(value = "裤子颜色")
    private String TrousersColor;

    @ApiModelProperty(value = "裤子长度")
    private String TrousersLen;

    @ApiModelProperty(value = "鞋子款式")
    private String ShoesStyle;

    @ApiModelProperty(value = "鞋子颜色")
    private String ShoesColor;

    @ApiModelProperty(value = "是否驾驶员")
    private Integer IsDriver;

    @ApiModelProperty(value = "是否涉外人员")
    private Integer IsForeigner;

    @ApiModelProperty(value = "护照证件种类")
    private String PassportType;

    @ApiModelProperty(value = "出入境人员类别代码")
    private String ImmigrantTypeCode;

    @ApiModelProperty(value = "是否涉恐人员")
    private Integer IsSuspectedTerrorist;

    @ApiModelProperty(value = "涉恐人员编号")
    private String SuspectedTerroristNumber;

    @ApiModelProperty(value = "是否涉案人员")
    private Integer IsCriminalInvolved;

    @ApiModelProperty(value = "涉案人员专长代码")
    private String CriminalInvolvedSpecilisationCode;

    @ApiModelProperty(value = "体表特殊标记")
    private String BodySpeciallMark;

    @ApiModelProperty(value = "作案手段")
    private String CrimeMethod;

    @ApiModelProperty(value = "作案特点代码")
    private String CrimeCharacterCode;

    @ApiModelProperty(value = "在逃人员编号")
    private String EscapedCriminalNumber;

    @ApiModelProperty(value = "是否在押人员")
    private Integer IsDetainees;

    @ApiModelProperty(value = "看守所编号")
    private String DetentionHouseCode;

    @ApiModelProperty(value = "在押人员身份")
    private String DetaineesIdentity;

    @ApiModelProperty(value = "在押人员特殊身份")
    private String DetaineesSpecialIdentity;

    @ApiModelProperty(value = "成员类型代码")
    private String MemberTypeCode;

    @ApiModelProperty(value = "是否被害人")
    private Integer IsVictim;

    @ApiModelProperty(value = "被害人种类")
    private String VictimType;

    @ApiModelProperty(value = "受伤害程度")
    private String InjuredDegree;

    @ApiModelProperty(value = "尸体状况代码")
    private String CorpseConditionCode;

    @ApiModelProperty(value = "是否可疑人")
    private Integer IsSuspiciousPerson;

    @TableField(fill = FieldFill.INSERT)
    private Date CreateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date ModifyTime;


}
