package com.dyne.viid.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
@TableName("vms_face_image")
@ApiModel(value = "VmsFaceImage对象", description = "")
public class VmsFaceImage implements Serializable {

    private static final long serialVersionUID = 7259635616783442194L;

    private Long FaceID;

    private Long ImageID;

}
