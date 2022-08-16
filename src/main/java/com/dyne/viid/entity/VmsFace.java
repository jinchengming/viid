package com.dyne.viid.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("vms_face")
@ApiModel(value = "VmsFace对象", description = "")
public class VmsFace implements Serializable {

    private static final long serialVersionUID = 6938723358902054625L;

    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    private Long ID;

    @ApiModelProperty(value = "人脸标识")
    private String FaceID;

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

    @ApiModelProperty(value = "人脸出现时间")
    private LocalDateTime FaceAppearTime;

    @ApiModelProperty(value = "人脸消失时间")
    private LocalDateTime FaceDisAppearTime;

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

    @ApiModelProperty(value = "职业类别代码 ")
    private String JobCategory;

    @ApiModelProperty(value = "同行人脸数")
    private Integer AccompanyNumber;

    @ApiModelProperty(value = "肤色")
    private String SkinColor;

    @ApiModelProperty(value = "发型")
    private String HairStyle;

    @ApiModelProperty(value = "发色")
    private String HairColor;

    @ApiModelProperty(value = "脸型")
    private String FaceStyle;

    @ApiModelProperty(value = "脸部特征")
    private String FacialFeature;

    @ApiModelProperty(value = "体貌特征")
    private String PhysicalFeature;

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

    @ApiModelProperty(value = "姿态分布")
    private String Attitude;

    @ApiModelProperty(value = "相似度")
    private BigDecimal Similaritydegree;

    @ApiModelProperty(value = "眉型")
    private String EyebrowStyle;

    @ApiModelProperty(value = "鼻型")
    private String NoseStyle;

    @ApiModelProperty(value = "胡型")
    private String MustacheStyle;

    @ApiModelProperty(value = "嘴型")
    private String LipStyle;

    @ApiModelProperty(value = "皱纹眼袋")
    private String WrinklePouch;

    @ApiModelProperty(value = "痤疮色斑")
    private String AcneStain;

    @ApiModelProperty(value = "黑痣胎记")
    private String FreckleBirthmark;

    @ApiModelProperty(value = "疤痕酒窝")
    private String ScarDimple;

    @ApiModelProperty(value = "其他特征")
    private String OtherFeature;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date CreateTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date ModifyTime;


}
