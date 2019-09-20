package com.example.componets.base;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;


/**
 * baseEntity
 * @param <T>
 */
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 自定义SQL（SQL标识，SQL内容）
     */
    protected Map<String, String> sqlMap;

    @ApiModelProperty(value = "每页显示数", example = "1", required = true)
    protected Integer pageSize;

    @ApiModelProperty(value = "页码", example = "1", required = true)
    protected Integer pageNum;


    public Map<String, String> getSqlMap() {
        return sqlMap;
    }

    public void setSqlMap(Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
