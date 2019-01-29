package com.teekee.blueoceanservice.service.bif;

import com.teekee.blueoceanservice.entity.bif.BifDispatchHrSkillLabel;
import com.teekee.blueoceanservice.entity.bif.BifDispatchHumanResource;
import com.teekee.blueoceanservice.mapper.bif.BifDispatchHrSkillLabelMapper;
import com.teekee.blueoceanservice.mapper.bif.BifDispatchHumanResourceMapper;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhanghao
 * @Title: BifDispatchHrSkillLabelService
 * @ProjectName BlueOcean
 * @Description: 服务商标签
 * @date 2018/12/29上午9:50
 */
@Service
public class BifDispatchHrSkillLabelService {

    @Resource
    private BifDispatchHrSkillLabelMapper bifDispatchHrSkillLabelMapper;

    @Resource
    private BifDispatchHumanResourceMapper bifDispatchHumanResourceMapper;

    public Result findList(Integer id) {
        BifDispatchHumanResource bifDispatchHumanResource = bifDispatchHumanResourceMapper.findBifDispatchHumanResource(id);

        List<BifDispatchHrSkillLabel> list = bifDispatchHrSkillLabelMapper.findAll();

        List<BifDispatchHrSkillLabel> newList = new ArrayList<BifDispatchHrSkillLabel>();

        List<BifDispatchHrSkillLabel> childs = null;
        for (BifDispatchHrSkillLabel bifDispatchHrSkillLabel : list) {
            childs = new ArrayList<BifDispatchHrSkillLabel>();
            for (BifDispatchHrSkillLabel bifDispatchHrSkillLabel2 : list) {
                if (bifDispatchHrSkillLabel.getId().equals(bifDispatchHrSkillLabel2.getParentId())) {
                    childs.add(bifDispatchHrSkillLabel2);

                }
            }

            String labelId = String.valueOf(bifDispatchHrSkillLabel.getId());

            if (bifDispatchHumanResource != null && bifDispatchHumanResource.getSkillLabelIds() != null && bifDispatchHumanResource.getSkillLabelIds().length() > 0) {
                String[] ids = bifDispatchHumanResource.getSkillLabelIds().split(",");
                for (String idq : ids) {
                    if (idq.equals(labelId)) {
                        //比较是否有选中标签
                        bifDispatchHrSkillLabel.setChecked(true);
                    }
                }
            }

            if (bifDispatchHrSkillLabel != null && bifDispatchHrSkillLabel.getParentId() != null && bifDispatchHrSkillLabel.getParentId() == 0) {
                bifDispatchHrSkillLabel.setChildren(childs);
                newList.add(bifDispatchHrSkillLabel);
            }

        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", newList);
        map.put("bifDispatchHumanResource", bifDispatchHumanResource);
        map.put("lables", findLables(id));
        return ResultUtil.success(map);
    }

    public String findLables(Integer id) {
        String strs = bifDispatchHumanResourceMapper.customLabelList(id);
        String resStr = "";
        if (strs != null && strs.length() > 0) {
            String[] list = strs.split(",");
            for (String customLabe : list) {
                if (!resStr.contains(customLabe)) {
                    resStr += customLabe + ",";
                }
            }
        }
        if (resStr.length() > 0) {
            resStr = resStr.substring(0, resStr.length() - 1);
        }
        return resStr;
    }

    public Result add(List<BifDispatchHrSkillLabel> bifDispatchHrSkillLabels) {

        List<BifDispatchHrSkillLabel> list = new ArrayList<BifDispatchHrSkillLabel>();
        List<BifDispatchHrSkillLabel> upList = new ArrayList<BifDispatchHrSkillLabel>();

        for (BifDispatchHrSkillLabel bifDispatchHrSkillLabel : bifDispatchHrSkillLabels) {

            bifDispatchHrSkillLabel.setParentId(0);

            if (bifDispatchHrSkillLabel.getId() != null && bifDispatchHrSkillLabel.getId() != 0) {
                upList.add(bifDispatchHrSkillLabel);
            } else {
                list.add(bifDispatchHrSkillLabel);
            }

            if (bifDispatchHrSkillLabel.getChildren() != null && bifDispatchHrSkillLabel.getChildren().size() > 0) {
                for (BifDispatchHrSkillLabel child : bifDispatchHrSkillLabel.getChildren()) {
                    child.setParentId(bifDispatchHrSkillLabel.getId());

                    if (child.getId() != null) {
                        upList.add(child);
                    } else {
                        list.add(child);
                    }

                }
            }
        }

        if (upList != null && upList.size() > 0) {
            bifDispatchHrSkillLabelMapper.updates(upList); //批量更新
            bifDispatchHrSkillLabelMapper.deletes(upList); //批量删除
        }

        if (list != null && list.size() > 0) {
            bifDispatchHrSkillLabelMapper.inserts(list); //批量添加
        }

        return ResultUtil.success();
    }

    public Result customLabelList(Integer id) {
        return ResultUtil.success(findLables(id));
    }

    public Result findAll() {
        return ResultUtil.success(bifDispatchHrSkillLabelMapper.findAll());
    }
}
