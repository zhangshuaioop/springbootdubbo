package com.company.springboot.mapper.dmi;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.bif.BifMd5CodePool;
import com.company.springboot.entity.dmi.DmiCompanyInfo;
import com.company.springboot.entity.dto.dmi.DmiCompanyInfo.CommListDTO;
import com.company.springboot.entity.ret.dmi.DmiCompanyInfo.CommListByDownloadRet;
import com.company.springboot.entity.ret.dmi.DmiCompanyInfo.CommListRet;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.github.pagehelper.Page;
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



    /**
     * 根据公司名称查询
     * @param companyName
     * @return
     */
    DmiCompanyInfo selectByCompanyName(String companyName);


    /**
     * 新增并获取自增主键
     * @param dmiCompanyInfo
     */
    void insertGetId(DmiCompanyInfo dmiCompanyInfo);


    List<String> selectCompanyNameList(SysCompanyUsers users);

    Integer selectCompanyId(String companyName);

    void updateCompanyToken(BifMd5CodePool pool);

    void updateCompanyUrl(DmiCompanyInfo dmiCompanyInfo);

    List<DmiCompanyInfo> selectAll();


    List<DmiCompanyInfo> selectNoQrCodeCompany();

    Page<DmiCompanyInfo> companyList();

    /**
     * 获取当前关联公司
     *
     * @param relationCompanyIds
     * @return
     */
    List<DmiCompanyInfo> companyByUserList(String relationCompanyIds);

    /**
     * 查询所有
     * @return
     */
    List<DmiCompanyInfo> findAll(DmiCompanyInfo dmiCompanyInfo);


    List<DmiCompanyInfo> companyListParam(Integer companyId);
}