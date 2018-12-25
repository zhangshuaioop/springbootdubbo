package com.platform.springboot.mapper.dmi;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.bif.BifMd5CodePool;
import com.platform.springboot.entity.dmi.DmiCompanyInfo;
import com.platform.springboot.entity.dto.dmi.DmiCompanyInfo.CommListDTO;
import com.platform.springboot.entity.ret.dmi.DmiCompanyInfo.CommListByDownloadRet;
import com.platform.springboot.entity.ret.dmi.DmiCompanyInfo.CommListRet;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.utils.Result;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.bif.BifMd5CodePool;
import com.platform.springboot.entity.dmi.DmiCompanyInfo;
import com.platform.springboot.entity.dto.dmi.DmiCompanyInfo.CommListDTO;
import com.platform.springboot.entity.ret.dmi.DmiCompanyInfo.CommListByDownloadRet;
import com.platform.springboot.entity.ret.dmi.DmiCompanyInfo.CommListRet;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DmiCompanyInfoMapper extends BaseMapper<DmiCompanyInfo> {

    int insertSelective(DmiCompanyInfo record);

    DmiCompanyInfo selectByPrimaryKey(Integer id);

    int selectByBusinessLicenseId(Integer id);

    List<Map<String, Object>> selectAllDmiCompanyBasicInfo();

    List<Map<String, Object>> selectAllDmiCompanyBasicInfoByVendor(Integer id);

    List<Map<String, Object>> selectAllDmiCompanyBasicInfoByDemand(Integer id);

    Map<String, Object> selectBasicInfoByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiCompanyInfo record);

    List<DmiCompanyInfo> queryByVendor(Integer vendorId);

    //查询指定雇主下的通信资源列表
    List<CommListRet> commList(CommListDTO record);
    //查询指定雇主下的通信资源列表
    List<CommListRet> productList(CommListDTO record);
    //查询指定雇主下的通信资源列表
    List<CommListRet> campaignList(CommListDTO record);

    List<CommListByDownloadRet> commListByDownload(CommListDTO record);

    List<CommListByDownloadRet> productListByDownload(CommListDTO record);

    List<CommListByDownloadRet> campaignListByDownload(CommListDTO record);

    Integer selectVendorId(Integer id);



    List<String> selectCompanyName(SysCompanyUsers users);
    List<String> selectCompanyNameList(SysCompanyUsers users);

    List<String> selectVendorList(SysCompanyUsers users);

    Integer selectCompanyId(String companyName);

    void updateCompanyToken(BifMd5CodePool pool);

    void updateCompanyUrl(DmiCompanyInfo dmiCompanyInfo);

    List<DmiCompanyInfo> selectAll();


    List<DmiCompanyInfo> selectNoQrCodeCompany();

    List<DmiCompanyInfo> companyList();

    /**
     * 获取当前关联公司
     * @param relationCompanyIds
     * @return
     */
    List<DmiCompanyInfo> companyByUserList(String relationCompanyIds);
}