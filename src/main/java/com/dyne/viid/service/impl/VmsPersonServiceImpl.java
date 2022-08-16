package com.dyne.viid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyne.viid.common.enums.AlarmMsgType;
import com.dyne.viid.entity.VmsImage;
import com.dyne.viid.entity.VmsPerson;
import com.dyne.viid.entity.VmsPersonImage;
import com.dyne.viid.mapper.VmsPersonMapper;
import com.dyne.viid.service.MqService;
import com.dyne.viid.service.VmsImageService;
import com.dyne.viid.service.VmsPersonImageService;
import com.dyne.viid.service.VmsPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-29
 */
@Service
public class VmsPersonServiceImpl extends ServiceImpl<VmsPersonMapper, VmsPerson> implements VmsPersonService {

    @Resource
    private VmsImageService vmsImageService;

    @Resource
    private VmsPersonImageService vmsPersonImageService;

    @Autowired
    private MqService mqService;

    @Transactional
    @Override
    public void savePersonData(VmsPerson vmsPerson, List<VmsImage> vmsImageList) {
        this.baseMapper.insert(vmsPerson);
        for (VmsImage vmsImage : vmsImageList) {
            vmsImageService.save(vmsImage);
            VmsPersonImage vmsPersonImage = new VmsPersonImage();
            vmsPersonImage.setPersonID(vmsPerson.getID());
            vmsPersonImage.setImageID(vmsImage.getID());
            vmsPersonImageService.save(vmsPersonImage);
        }
        mqService.sendMsgToMQ(vmsPerson.getPersonID(), vmsPerson.getDeviceID(), vmsPerson.getShotTime(), AlarmMsgType.PERSON.getValue(), vmsImageList);
    }
}
