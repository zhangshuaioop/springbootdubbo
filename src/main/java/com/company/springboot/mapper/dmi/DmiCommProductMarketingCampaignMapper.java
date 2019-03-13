package com.company.springboot.mapper.dmi;

import com.company.springboot.entity.dmi.DmiCommProductMarketingCampaign;
import com.github.pagehelper.Page;
import com.company.springboot.entity.dmi.DmiCommProductMarketingCampaign;
import com.company.springboot.entity.dmi.DmiCommProductMarketingCampaignPage;
import com.company.springboot.entity.dmi.ret.dmiCommProductMarketingCampaign.ListRet;
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