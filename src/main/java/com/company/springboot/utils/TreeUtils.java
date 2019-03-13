package com.company.springboot.utils;

import com.company.springboot.base.BaseTreeGrid;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 将记录list转化为树形list
 * @author: zhangshuai
 * @create: 2018-11-07 16:35
 */
public class TreeUtils {


    /**
     * 格式化list为树形list
     * @param list
     * @param flag true 表示全部展开，其他 表示不展开
     * @return
     */
    public static <T extends BaseTreeGrid> List<T> formatTree(List<T> list, Boolean flag) {

        List<T> nodeList = new ArrayList<T>();
        for(T node1 : list){
            boolean mark = false;
            for(T node2 : list){
                if(node1.getParentId()!=null && node1.getParentId().equals(node2.getId())){
                    node2.setLeaf(false);
                    mark = true;
                    if(node2.getChildren() == null) {
                        node2.setChildren(new ArrayList<BaseTreeGrid>());
                    }
                    node2.getChildren().add(node1);
                    if (flag) {
                        //默认已经全部展开
                    } else{
                        node2.setExpand(false);
                    }
                    break;
                }
            }
            if(!mark){
                nodeList.add(node1);
                if (flag) {
                    //默认已经全部展开
                } else{
                    node1.setExpand(false);
                }
            }
        }
        return nodeList;
    }






//权限树针对vue自定义
    public static <T extends BaseTreeGrid> List<T> permissionTree(List<T> list, Boolean flag) {

        List<T> nodeList = new ArrayList<T>();
        for(T node1 : list){
            boolean mark = false;
            for(T node2 : list){
                if(node1.getParentId()!=null && node1.getParentId().equals(node2.getId())){
                    node2.setLeaf(false);
                    mark = true;
                    if(node2.getChildren() == null) {
                        node2.setChildren(new ArrayList<BaseTreeGrid>());
                        node2.setChecked(false);   //父级默认不选中
                    }
                    node2.getChildren().add(node1);
                    if (flag) {
                        //默认已经全部展开
                    } else{
                        node2.setExpand(false);
                    }
                    break;
                }
            }
            if(!mark){
                node1.setChecked(false); //父级默认不选中
                nodeList.add(node1);
                if (flag) {
                    //默认已经全部展开
                } else{
                    node1.setExpand(false);
                }
            }
        }
        return nodeList;
    }

}
