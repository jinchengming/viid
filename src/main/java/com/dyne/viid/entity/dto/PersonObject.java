package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 人员对象
 */
@Data
@ApiModel("人员对象")
@JsonRootName("PersonObject")
public class PersonObject implements Serializable {
    private static final long serialVersionUID = 479429724690273677L;

    @ApiModelProperty("人员标识")
    @JsonProperty("PersonID")
    @NotBlank(message = "人员标识不能为空.")
    private String PersonID;

    @ApiModelProperty("信息分类")
    @JsonProperty("InfoKind")
    @NotNull(message = "信息分类必须填写.")
    private Integer InfoKind;

    @ApiModelProperty("来源标识")
    @JsonProperty("SourceID")
    @NotBlank(message = "来源标识必须填写.")
    private String SourceID;

    @ApiModelProperty("设备编码")
    @JsonProperty("DeviceID")
    private String DeviceID;

    @ApiModelProperty(value = "拍摄时间")
    @JsonProperty("ShotTime")
    private LocalDateTime ShotTime;

    @ApiModelProperty("左上角 X 坐标")
    @JsonProperty("LeftTopX")
    private Integer LeftTopX;

    @ApiModelProperty("左上角 Y 坐标")
    @JsonProperty("LeftTopY")
    private Integer LeftTopY;

    @ApiModelProperty("右下角 X 坐标")
    @JsonProperty("RightBtmX")
    private Integer RightBtmX;

    @ApiModelProperty("右下角 Y 坐标")
    @JsonProperty("RightBtmY")
    private Integer RightBtmY;

    @ApiModelProperty("位置标记时间")
    @JsonProperty("LocationMarkTime")
    private LocalDateTime LocationMarkTime;

    @ApiModelProperty("人员出现时间;人工采集时有效")
    @JsonProperty("PersonAppearTime")
    private LocalDateTime PersonAppearTime;

    @ApiModelProperty("人员消失时间")
    @JsonProperty("PersonDisAppearTime")
    private LocalDateTime PersonDisAppearTime;

    @ApiModelProperty("证件种类")
    @JsonProperty("IDType")
    private String IDType;

    @ApiModelProperty("证件号码;有效证件号码")
    @JsonProperty("IDNumber")
    private String IDNumber;

    @ApiModelProperty("姓名;人员的中文姓名全称")
    @JsonProperty("Name")
    private String Name;

    @ApiModelProperty("曾用名;曾经在户籍管理部门正式登记注册、人事档案中正式记载的姓氏名称")
    @JsonProperty("UsedName")
    private String UsedName;

    @ApiModelProperty("绰号;使用姓名及曾用名之外的名称")
    @JsonProperty("Alias")
    private String Alias;

    @ApiModelProperty("性别代码")
    @JsonProperty("GenderCode")
    private String GenderCode;

    @ApiModelProperty("年龄上限;最大可能年龄")
    @JsonProperty("AgeUpLimit")
    private Integer AgeUpLimit;

    @ApiModelProperty("年龄下限;最小可能年龄")
    @JsonProperty("AgeLowerLimit")
    private Integer AgeLowerLimit;

    @ApiModelProperty("民族代码;中国各名族的罗马字母拼写法和代码")
    @JsonProperty("EthicCode")
    private String EthicCode;

    @ApiModelProperty("国籍代码;世界各国和地区名称代码")
    @JsonProperty("NationalityCode")
    private String NationalityCode;

    @ApiModelProperty("籍贯省市县代码")
    @JsonProperty("NativeCityCode")
    private String NativeCityCode;

    @ApiModelProperty("居住地行政区划")
    @JsonProperty("ResidenceAdminDivision")
    private String ResidenceAdminDivision;

    @ApiModelProperty("汉语口音代码;汉语口音编码规则")
    @JsonProperty("ChineseAccentCode")
    private String ChineseAccentCode;

    @ApiModelProperty("单位名称;人员所在的工作单位")
    @JsonProperty("PersonOrg")
    private String PersonOrg;

    @ApiModelProperty("职业类别代码;职业分类与代码，不包含代码中“—”")
    @JsonProperty("JobCategory")
    private String JobCategory;

