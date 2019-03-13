package com.company.springboot.mapper.dmi;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.dmi.DmiContact;
import com.company.springboot.entity.dmi.DmiContactResetPassword;
import com.company.springboot.entity.dmi.DmiExportContact;
import com.company.springboot.entity.fdp.FdpFaultOrderProcess;
import com.company.springboot.entity.fdp.SelectContactExistInStore;
import com.company.springboot.entity.fdp.SelectExistInStoreResp;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface DmiContactMapper extends BaseMapper<DmiContact> {
    /**
     * 新增联系人
     *
     * @param record

     * @author liukan
     * @create 2018年04月25日 10:43
     * @return Map
     */
    int insertSelective(DmiContact record);

    DmiContact selectByPrimaryKey(Integer id);

    Page<DmiContact> selectListByCompanyId(DmiContact dmiContact);

    int updateByPrimaryKeySelective(DmiContact dmiContact);

    List<DmiContact> selectListNoInCompanyByCompanyId(Integer companyId);

    List<DmiContact> selectListNoInStoreByStoreId(HashMap<String, Object> map);

    SelectExistInStoreResp selectExistInStore(SelectContactExistInStore record);


    List<DmiContact> selectByMobile(String mobile);

    void updateContatNameByMobile(String mobile);

    List<DmiContact> selectAccount(String account);

    DmiContact selectByIdAndPassword(DmiContactResetPassword contact);

    void updateByIdAndPassword(DmiContactResetPassword contact);

    List<DmiExportContact> selectContactByCompanyId(int companyId);

    List<String> selectMobile();

    List<String> selectAccountByNull();

    void updateContact(FdpFaultOrderProcess process);

    DmiContact selectByNameMobile(FdpFaultOrderProcess process);

    List<DmiExportContact> selectListByCompany(DmiContact dmiContact);

    void updateByPrimaryKeySelectiveCheck(DmiContact dmiContact);

    Page<DmiContact> selectListByStoreId(DmiContact contact);

    Integer updateNotFlagMajorContactById(DmiContact contact);
}