package com.help.helpme.base;

import java.io.Serializable;
import java.util.List;

/**
 * @description: treegrid树形表格基础对象，后续的该类型的对象均继承该对象
 * @author: zhangshuai
 * @create: 2018-11-07 16:36
 */
public class BaseTreeGrid implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -9189631784252440402L;

    public Long id;//节点id

    public Long parentId;//节点父id

    public String icon;//节点样式，默认即可

    public Boolean leaf = true;//是否为叶子节点，true表示是叶子节点，false表示不是叶子节点

    public Boolean expanded = true; //是否展开，默认true,展开

    public List<BaseTreeGrid> children;//孩子节点

    public BaseTreeGrid() {

    }

    public BaseTreeGrid(Long id, Long parentId) {
        this.id=id;
        this.parentId=parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }



    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public List<BaseTreeGrid> getChildren() {
        return children;
    }

    public void setChildren(List<BaseTreeGrid> children) {
        this.children = children;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "BaseTreeGrid{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", icon='" + icon + '\'' +
                ", leaf=" + leaf +
                ", expanded=" + expanded +
                ", children=" + children +
                '}';
    }
}
