package com.platform.springboot.mapper.dmi;

import com.github.pagehelper.Page;
import com.platform.springboot.entity.dmi.DmiCommProductMarketingCampaign;
import com.platform.springboot.entity.dmi.DmiCommProductMarketingCampaignPage;
import com.platform.springboot.entity.dmi.ret.dmiCommProductMarketingCampaign.ListRet;
import com.platform.springboot.entity.dmi.DmiCommProductMarketingCampaign;
import com.platform.springboot.entity.dmi.DmiCommProductMarketingCampaignPage;
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