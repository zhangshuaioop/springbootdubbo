package com.company.springboot.service.fdp;

import com.company.springboot.entity.fdp.FdpFaultOrderProcess;
import com.company.springboot.entity.fdp.FdpFaultOrderRelatedCommProduct;
import com.company.springboot.mapper.fdp.FdpFaultOrderRelatedCommProductMapper;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpFaultOrderRelatedCommProductService
 * @ProjectName WaterDrop
 * @date 2019/1/11下午4:11
 */
@Service
public class FdpFaultOrderRelatedCommProductService {

    @Resource
    private FdpFaultOrderRelatedCommProductMapper mapper;

    public Result updateProductParm(FdpFaultOrderProcess process, int userId) {
        List<FdpFaultOrderRelatedCommProduct> commProduct = mapper.selectByProcessId(process.getId());

        //首先判断此故障单新增时是否选择过路线
        if (commProduct != null) {

            mapper.deleteByProcess(process);
            //先删除原来新增故障单时选择的线路（falgDelete改为ture）

            if (process.getProduct() != null) {

                List<FdpFaultOrderRelatedCommProduct> commProductList = process.getProduct();

                List<FdpFaultOrderRelatedCommProduct> productList = mapper.selectProductList(process.getId());

                //新增之前未选择的设备
                for (FdpFaultOrderRelatedCommProduct item : commProductList) {
                    boolean flag = false;
                    for (FdpFaultOrderRelatedCommProduct pro : productList) {
                        //数据库中没有deviceid 则新增
                        if (item.getStoreCommProductId().equals(pro.getStoreCommProductId())) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag == false) {
                        FdpFaultOrderRelatedCommProduct product = new FdpFaultOrderRelatedCommProduct();
                        product.setCommCatalogId(item.getCommCatalogId());
                        product.setStoreCommProductId(item.getStoreCommProductId());
                        product.setFaultOrderProcessId(process.getId());
                        product.setStoreId(process.getStoreId());
                        product.setUpdateTime(new Date());
                        product.setFlagDeleted(false);
                        product.setUpdatePerson(userId);
                        mapper.insertSelective(product);
                    }
                }
            }

        } else {
            if (process.getProduct() != null) {

                List<FdpFaultOrderRelatedCommProduct> commProductList = process.getProduct();

                List<FdpFaultOrderRelatedCommProduct> productList = mapper.selectProductList(process.getId());

                //新增之前未选择的设备
                for (FdpFaultOrderRelatedCommProduct item : commProductList) {
                    boolean flag = false;
                    for (FdpFaultOrderRelatedCommProduct pro : productList) {
                        //数据库中没有deviceid 则新增
                        if (item.getStoreCommProductId().equals(pro.getStoreCommProductId())) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag == false) {
                        FdpFaultOrderRelatedCommProduct product = new FdpFaultOrderRelatedCommProduct();
                        product.setCommCatalogId(item.getCommCatalogId());
                        product.setStoreCommProductId(item.getStoreCommProductId());
                        product.setFaultOrderProcessId(process.getId());
                        product.setStoreId(process.getStoreId());
                        product.setUpdateTime(new Date());
                        product.setFlagDeleted(false);
                        product.setUpdatePerson(userId);
                        mapper.insertSelective(product);
                    }
                }
            }

        }

        return ResultUtil.success();
    }
}
