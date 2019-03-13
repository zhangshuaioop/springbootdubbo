package com.company.springboot.service.trc;

import com.company.springboot.entity.ret.trc.GetDeviceOperate;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.entity.trc.TrcDeviceOperateLog;
import com.company.springboot.mapper.sys.SysCompanyUsersMapper;
import com.company.springboot.mapper.trc.TrcDeviceOperateLogMapper;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wujun
 * @create 2017年11月17日 14:31
 */
@Service
public class TrcDeviceOperateLogService {

    @Resource
    private TrcDeviceOperateLogMapper mapper;
    @Resource
    private Mapper dozer;
    @Resource
    private SysCompanyUsersMapper sysCompanyUsersMapper;

    public Result getDeviceOperate(int deviceId) {
        List<TrcDeviceOperateLog> sqlResult = mapper.selectDeviceOperate(deviceId);
        List<GetDeviceOperate> result = new ArrayList<GetDeviceOperate>();
        for (TrcDeviceOperateLog item : sqlResult) {
            GetDeviceOperate outItem = dozer.map(item, GetDeviceOperate.class);
            SysCompanyUsers user = sysCompanyUsersMapper.selectByPrimaryKey(item.getCreatePerson());
            if (user != null) {
                outItem.setOptPerson(user.getUsername());
            }
            result.add(outItem);
        }
        return ResultUtil.success(result);
    }
}
