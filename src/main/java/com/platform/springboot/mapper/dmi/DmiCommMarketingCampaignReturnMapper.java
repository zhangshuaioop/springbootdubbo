package com.platform.springboot.mapper.dmi;

import com.platform.springboot.entity.dmi.DmiCommMarketingCampaignReturn;
import com.platform.springboot.entity.dmi.DmiCommMarketingCampaignReturn;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DmiCommMarketingCampaignReturnMapper {

    int insertSelective(DmiCommMarketingCampaignReturn record);

    DmiCommMarketingCampaignReturn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiCommMarketingCampaignReturn record);

    DmiCommMarketingCampaignReturn showByContractId(Integer contractId);

}