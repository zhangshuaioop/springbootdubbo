package com.company.springboot.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.company.springboot.controller.dmi.DmiCompanyInfoController;
import com.company.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.company.springboot.entity.cfg.CfgDeviceTypeCatalog;
import com.company.springboot.entity.dmi.DmiOrganization;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ray on 2017/1/4.
 */
public class DataFormatTransform {

    private static Logger log = Logger.getLogger(DmiCompanyInfoController.class);

    /**
     * 将Controller返回的Json进行跨域处理
     *
     * @param model
     * @return
     */
    public static Result changeModel2Json(Object model) {
        String json = JSON.toJSONString(model, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature
                .WriteNullBooleanAsFalse, SerializerFeature.WriteNullListAsEmpty);
        log.info("返回的Json为：" + json);
        return ResultUtil.success(json);
    }

    /**
     * 转换组织结构表，变成组织结构树形
     *
     * @param oList
     * @return
     */
    public static List<HashMap<String, Object>> getOrgTreeFromList(List<?> oList) {
        // 返回用的树形结构,第1层List
        List<HashMap<String, Object>> treeList = new ArrayList<HashMap<String, Object>>();

        // 原始List的长度
        int oSize;

        while (oList.size() > 0) {
            // 每次循环前检查列表的长度
            oSize = oList.size();

            for (int i = 0; i < oList.size(); i++) {

                int parentId_i = 0;
                int id_i = 0;
                if (oList.get(i) instanceof DmiOrganization) {
                    DmiOrganization dmiOrganization = (DmiOrganization) oList.get(i);
                    parentId_i = dmiOrganization.getParentId();
                    id_i = dmiOrganization.getId();
                }
                if (oList.get(i) instanceof CfgDeviceTypeCatalog) {
                    CfgDeviceTypeCatalog cfgDeviceTypeCatalog = (CfgDeviceTypeCatalog) oList.get(i);
                    parentId_i = cfgDeviceTypeCatalog.getParentId();
                    id_i = cfgDeviceTypeCatalog.getId();
                }
                if (oList.get(i) instanceof CfgCommunicationTypeCatalog) {
                    CfgCommunicationTypeCatalog cfgCommunicationTypeCatalog = (CfgCommunicationTypeCatalog) oList.get(i);
                    parentId_i = cfgCommunicationTypeCatalog.getParentId();
                    id_i = cfgCommunicationTypeCatalog.getId();
                }


                if (parentId_i == 0) {
                    // 第1层的map
                    HashMap<String, Object> firstMap;

                    int firstNodeId = id_i;

                    firstMap = TransBean2Map.copyObject2Map(oList.get(i));
                    oList.remove(i);

                    // 第2层List
                    List<HashMap<String, Object>> secondTreeList = new ArrayList<HashMap<String, Object>>();

                    // 在list中寻找parent_id=该节点的2级节点
                    for (int j = 0; j < oList.size(); j++) {

                        int parentId_j = 0;
                        int id_j = 0;
                        if (oList.get(j) instanceof DmiOrganization) {
                            DmiOrganization dmiOrganization = (DmiOrganization) oList.get(j);
                            parentId_j = dmiOrganization.getParentId();
                            id_j = dmiOrganization.getId();
                        }
                        if (oList.get(j) instanceof CfgDeviceTypeCatalog) {
                            CfgDeviceTypeCatalog cfgDeviceTypeCatalog = (CfgDeviceTypeCatalog) oList.get(j);
                            parentId_j = cfgDeviceTypeCatalog.getParentId();
                            id_j = cfgDeviceTypeCatalog.getId();
                        }
                        if (oList.get(j) instanceof CfgCommunicationTypeCatalog) {
                            CfgCommunicationTypeCatalog cfgCommunicationTypeCatalog = (CfgCommunicationTypeCatalog) oList.get(j);
                            parentId_j = cfgCommunicationTypeCatalog.getParentId();
                            id_j = cfgCommunicationTypeCatalog.getId();
                        }

                        if (parentId_j == firstNodeId) {
                            // 第2层的map
                            HashMap<String, Object> secondMap;

                            int secondNodeId = id_j;
                            secondMap = TransBean2Map.copyObject2Map(oList.get(j));
                            oList.remove(j);

                            // 第3层List
                            List<HashMap<String, Object>> thirdTreeList = new ArrayList<HashMap<String, Object>>();

                            //在list中寻找第3层的parent_id=该2级节点的节点
                            for (int k = j; k < oList.size(); k++) {

                                int parentId_k = 0;
                                if (oList.get(k) instanceof DmiOrganization) {
                                    DmiOrganization dmiOrganization = (DmiOrganization) oList.get(k);
                                    parentId_k = dmiOrganization.getParentId();
                                }
                                if (oList.get(k) instanceof CfgDeviceTypeCatalog) {
                                    CfgDeviceTypeCatalog cfgDeviceTypeCatalog = (CfgDeviceTypeCatalog) oList.get(k);
                                    parentId_k = cfgDeviceTypeCatalog.getParentId();
                                }
                                if (oList.get(k) instanceof CfgCommunicationTypeCatalog) {
                                    CfgCommunicationTypeCatalog cfgCommunicationTypeCatalog = (CfgCommunicationTypeCatalog) oList.get(k);
                                    parentId_k = cfgCommunicationTypeCatalog.getParentId();
                                }

                                if (parentId_k == secondNodeId) {
                                    // 第3层的map
                                    HashMap<String, Object> thirdMap = TransBean2Map.copyObject2Map(oList.get(k));

                                    thirdTreeList.add(thirdMap);

                                    // 指针k移除数据后，需要把指针往回拨一下
                                    oList.remove(k);
                                    k--;
                                }
                            }

                            // 判断thirdTreeList是否有数据，如果有的话在当前2级节点中添加子列表
                            if (thirdTreeList.size() > 0) {
                                secondMap.put("childNodeList", thirdTreeList);
                                secondMap.put("hasChildNode", true);
                            } else {
                                secondMap.put("hasChildNode", false);
                            }

                            // 当前2级节点及该节点下的3级节点数据遍历完毕，往2级列表中放入该2级map
                            secondTreeList.add(secondMap);
                            // 指针j移除数据后，需要把指针往回拨动
                            j--;
                        }

                    }

                    // 判断secondTreeList是否有数据，如果有的话在当前2级节点中添加子列表
                    if (secondTreeList.size() > 0) {
                        firstMap.put("childNodeList", secondTreeList);
                        firstMap.put("hasChildNode", true);
                    } else {
                        firstMap.put("hasChildNode", false);
                    }

                    // 当前1级节点及该节点下的2级节点数据遍历完毕，往1级列表中放入该1级map
                    treeList.add(firstMap);

                    // 指针j移除数据后，需要把指针往回拨动
                    i--;
                }
            }

            // 检查经过一次处理后，原始的List是否找到至少1个1级节点。
            // 如果找到，长度会不一致；如果找不到，长度就一致，此时说明list中并无1级节点，可以跳出循环
            if (oSize == oList.size()) break;
        }

        return treeList;
    }


}
