package com.dyne.viid.entity.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 人脸对象
 */
@Data
@ApiModel("人脸对象")
@JsonRootName("FaceObject")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceObject implements Serializable {
    private static final long serialVersionUID = 398457205508099240L;

    @ApiModelProperty("人脸标识")
    @JsonProperty("FaceID")
    @NotBlank(message = "人脸标识不能为空.")
    @JSONField(name="FaceID")
    private String FaceID;

    @ApiModelProperty("信息分类")
    @JsonProperty("InfoKind")
    @NotNull(message = "信息分类必须填写.")
    @JSONField(name="InfoKind")
    private Integer InfoKind;

    @ApiModelProperty("来源标识")
    @JsonProperty("SourceID")
    @NotBlank(message = "来源标识必须填写.")
    @JSONField(name="SourceID")
    private String SourceID;

    @ApiModelProperty("设备编码")
    @JsonProperty("DeviceID")
    @JSONField(name="DeviceID")
    private String DeviceID;

    @ApiModelProperty(value = "拍摄时间")
    @JsonProperty("ShotTime")
    @JSONField(name="ShotTime")
    private LocalDateTime ShotTime;

    @ApiModelProperty("左上角 X 坐标")
    @JsonProperty("LeftTopX")
    @JSONField(name="LeftTopX")
    private Integer LeftTopX;

    @ApiModelProperty("左上角 Y 坐标")
    @JsonProperty("LeftTopY")
    @JSONField(name="LeftTopY")
    private Integer LeftTopY;

    @ApiModelProperty("右下角 X 坐标")
    @JsonProperty("RightBtmX")
    @JSONField(name="RightBtmX")
    private Integer RightBtmX;

    @ApiModelProperty("右下角 Y 坐标")
    @JsonProperty("RightBtmY")
    @JSONField(name="RightBtmY")
    private Integer RightBtmY;

    @ApiModelProperty("位置标记时间")
    @JsonProperty("LocationMarkTime")
    @JSONField(name="LocationMarkTime")
    private LocalDateTime LocationMarkTime;

    @ApiModelProperty("人脸出现时间;人工采集时有效")
    @JsonProperty("FaceAppearTime")
    @JSONField(name="FaceAppearTime")
    private LocalDateTime FaceAppearTime;

    @ApiModelProperty("人脸消失时间")
    @JsonProperty("FaceDisAppearTime")
    @JSONField(name="FaceDisAppearTime")
    private LocalDateTime FaceDisAppearTime;

    @ApiModelProperty("证件种类")
    @JsonProperty("IDType")
    @JSONField(name="IDType")
    private String IDType;

    @ApiModelProperty("证件号码;有效证件号码")
    @JsonProperty("IDNumber")
    @JSONField(name="IDNumber")
    private String IDNumber;

    @ApiModelProperty("姓名;人员的中文姓名全称")
    @JsonProperty("Name")
    @JSONField(name="Name")
    private String Name;

    @ApiModelProperty("曾用名;曾经在户籍管理部门正式登记注册、人事档案中正式记载的姓氏名称")
    @JsonProperty("UsedName")
    @JSONField(name="UsedName")
    private String UsedName;

    @ApiModelProperty("绰号;使用姓名及曾用名之外的名称")
    @JsonProperty("Alias")
    @JSONField(name="Alias")
    private String Alias;

    @ApiModelProperty("性别代码")
    @JsonProperty("GenderCode")
    @JSONField(name="GenderCode")
    private String GenderCode;

    @ApiModelProperty("年龄上限;最大可能年龄")
    @JsonProperty("AgeUpLimit")
    @JSONField(name="AgeUpLimit")
    private Integer AgeUpLimit;

    @ApiModelProperty("年龄下限;最小可能年龄")
    @JsonProperty("AgeLowerLimit")
    @JSONField(name="AgeLowerLimit")
    private Integer AgeLowerLimit;

    @ApiModelProperty("民族代码;中国各名族的罗马字母拼写法和代码")
    @JsonProperty("EthicCode")
    @JSONField(name="EthicCode")
    private String EthicCode;

    @ApiModelProperty("国籍代码;世界各国和地区名称代码")
    @JsonProperty("NationalityCode")
    @JSONField(name="NationalityCode")
    private String NationalityCode;

    @ApiModelProperty("籍贯省市县代码")
    @JsonProperty("NativeCityCode")
    @JSONField(name="NativeCityCode")
    private String NativeCityCode;

    @ApiModelProperty("居住地行政区划")
    @JsonProperty("ResidenceAdminDivision")
    @JSONField(name="ResidenceAdminDivision")
    private String ResidenceAdminDivision;

    @ApiModelProperty("汉语口音代码;汉语口音编码规则")
    @JsonProperty("ChineseAccentCode")
    @JSONField(name="ChineseAccentCode")
    private String ChineseAccentCode;

    @ApiModelProperty("职业类别代码;职业分类与代码，不包含代码中“—”")
    @JsonProperty("JobCategory")
    @JSONField(name="JobCategory")
    private String JobCategory;

    @ApiModelProperty("同行人数;被标注人的同行人数")
    @JsonProperty("AccompanyNumber")
    @JSONField(name="AccompanyNumber")
    private Integer AccompanyNumber;

    @ApiModelProperty("肤色")
    @JsonProperty("SkinColor")
    @JSONField(name="SkinColor")
    private String SkinColor;

    @ApiModelProperty("发型")
    @JsonProperty("HairStyle")
    @JSONField(name="HairStyle")
    private String HairStyle;

    @ApiModelProperty("发色")
    @JsonProperty("HairColor")
    @JSONField(name="HairColor")
    private String HairColor;

    @ApiModelProperty("脸型")
    @JsonProperty("FaceStyle")
    @JSONField(name="FaceStyle")
    private String FaceStyle;

    @ApiModelProperty("脸部特征")
    @JsonProperty("FacialFeature")
    @JSONField(name="FacialFeature")
    private String FacialFeature;

    @ApiModelProperty("体貌特征")
    @JsonProperty("PhysicalFeature")
    @JSONField(name="PhysicalFeature")
    private String PhysicalFeature;

    @ApiModelProperty("口罩颜色")
    @JsonProperty("RespiratorColor")
    @JSONField(name="RespiratorColor")
    private String RespiratorColor;

    @ApiModelProperty("帽子款式")
    @JsonProperty("CapStyle")
    @JSONField(name="CapStyle")
    private String CapStyle;

    @ApiModelProperty("帽子颜色")
    @JsonProperty("CapColor")
    @JSONField(name="CapColor")
    private String CapColor;

    @ApiModelProperty("眼镜款式")
    @JsonProperty("GlassStyle")
    @JSONField(name="GlassStyle")
    private String GlassStyle;

    @ApiModelProperty("眼镜颜色")
    @JsonProperty("GlassColor")
    @JSONField(name="GlassColor")
    private String GlassColor;

    @ApiModelProperty("是否驾驶员;人工采集时必选0：否；1：是；2：不确定")
    @JsonProperty("IsDriver")
    @JSONField(name="IsDriver")
    private Integer IsDriver;

    @ApiModelProperty("是否涉外人员;0：否；1：是；2：不确定")
    @JsonProperty("IsForeigner")
    @JSONField(name="IsForeigner")
    private Integer IsForeigner;

    @ApiModelProperty("护照证件种类")
    @JsonProperty("PassportType")
    @JSONField(name="PassportType")
    private String PassportType;

    @ApiModelProperty("出入境人员类别代码;出入境人员分类代码")
    @JsonProperty("ImmigrantTypeCode")
    @JSONField(name="ImmigrantTypeCode")
    private String ImmigrantTypeCode;

    @ApiModelProperty("是否涉恐人员;0：否；1：是；2：不确定")
    @JsonProperty("IsSuspectedTerrorist")
    @JSONField(name="IsSuspectedTerrorist")
    @NotNull(message = "是否涉恐人员必须填写.")
    private Integer IsSuspectedTerrorist;

    @ApiModelProperty("涉恐人员编号")
    @JsonProperty("SuspectedTerroristNumber")
    @JSONField(name="SuspectedTerroristNumber")
    private String SuspectedTerroristNumber;

    @ApiModelProperty("是否涉案人员;0：否；1：是；2：不确定")
    @JsonProperty("IsCriminalInvolved")
    @NotNull(message = "是否涉案人员必须填写.")
    @JSONField(name="IsCriminalInvolved")
    private Integer IsCriminalInvolved;

    @ApiModelProperty("涉案人员专长代码")
    @JsonProperty("CriminalInvolvedSpecilisationCode")
    @JSONField(name="CriminalInvolvedSpecilisationCode")
    private String CriminalInvolvedSpecilisationCode;

    @ApiModelProperty("体表特殊标记")
    @JsonProperty("BodySpeciallMark")
    @JSONField(name="BodySpeciallMark")
    private String BodySpeciallMark;

    @ApiModelProperty("作案手段")
    @JsonProperty("CrimeMethod")
    @JSONField(name="CrimeMethod")
    private String CrimeMethod;

    @ApiModelProperty("作案特点代码")
    @JsonProperty("CrimeCharacterCode")
    @JSONField(name="CrimeCharacterCode")
    private String CrimeCharacterCode;

    @ApiModelProperty("在逃人员编号")
    @JsonProperty("EscapedCriminalNumber")
    @JSONField(name="EscapedCriminalNumber")
    private String EscapedCriminalNumber;

    @ApiModelProperty("是否在押人员;0：否；1：是；2：不确定，人工采集必填")
    @JsonProperty("IsDetainees")
    @JSONField(name="IsDetainees")
    @NotNull(message = "是否在押人员必须填写.")
    private Integer IsDetainees;

    @ApiModelProperty("看守所编码")
    @JsonProperty("DetentionHouseCode")
    @JSONField(name="DetentionHouseCode")
    private String DetentionHouseCode;

    @ApiModelProperty("在押人员身份;详细取值见附录 B")
    @JsonProperty("DetaineesIdentity")
    @JSONField(name="DetaineesIdentity")
    private String DetaineesIdentity;

    @ApiModelProperty("在押人员特殊身份")
    @JsonProperty("DetaineesSpecialIdentity")
    @JSONField(name="DetaineesSpecialIdentity")
    private String DetaineesSpecialIdentity;

    @ApiModelProperty("成员类型代码")
    @JsonProperty("MemberTypeCode")
    @JSONField(name="MemberTypeCode")
    private String MemberTypeCode;

    @ApiModelProperty("是否被害人;人工采集时必选0：否；1：是；2：不确定")
    @JsonProperty("IsVictim")
    @JSONField(name="IsVictim")
    @NotNull(message = "是否被害人必须填写.")
    private Integer IsVictim;

    @ApiModelProperty("被害人种类")
    @JsonProperty("VictimType")
    @JSONField(name="VictimType")
    private String VictimType;

    @ApiModelProperty("受伤害程度")
    @JsonProperty("InjuredDegree")
    @JSONField(name="InjuredDegree")
    private String InjuredDegree;

    @ApiModelProperty("尸体状况代码")
    @JsonProperty("CorpseConditionCode")
    @JSONField(name="CorpseConditionCode")
    private String CorpseConditionCode;

    @ApiModelProperty("是否可疑人;人工采集时必选0：否；1：是；2：不确定")
    @JsonProperty("IsSuspiciousPerson")
    @JSONField(name="IsSuspiciousPerson")
    @NotNull(message = "是否可疑人必须填写.")
    private Integer IsSuspiciousPerson;

    @JsonProperty("Temperature")
    @JSONField(name="Temperature")
    private String Temperature;


    @ApiModelProperty("姿态分布;1：平视；2：微仰；3：微俯；4：左微侧脸；5左斜侧脸；6：左全侧脸；7：右微侧脸；8：右 斜侧脸；9：右全侧脸")
    @JsonProperty("Attitude")
    @JSONField(name="Attitude")
    private Integer Attitude;

    @ApiModelProperty("相似度;人脸相似度，[0，1]")
    @JsonProperty("Similaritydegree")
    @JSONField(name="Similaritydegree")
    private BigDecimal Similaritydegree;

    @ApiModelProperty("眉型;1：上扬眉；2：一字眉；3：八字眉；4：淡眉毛 5：浓眉毛；6：弯眉；7：细眉；8：短眉毛9：特殊眉；  有多个特征时用英文半角分 号”;”分隔")
    @JsonProperty("EyebrowStyle")
    @JSONField(name="EyebrowStyle")
    @Size(max = 32, message = "眉型字符长度不能超过32.")
    private String EyebrowStyle;

    @ApiModelProperty("鼻型;1：普通鼻；2：扁鼻子；3：尖鼻子；4：朝天鼻；5：鹰钩鼻；6：蒜头鼻；7：宽鼻子；8： 小鼻子；9：露孔鼻；10：特殊鼻； 有多个特 征时用英文半角分号”;”分隔")
    @JsonProperty("NoseStyle")
    @JSONField(name="NoseStyle")
    @Size(max = 32, message = "鼻型字符长度不能超过32.")
    private String NoseStyle;

    @ApiModelProperty("胡型;1：一字胡；2：八字胡；3：淡胡子；4：络腮胡；5：山羊胡；6：花白胡；7：一点胡")
    @JsonProperty("MustacheStyle")
    @JSONField(name="MustacheStyle")
    @Size(max = 32, message = "胡型字符长度不能超过32.")
    private String MustacheStyle;

    @ApiModelProperty("嘴唇;1：常见嘴；2：厚嘴唇；3：薄嘴唇；4：厚嘴巴；5：上翘嘴；6：下撇嘴；7：凸嘴；8：凹 嘴；9：露齿嘴；10：小嘴； 有多个特征时用 英文半角分号”;”分隔")
    @JsonProperty("LipStyle")
    @JSONField(name="LipStyle")
    @Size(max = 32, message = "嘴唇字符长度不能超过32.")
    private String LipStyle;

    @ApiModelProperty("皱纹眼袋;1：抬头纹；2：左眼角纹；3：右眼角纹；4：眉间纹；5：左眼纹；6：右眼纹；7：眼袋；8左笑纹；9：右笑纹；10：鼻间纹；11：左瘦纹12：右瘦纹；  有多个特征时用英文半角分 号”;”分隔")
    @JsonProperty("WrinklePouch")
    @JSONField(name="WrinklePouch")
    @Size(max = 32, message = "皱纹眼袋字符长度不能超过32.")
    private String WrinklePouch;

    @ApiModelProperty("痤疮色斑;1：痤疮（单）；2：痤疮（少）；3：痤疮（多）4：雀斑（稀）；5：雀斑（少）；6：雀斑（多）7：色斑； 有多个特征时用英文半角分号”;” 分隔")
    @JsonProperty("AcneStain")
    @JSONField(name="AcneStain")
    @Size(max = 32, message = "痤疮色斑字符长度不能超过32.")
    private String AcneStain;

    @ApiModelProperty("黑痣胎记;1：痣（小）；2：痣（中）；3：痣（大）；4：黑痣（小）；5：黑痣（中）；6：黑痣（大）；7：胎记；有多个特征时用英文半角分号”;”分隔")
    @JsonProperty("FreckleBirthmark")
    @JSONField(name="FreckleBirthmark")
    @Size(max = 32, message = "黑痣胎记字符长度不能超过32.")
    private String FreckleBirthmark;

    @ApiModelProperty("疤痕酒窝;1：疤痕；2：酒窝左；3：酒窝右； 有多个特征时用英文半角分号”;”分隔")
    @JsonProperty("ScarDimple")
    @JSONField(name="ScarDimple")
    @Size(max = 32, message = "疤痕酒窝字符长度不能超过32.")
    private String ScarDimple;

    @ApiModelProperty("其他特征;1：酒渣鼻（小）；2：酒渣鼻（大）；3：酒渣鼻（重）  4：招风耳左；5：招风耳右；6：大耳朵左；7：大耳朵右；8：粗糙皮肤；9：白癜风小；10：白癜风中；11：白癜风大；  有多个 特征时用英文半角分号”;”分隔")
    @JsonProperty("OtherFeature")
    @JSONField(name="OtherFeature")
    @Size(max = 32, message = "其他特征字符长度不能超过32.")
    private String OtherFeature;

    @ApiModelProperty("图像列表")
    @JsonProperty("SubImageList")
    @JSONField(name="SubImageList")
    private SubImageList subImageList;

//    @ApiModelProperty("关联列表")
//    @JsonProperty("RelatedList")
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    private RelatedList relatedList;

//    @ApiModelProperty("关联类型")
//    @JsonProperty("RelatedType")
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    private String RelatedType;
}
