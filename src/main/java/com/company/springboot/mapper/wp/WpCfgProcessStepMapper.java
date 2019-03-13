package com.company.springboot.mapper.wp;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.wp.WpCfgProcessStep;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WpCfgProcessStepMapper extends BaseMapper<WpCfgProcessStep> {
    WpCfgProcessStep selectByWpCfgProcessStep(WpCfgProcessStep wpCfgProcessStep);

    /**
     * 根据当前节点步骤id查询上一节点信息
     * @param stepCode
     * @return
     */
    WpCfgProcessStep selectLast(String stepCode);

    /**
     * 根据当前表单orderId查询当前节点的信息
     * @param OrderId
     * @return
     */
    WpCfgProcessStep selectByOrderId(int OrderId);

    WpCfgProcessStep findWpCfgProcessStepByStepId(Integer cfgFrameprocessStepId,Integer versionId);

    WpCfgProcessStep findWpCfgProcessNextStepByWpFrameProcessId(Integer wpFrameProcessId);

    WpCfgProcessStep findWpCfgProcessStepByCompanyId(Integer companyId);

    WpCfgProcessStep findWpCfgProcessTopStepByWpFrameProcessId(Integer wpFrameProcessId);

    WpCfgProcessStep findWpCfgProcessNextStepByWpCfgProcessStepId(Integer id);

    WpCfgProcessStep findWpCfgProcessTopStepByWpCfgProcessStepId(Integer id);
}