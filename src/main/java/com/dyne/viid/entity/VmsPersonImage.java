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
@TableName("vms_person_image")
@ApiModel(value = "VmsPersonImage对象", description = "")
public class VmsPersonImage implements Serializable {


    private static final long serialVersionUID = -1325296951658589971L;
    
    private Long PersonID;

    private Long ImageID;


}
