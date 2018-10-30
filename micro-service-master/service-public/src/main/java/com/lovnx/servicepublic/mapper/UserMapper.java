package com.lovnx.servicepublic.mapper;


import com.github.pagehelper.Page;
import com.lovnx.commoncomponets.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 分页查询数据
     * @return
     */
    Page<User> findByPage();
}