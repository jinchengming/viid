package com.dyne.viid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyne.viid.entity.VmsDevice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-22
 */
public interface VmsDeviceMapper extends BaseMapper<VmsDevice> {

    @Select("select ID,ApeID,UserId,Password,Place from vms_device where ApeID=#{apeId}")
    VmsDevice getByApeId(@Param("apeId") String apeId);

    @Update("update vms_device set IsOnline='1' where ApeID=#{deviceId}")
    void onLineByDeviceId(@Param("deviceId") String deviceId);

    @Update("update vms_device set IsOnline='0' where ApeID=#{deviceId}")
    void offLineByDeviceId(@Param("deviceId") String deviceId);
}