    @ApiModelProperty("同行人数;被标注人的同行人数")
    @JsonProperty("AccompanyNumber")
    private Integer AccompanyNumber;

    @ApiModelProperty("身高上限;人的身高最大可能值，单位为厘米（cm）")
    @JsonProperty("HeightUpLimit")
    private Integer HeightUpLimit;

    @ApiModelProperty("身高下限;人的身高最小可能值，单位为厘米（cm）")
    @JsonProperty("HeightLowerLimit")
    private Integer HeightLowerLimit;

    @ApiModelProperty("体型")
    @JsonProperty("BodyType")
    private String BodyType;

    @ApiModelProperty("肤色")
    @JsonProperty("SkinColor")
    private String SkinColor;

    @ApiModelProperty("发型")
    @JsonProperty("HairStyle")
    private String HairStyle;

    @ApiModelProperty("发色")
    @JsonProperty("HairColor")
    private String HairColor;

    @ApiModelProperty("姿态")
    @JsonProperty("Gesture")
    private String Gesture;

    @ApiModelProperty("状态")
    @JsonProperty("Status")
    private String Status;

    @ApiModelProperty("脸型")
    @JsonProperty("FaceStyle")
    private String FaceStyle;

    @ApiModelProperty("脸部特征")
    @JsonProperty("FacialFeature")
    private String FacialFeature;

    @ApiModelProperty("体貌特征")
    @JsonProperty("PhysicalFeature")
    private String PhysicalFeature;

    @ApiModelProperty("体表特征")
    @JsonProperty("BodyFeature")
    private String BodyFeature;

    @ApiModelProperty("习惯动作")
    @JsonProperty("HabitualMovement")
    private String HabitualMovement;

    @ApiModelProperty("行为")
    @JsonProperty("Behavior")
    private String Behavior;

    @ApiModelProperty("行为描述;对行为项备注中没有的行为进行描述")
    @JsonProperty("BehaviorDescription")
    @Size(max = 256, message = "嘴唇字符长度不能超过256.")
    private String BehaviorDescription;

    @ApiModelProperty("附属物;当有多个时用英文半角分号”;”分隔")
    @JsonProperty("Appendant")
    @Size(max = 128, message = "嘴唇字符长度不能超过128.")
    private String Appendant;

    @ApiModelProperty("附属物描述;对代码表中没有的附属物进行描述")
    @JsonProperty("AppendantDescription")
    @Size(max = 256, message = "嘴唇字符长度不能超过256.")
    private String AppendantDescription;

    @ApiModelProperty("伞颜色")
    @JsonProperty("UmbrellaColor")
    private String UmbrellaColor;

    @ApiModelProperty("口罩颜色")
    @JsonProperty("RespiratorColor")
    private String RespiratorColor;

    @ApiModelProperty("帽子款式")
    @JsonProperty("CapStyle")
    private String CapStyle;

    @ApiModelProperty("帽子颜色")
    @JsonProperty("CapColor")
    private String CapColor;

    @ApiModelProperty("眼镜款式")
    @JsonProperty("GlassStyle")
    private String GlassStyle;

    @ApiModelProperty("眼镜颜色")
    @JsonProperty("GlassColor")
    private String GlassColor;

    @ApiModelProperty("围巾颜色")
    @JsonProperty("ScarfColor")
    private String ScarfColor;

    @ApiModelProperty("包款式")
    @JsonProperty("BagStyle")
    private String BagStyle;

    @ApiModelProperty("包颜色")
    @JsonProperty("BagColor")
    private String BagColor;

    @ApiModelProperty("上衣款式")
    @JsonProperty("CoatStyle")
    private String CoatStyle;

    @ApiModelProperty("上衣长度")
    @JsonProperty("CoatLength")
    private String CoatLength;

    @ApiModelProperty("上衣颜色")
    @JsonProperty("CoatColor")
    private String CoatColor;

    @ApiModelProperty("裤子款式")
    @JsonProperty("TrousersStyle")
    private String TrousersStyle;

    @ApiModelProperty("裤子颜色")
    @JsonProperty("TrousersColor")
    private String TrousersColor;

