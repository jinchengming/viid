package com.dyne.viid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyne.viid.entity.VmsFace;
import com.dyne.viid.entity.VmsFaceImage;
import com.dyne.viid.entity.VmsImage;
import com.dyne.viid.mapper.VmsFaceMapper;
import com.dyne.viid.service.VmsFaceImageService;
import com.dyne.viid.service.VmsFaceService;
import com.dyne.viid.service.VmsImageService;
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
 * @since 2022-06-23
 */
@Service
public class VmsFaceServiceImpl extends ServiceImpl<VmsFaceMapper, VmsFace> implements VmsFaceService {


    @Resource
    private VmsImageService vmsImageService;

    @Resource
    private VmsFaceImageService vmsFaceImageService;
    

    @Transactional
    @Override
    public void saveFaceData(VmsFace vmsFace, List<VmsImage> vmsImageList) {
        this.baseMapper.insert(vmsFace);
        for (VmsImage vmsImage : vmsImageList) {
            vmsImageService.save(vmsImage);
            VmsFaceImage vmsFaceImage = new VmsFaceImage();
            vmsFaceImage.setFaceID(vmsFace.getID());
            vmsFaceImage.setImageID(vmsImage.getID());
            vmsFaceImageService.save(vmsFaceImage);
        }
    }
}
