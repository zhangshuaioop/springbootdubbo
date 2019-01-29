package com.teekee.blackrockservice.service.bif;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blackrockservice.entity.bif.BifDispatchHrServiceArea;
import com.teekee.blackrockservice.entity.bif.BifDispatchHumanResource;
import com.teekee.blackrockservice.entity.bif.ListBifDispatchHrServiceArea;
import com.teekee.blackrockservice.mapper.bif.BifDispatchHrServiceAreaMapper;
import com.teekee.blackrockservice.mapper.bif.BifDispatchHumanResourceMapper;
import com.teekee.blackrockservice.utils.ResponseMessage;
import com.teekee.blackrockservice.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/11/3
 **/
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class BifDispatchHrServiceAreaService extends BaseService<BifDispatchHrServiceAreaMapper,BifDispatchHrServiceArea>{
    @Resource
    BifDispatchHrServiceAreaMapper mapper;
    @Resource
    BifDispatchHumanResourceMapper humanResourceMapper;
    /**
     * 查询可服务区域列表
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    public List<ListBifDispatchHrServiceArea> serviceAreaList(Integer id) {
        List<ListBifDispatchHrServiceArea> result = mapper.selectByHrId(id);
        if (result.size() >0) {
            return result;
        }
        return new ArrayList<ListBifDispatchHrServiceArea>();
    }

    /**
     * 查询可服务区域
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    public ListBifDispatchHrServiceArea serviceAreaShow(Integer id) {
        if(id != 0){
            ListBifDispatchHrServiceArea result = mapper.selectById(id);
            if(result != null){
                return result;
            }
            return new ListBifDispatchHrServiceArea();
        }
        return new ListBifDispatchHrServiceArea();
    }

    /**
     * 新增/编辑可服务区域
     * @param param
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage handelServiceArea(BifDispatchHrServiceArea param) {
        Date now = new Date();
        if(param != null && param.getHrId() != null){
            //省份为空
            if(param.getProvince() == null || param.getProvince().equals("")){
                return StringUtil.buildErrorRespMsg("请填写省份！");
            }
            //城市为空
            if(param.getCity() == null || param.getCity().equals("")){
                return StringUtil.buildErrorRespMsg("请填写城市！");
            }

            List<ListBifDispatchHrServiceArea> listBifDispatchHrServiceAreas = mapper.selectByHrId(param.getHrId());


            if(param.getFlagDefault() != null && param.getFlagDefault() == true){
                if(param.getId() == 0){
                    //判断服务商服务城市不能重复
                    for (ListBifDispatchHrServiceArea item : listBifDispatchHrServiceAreas){
                        if(param.getCity().equals(item.getCity())){
                            return StringUtil.buildErrorRespMsg("该服务城市已存在！");
                        }
                    }
                }
                //取消原来默认区域
                BifDispatchHrServiceArea setDefault = new BifDispatchHrServiceArea();
                setDefault.setFlagDefault(false);
                setDefault.setHrId(param.getHrId());
                mapper.updateDefaultByHrId(setDefault);

                //更新hr的默认省份以及默认城市
                BifDispatchHumanResource resource = new BifDispatchHumanResource();
                resource.setDefaultProvice(param.getProvince());
                resource.setDefaultCity(param.getCity());
                resource.setId(param.getHrId());
                humanResourceMapper.updateByPrimaryKeySelective(resource);
            }

            //新增区域
            if(param.getId() == 0){

                //判断该服务商的服务区域数量不能超过十个
                if(listBifDispatchHrServiceAreas.size() >= 10){
                    return StringUtil.buildErrorRespMsg("服务区域不能超过十个，请删除后再新增！");
                }
                //判断服务商服务城市不能重复
                for (ListBifDispatchHrServiceArea item : listBifDispatchHrServiceAreas){
                    if(param.getCity().equals(item.getCity())){
                        return StringUtil.buildErrorRespMsg("该服务城市已存在！");
                    }
                }

                //新增
                param.setCreateTime(now);
                param.setFlagDeleted(false);
                int resutl = mapper.insertSelective(param);
                if(resutl > 0 ){
                    return StringUtil.buildSuccessRespMsg("新增服务区域成功！");
                }else {
                    return StringUtil.buildErrorRespMsg("新增服务区域失败！");
                }
            }else {//编辑区域

                //编辑服务区域省、市未改动
                BifDispatchHrServiceArea area = mapper.selectByPrimaryKey(param.getId());
                if(!area.getProvince().equals(param.getProvince()) && !area.getCity().equals(param.getCity())){
                    //判断服务商服务城市不能重复
                    for (ListBifDispatchHrServiceArea item : listBifDispatchHrServiceAreas){
                        if(param.getCity().equals(item.getCity())){
                            return StringUtil.buildErrorRespMsg("该服务城市已存在！");
                        }
                    }
                }


                //编辑
                int resutl = mapper.updateByPrimaryKeySelective(param);

                if(param.getFlagDefault() == false){
                    BifDispatchHrServiceArea serviceArea = mapper.selectDefaultAreaByHrId(param.getHrId());
                    if(serviceArea == null){
                        BifDispatchHrServiceArea lasrArea = mapper.selectLastTimeArea(param.getHrId());
                        lasrArea.setFlagDefault(true);
                        //没有默认服务区域  将最近创建服务创建设为默认
                        mapper.updateByPrimaryKeySelective(lasrArea);
                    }
                }
                if(resutl > 0 ){
                    return StringUtil.buildSuccessRespMsg("编辑服务区域成功！");
                }else {
                    return StringUtil.buildErrorRespMsg("编辑服务区域失败！");
                }
            }

        }
        return StringUtil.buildErrorRespMsg("新增服务区域失败！");
    }

    /**
     * 删除可服务区域
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/07/20
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage deleteService(Integer id) {
        if(id != 0){
            BifDispatchHrServiceArea serviceArea = mapper.selectByPrimaryKey(id);
            //可服务区域剩一条时不可删除
            int dhsa = mapper.selectServiceByHrId(serviceArea.getHrId());
            if(dhsa==1){
                return StringUtil.buildErrorRespMsg("删除服务区域失败,可服务区域至少保留一条！");
            }

            BifDispatchHrServiceArea param = new BifDispatchHrServiceArea();
            param.setFlagDeleted(true);
            param.setId(id);
            int result = mapper.updateByPrimaryKeySelective(param);


            if(serviceArea != null){
                //删除的区域为默认区域时将最近创建服务创建设为默认
                if(serviceArea.getFlagDefault() == true){
                    BifDispatchHrServiceArea lasrArea = mapper.selectLastTimeArea(serviceArea.getHrId());
                    lasrArea.setFlagDefault(true);
                    mapper.updateByPrimaryKeySelective(lasrArea);

                    //更新hr默认省以及城市
                    BifDispatchHumanResource resource = new BifDispatchHumanResource();
                    resource.setId(serviceArea.getHrId());
                    resource.setDefaultProvice(lasrArea.getProvince());
                    resource.setDefaultCity(lasrArea.getCity());
                    humanResourceMapper.updateByPrimaryKeySelective(resource);
                }

                return StringUtil.buildSuccessRespMsg("删除服务区域成功！");
            }else {
                return StringUtil.buildErrorRespMsg("删除服务区域失败！");
            }
        }
        return StringUtil.buildErrorRespMsg("删除服务区域失败！");
    }
}