    @ApiModelProperty("裤子长度")
    @JsonProperty("TrousersLen")
    private String TrousersLen;

    @ApiModelProperty("鞋子款式")
    @JsonProperty("ShoesStyle")
    private String ShoesStyle;

    @ApiModelProperty("鞋子颜色")
    @JsonProperty("ShoesColor")
    private String ShoesColor;

    @ApiModelProperty("是否驾驶员;人工采集时必选0：否；1：是；2：不确定")
    @JsonProperty("IsDriver")
    private Integer IsDriver;

    @ApiModelProperty("是否涉外人员;0：否；1：是；2：不确定")
    @JsonProperty("IsForeigner")
    private Integer IsForeigner;

    @ApiModelProperty("护照证件种类")
    @JsonProperty("PassportType")
    private String PassportType;

    @ApiModelProperty("出入境人员类别代码;出入境人员分类代码")
    @JsonProperty("ImmigrantTypeCode")
    private String ImmigrantTypeCode;

    @ApiModelProperty("是否涉恐人员;0：否；1：是；2：不确定")
    @JsonProperty("IsSuspectedTerrorist")
    private Integer IsSuspectedTerrorist;

    @ApiModelProperty("涉恐人员编号")
    @JsonProperty("SuspectedTerroristNumber")
    private String SuspectedTerroristNumber;

    @ApiModelProperty("是否涉案人员;0：否；1：是；2：不确定")
    @JsonProperty("IsCriminalInvolved")
    private Integer IsCriminalInvolved;

    @ApiModelProperty("涉案人员专长代码")
    @JsonProperty("CriminalInvolvedSpecilisationCode")
    private String CriminalInvolvedSpecilisationCode;

    @ApiModelProperty("体表特殊标记")
    @JsonProperty("BodySpeciallMark")
    private String BodySpeciallMark;

    @ApiModelProperty("作案手段")
    @JsonProperty("CrimeMethod")
    private String CrimeMethod;

    @ApiModelProperty("作案特点代码")
    @JsonProperty("CrimeCharacterCode")
    private String CrimeCharacterCode;

    @ApiModelProperty("在逃人员编号")
    @JsonProperty("EscapedCriminalNumber")
    private String EscapedCriminalNumber;

    @ApiModelProperty("是否在押人员;0：否；1：是；2：不确定，人工采集必填")
    @JsonProperty("IsDetainees")
    private Integer IsDetainees;

    @ApiModelProperty("看守所编码")
    @JsonProperty("DetentionHouseCode")
    private String DetentionHouseCode;

    @ApiModelProperty("在押人员身份;详细取值见附录 B")
    @JsonProperty("DetaineesIdentity")
    private String DetaineesIdentity;

    @ApiModelProperty("在押人员特殊身份")
    @JsonProperty("DetaineesSpecialIdentity")
    private String DetaineesSpecialIdentity;

    @ApiModelProperty("成员类型代码")
    @JsonProperty("MemberTypeCode")
    private String MemberTypeCode;

    @ApiModelProperty("是否被害人;人工采集时必选0：否；1：是；2：不确定")
    @JsonProperty("IsVictim")
    private Integer IsVictim;

    @ApiModelProperty("被害人种类")
    @JsonProperty("VictimType")
    private String VictimType;

    @ApiModelProperty("受伤害程度")
    @JsonProperty("InjuredDegree")
    private String InjuredDegree;

    @ApiModelProperty("尸体状况代码")
    @JsonProperty("CorpseConditionCode")
    private String CorpseConditionCode;

    @ApiModelProperty("是否可疑人;人工采集时必选0：否；1：是；2：不确定")
    @JsonProperty("IsSuspiciousPerson")
    private Integer IsSuspiciousPerson;

    @ApiModelProperty("图像列表")
    @JsonProperty("SubImageList")
    private SubImageList SubImageList;

//    @ApiModelProperty("关联列表")
//    @JsonProperty("RelatedList")
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    private RelatedList RelatedList;
//
//    @ApiModelProperty("关联类型")
//    @JsonProperty("RelatedType")
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    private String RelatedType;
}
