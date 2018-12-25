package com.platform.springboot.service.cfg;

import com.platform.springboot.entity.cfg.CfgDeviceTypeCatalog;
import com.platform.springboot.mapper.cfg.CfgDeviceTypeCatalogMapper;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghao
 * @Title: CfgDeviceTypeCatalogService
 * @ProjectName WaterDrop
 * @Description: 设备类型
 * @date 2018/12/24下午4:32
 */
@Service
public class CfgDeviceTypeCatalogService {

    @Resource
   private CfgDeviceTypeCatalogMapper mapper;

    public List<CfgDeviceTypeCatalog> getListByParentId(List<Integer> list) {
        List<CfgDeviceTypeCatalog> listResult = mapper.queryByParentId(list);
        return listResult;
    }

    public Result getTreeById(Integer id) {
        // 初始化
        List<CfgDeviceTypeCatalog> result = new ArrayList<CfgDeviceTypeCatalog>();

        // 根据ID，查看设备类型
        CfgDeviceTypeCatalog entity = mapper.selectByPrimaryKey(id);

        // 设备类型不存在
        if (entity == null) {
            return ResultUtil.errorBusinessMsg("设备类型不存在");
        }

        // 获取level，parentId
        int level = entity.getLevel();
        int parentId = entity.getParentId();


        // level为3的情况
        if (level == 3) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(parentId);
            // 第一组节点
            List<CfgDeviceTypeCatalog> listThree = getListByParentId(list);

            // 第二组节点
            entity = mapper.selectByPrimaryKey(parentId);
            list = new ArrayList<Integer>();
            list.add(entity.getParentId());
            List<CfgDeviceTypeCatalog> listTwo = getListByParentId(list);

            // 第一组节点
            entity = mapper.selectByPrimaryKey(entity.getParentId());
            list = new ArrayList<Integer>();
            list.add(entity.getParentId());
            List<CfgDeviceTypeCatalog> listOne = getListByParentId(list);

            // 组装树形结构
            for (CfgDeviceTypeCatalog itemOne : listOne) {
                result.add(itemOne);
            }
            for (CfgDeviceTypeCatalog itemTwo : listTwo) {
                result.add(itemTwo);
            }
            for (CfgDeviceTypeCatalog itemThree : listThree) {
                result.add(itemThree);
            }
            return ResultUtil.success(result);
        }

        // level为2的情况
        if (level == 2) {
            // 第二组节点
            List<Integer> list = new ArrayList<Integer>();
            list.add(parentId);
            List<CfgDeviceTypeCatalog> listTwo = getListByParentId(list);

            // 第一组节点
            entity = mapper.selectByPrimaryKey(parentId);
            list = new ArrayList<Integer>();
            list.add(entity.getParentId());
            List<CfgDeviceTypeCatalog> listOne = getListByParentId(list);

            // 组装树形结构
            for (CfgDeviceTypeCatalog itemOne : listOne) {
                result.add(itemOne);
            }
            for (CfgDeviceTypeCatalog itemTwo : listTwo) {
                result.add(itemTwo);
            }
            return ResultUtil.success(result);
        }

        // level为1的情况
        if (level == 1) {
            // 第一组节点
            List<Integer> list = new ArrayList<Integer>();
            list.add(parentId);
            result = getListByParentId(list);
        }
        return ResultUtil.success(result);
    }
}
