package com.teekee.waterdropservice.mapper.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiCommProductMarketingCampaign;
import com.teekee.waterdropservice.entity.dmi.DmiCommProductMarketingCampaignPage;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiCommProductMarketingCampaignMapper {

    int insertSelective(DmiCommProductMarketingCampaign record);

    DmiCommProductMarketingCampaign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiCommProductMarketingCampaign record);

    Page<DmiCommProductMarketingCampaignPage> getPageListByStoreId(Integer storeId);

    List<DmiCommProductMarketingCampaign> getListByStoreId(Integer storeId);

}