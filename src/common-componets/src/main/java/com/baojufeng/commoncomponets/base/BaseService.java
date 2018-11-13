package com.baojufeng.commoncomponets.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Service基类
 *
 * @author zs
 * @version 2014-05-16
 */

public abstract class BaseService<D extends BaseMapper<T>, T extends BaseEntity> {

    /**
     * 持久层对象
     */
    @Autowired
    protected D dao;


    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    public T get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 添加
     *
     * @param entity
     * @return
     */
    public int save(T entity) {
        return dao.insertSelective(entity);
    }


    /**
     * 修改
     *
     * @param entity
     */

    public int update(T entity) {
        return dao.updateByPrimaryKeySelective(entity);
    }


    /**
     * 删除
     *
     * @param id
     */
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }


    /**
     * 查询所有数据
     *
     * @return
     */
    public List<T> findAll(T entity) {
        return dao.selectAll(entity);
    }


    /**
     * 批量删除
     *
     * @param ids
     */
    public void delete(Long[] ids) {
        dao.delete(ids);
    }

}
