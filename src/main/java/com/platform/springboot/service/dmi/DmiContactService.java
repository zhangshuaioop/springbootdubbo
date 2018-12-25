package com.platform.springboot.service.dmi;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.dmi.DmiContact;
import com.platform.springboot.entity.dmi.ret.dmiStore.ListRet;
import com.platform.springboot.mapper.dmi.DmiContactMapper;
import com.platform.springboot.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/12/15
 **/
@Service
public class DmiContactService extends BaseService<DmiContactMapper,DmiContact>{
    @Autowired
    private DmiContactMapper mapper;

    /**
     * 根据雇主公司的ID，获取公司所有联系人列表
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/17
     */
    public Result getListByCompanyId(DmiContact dmiContact, int userId) {

        PageHelper.startPage(dmiContact.getPageNum(), dmiContact.getPageSize());
        Page<DmiContact> persons = mapper.selectListByCompanyId(dmiContact);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<DmiContact> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);

    }

    /**
     * 根据门店的ID，获取门店所有联系人列表
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/17
     */
    public Result getListByStoreId(DmiContact contact, Integer id) {
        PageHelper.startPage(contact.getPageNum(), contact.getPageSize());
        Page<DmiContact> persons = mapper.selectListByStoreId(contact);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<DmiContact> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    /**
     * 雇主新增/编辑联系人
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/17
     */
    public Result companyHandle(DmiContact dmiContact, Integer userId) {
        //if(dmiContact.getBelongCompanyId() == 0 || dmiContact.getBelongCompanyId() == null){
        //    return ResultUtil.validateError("参数错误");
        //}
        if (dmiContact.getId() > 0) {
            if(dmiContact.getContactName()==null||dmiContact.getContactName().equals("")){
                return ResultUtil.errorExceptionMsg("姓名不能为空");
            }
            if(dmiContact.getAccount()==null||dmiContact.getAccount().equals("")){
                return ResultUtil.errorExceptionMsg("账号不能为空");
            }
            if(dmiContact.getMobile()==null||dmiContact.getMobile().equals("")){
                return ResultUtil.errorExceptionMsg("手机号不能为空");
            }

            if(dmiContact.getMobile().length()>11){
                return ResultUtil.errorExceptionMsg("手机号码不得大于11位");
            }
            if(!ValiDateUtil.isNumeric(dmiContact.getMobile())){
                return ResultUtil.errorExceptionMsg("手机号码必须是纯数字");
            }

            if(dmiContact.getAccount().length()>20||dmiContact.getAccount().length()<6){
                return ResultUtil.errorExceptionMsg("账号长度必须大于6位并小于20位");
            }


            if(!ValiDateUtil.isAllHalf(dmiContact.getAccount())){
                return ResultUtil.errorExceptionMsg("账号必须半角");
            }

            dmiContact.setUpdatePerson(userId);
            dmiContact.setUpdateTime(new Date());

            return  updateContactCheck(dmiContact);

        } else {
            // 执行新增操作
            if(dmiContact.getAccount()==null||dmiContact.getAccount().equals("")){
                return ResultUtil.errorExceptionMsg("账号不能为空");
            }
            if(dmiContact.getMobile()==null||dmiContact.getAccount().equals("")){
                return  ResultUtil.errorExceptionMsg("手机号不能为空");
            }
            if(dmiContact.getMobile().length()>11){
                return ResultUtil.errorExceptionMsg("手机号码不得大于11位");
            }
            if(!ValiDateUtil.isNumeric(dmiContact.getMobile())){
                return ResultUtil.errorExceptionMsg("手机号码必须是纯数字");
            }
            if(dmiContact.getPassword()==null||dmiContact.getPassword().equals("")){
                return ResultUtil.errorExceptionMsg("密码不能为空");
            }
            if(dmiContact.getPassword().length()>20||dmiContact.getPassword().length()<6){
                return ResultUtil.errorExceptionMsg("密码长度必须大于6位并小于20位");
            }
            if(!ValiDateUtil.isAllHalf(dmiContact.getPassword())){
                return ResultUtil.errorExceptionMsg("密码必须半角");
            }
            if(!ValiDateUtil.isAllHalf(dmiContact.getAccount())){
                return ResultUtil.errorExceptionMsg("账号必须半角");
            }
            dmiContact.setCreatePerson(userId);
            dmiContact.setCreateTime(new Date());
            dmiContact.setFlagAvailable(true);
            dmiContact.setFlagDeleted(false);
            dmiContact.setUpdatePerson(userId);
            dmiContact.setUpdateTime(new Date());
            dmiContact.setPassword(Encrypt.getMD5Str(dmiContact.getPassword()));
            dmiContact.setAccount(dmiContact.getAccount());
            dmiContact.setSourceType("FAULT");
            //查询联系人手机号是否存在 如果不存在执行insert 如果存在修改联系人姓名



            List<DmiContact> list = mapper.selectByMobile(dmiContact.getMobile());
            List<DmiContact> accountList = mapper.selectAccount(dmiContact.getAccount());
            //判定账号是否重复
            if (accountList.size() == 0) {
                //判定手机号是否重复
                if (list.size() > 0) {
                    return ResultUtil.errorExceptionMsg("此手机号已绑定用户");
                } else {
                    // 如果从页面Body中没有获得CompanyId参数，需要手动设定一次CompanyId
                    //if (dmiContact.getBelongCompanyId() == null || dmiContact.getBelongCompanyId() == 0)
                    //    dmiContact.setBelongCompanyId(dmiContact.getBelongCompanyId());
                        if(insertContact(dmiContact)){
                            return ResultUtil.successMsg("新增联系人成功!");
                        }
                        return ResultUtil.errorExceptionMsg("新增联系人失败!");
                }

            } else {
                return ResultUtil.errorExceptionMsg("账号已存在,请更换账号");
            }
        }
    }

    /**
     *
     * @param: 根据ID，查看联系人详情
     * @return:
     * @Author Niting
     * @date: 2018/12/17
     */
    public Result getContact(int id) {
        DmiContact sqlResult = mapper.selectByPrimaryKey(id);
        return ResultUtil.success(sqlResult == null ? new DmiContact() : sqlResult);
    }

    /**
     * 失效联系人
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/15
     */
    public Result handleInvalid(int userId, String requestJson) {
        DmiContact dmiContact = JSON.parseObject(requestJson, DmiContact.class);

        // 设定失效
        dmiContact.setFlagAvailable(false);
        dmiContact.setUpdateTime(new Date());
        dmiContact.setUpdatePerson(userId);

        if (updateContact(dmiContact)){
            return ResultUtil.successMsg("联系人失效成功！");
        }
        return ResultUtil.errorExceptionMsg("联系人失效失败！");
    }

    /**
     * 删除联系人
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/15
     */
    public Result handleDelete(int userId, String requestJson) {
        DmiContact dmiContact = JSON.parseObject(requestJson, DmiContact.class);

        // 设定失效
        dmiContact.setFlagDeleted(true);
        dmiContact.setUpdateTime(new Date());
        dmiContact.setUpdatePerson(userId);

        if (updateContact(dmiContact)){
            return ResultUtil.successMsg("删除联系人成功！");
        }
        return ResultUtil.errorExceptionMsg("删除联系人失败！");
    }

    /**
     * 重置联系人密码
     *
     * @param userId
     * @param contact
     * @return
     */
    public Result resetPassword(int userId, DmiContact contact) {

        //先查询输入的旧密码是否正确

        String newPassWord = Encrypt.getMD5Str("123456");

        contact.setPassword(newPassWord);
        contact.setUpdatePerson(userId);
        contact.setUpdateTime(new Date());
        //mapper.updateByPrimaryKeySelective(contact);
        //return ResultUtil.successMsg("密码修改成功");

        if (updateContact(contact)){
            return ResultUtil.successMsg("重置密码修改成功！");
        }
        return ResultUtil.errorExceptionMsg("重置密码修改失败！");
    }

    /**
     * 更新联系人
     * @param dmiContact
     * @return
     * @Author:Niting
     * @Date:2018/12/15
     */
    private boolean updateContact(DmiContact dmiContact) {
        int effectRows = mapper.updateByPrimaryKeySelective(dmiContact);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 更新联系人信息验证
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/17
     */
    private Result updateContactCheck(DmiContact dmiContact) {
        List<DmiContact> list = mapper.selectByMobile(dmiContact.getMobile());
        List<DmiContact> accountList = mapper.selectAccount(dmiContact.getAccount());

        if(list.size()==0 && accountList.size()==0){

            mapper.updateByPrimaryKeySelectiveCheck(dmiContact);
            return ResultUtil.successMsg("更新成功！");

        }else{
            if(list.size()>1){
                return  ResultUtil.errorExceptionMsg("此手机号已绑定用户");
            }
            if(accountList.size()>1){
                return ResultUtil.errorExceptionMsg("账号已存在,请更换账号");
            }
            if(list.size()==1 &&  list.get(0).getId()!=dmiContact.getId()){
                return ResultUtil.errorExceptionMsg("此手机号已绑定用户");
            }
            if(accountList.size() ==1 && accountList.get(0).getId()!=dmiContact.getId()){
                return ResultUtil.errorExceptionMsg("账号已存在,请更换账号");
            }

            mapper.updateByPrimaryKeySelectiveCheck(dmiContact);
            return ResultUtil.successMsg("更新成功！");
        }
    }

    /**
     * 新增联系人
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/17
     */
    private boolean insertContact(DmiContact dmiContact) {
        int effectRows = mapper.insertSelective(dmiContact);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }

}
