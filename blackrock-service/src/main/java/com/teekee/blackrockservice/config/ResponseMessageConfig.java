package com.teekee.blackrockservice.config;

/**
 * Created by ray on 2017/1/5.
 * 用户存放返回用提示信息
 */
public class ResponseMessageConfig {
    // 公用
    public static String ILLEGAL_REQUEST = "当前请求非法，请勿再次尝试！";
    public static String INSERT_SUCCESS = "新增成功！";
    public static String UPDATE_SUCCESS = "更新成功！";
    public static String INVALID_SUCCESS = "失效成功！";
    public static String DELETE_SUCCESS = "删除成功！";
    public static String ILLEGAL_REQUEST_CODE = "403";
    public static String COMMON_SUCCESS_CODE = "200";
    public static String COMMON_FAILURE_CODE = "500";

    // 营业执照相关
    public static String BIZ_LIC_SET_DELETE_ERROR = "不能删除该营业执照，因为目前正和其他公司或者组织绑定";

    // 品牌相关
    public static String BRAND_SET_DELETE_ERROR = "不能删除该品牌，因为目前正和门店绑定";

    // 联系人和公司关系
    public static String CCR_SET_DELETE_ERROR_LASTE = "不能删除联系人和公司关系，因为已经是最后一个联系人！";
    public static String CCR_SET_DELETE_ERROR = "不能新增该联系人和公司关系，因为已存在该关系";

    // 系统用户
    public static String LOGIN_SUCCESS = "登录成功！";
    public static String LOGIN_FAILURE = "用户名密码验证失败！";
    public static String AUTHENTICATION_FAILURE = "访问接口身份验证失败，请重新登录后尝试再次调用该接口！";

    // 系统用户登出
    public static String LOGOUT_SUCCESS = "登出成功！";

    // 联系人和门店关系
    public static String CSR_SET_DELETE_ERROR = "不能新增该联系人和门店关系，因为已存在该关系";

    // 角色
    public static String SYS_ROLE_INSERT_FAILURE = "新增角色失败，因为角色名已经存在！";
    public static String SYS_ROLE_UPDATE_FAILURE = "编辑角色失败，因为角色名已经存在！";

    // 上传文件
    public static String UPLOAD_MODEL_TYPE_FAILURE = "文件上传失败，原因是：不支持上传该文件类型或上传的模块不存在";

    // 新增工单记录
    public static String ORDER_OPERATION_INSERT_FAILURE_ORDER_NOT_EXIST = "工单不存在，新增操作记录失败！";
    public static String ORDER_OPERATION_INSERT_FAILURE_NOT_NEED_CONFIRM = "当前状态不是完工待确认，新增操作记录（完工）失败！";
    public static String ORDER_OPERATION_INSERT_FAILURE_ARTISAN_NULL = "新增工单操作记录失败，技术人员不能为空！";
    public static String ORDER_OPERATION_INSERT_FAILURE_ARTISAN_ERROR = "新增工单操作记录失败，技术人员不能转技术！";

    // 新增产品
    public static String COMM_PRODUCT_INSERT_FAILURE_BRAND = "新增产品失败-该产品的通信品牌与套餐中的其他产品不一致！";

    // 新增套餐
    public static String MARKETING_CAMPAIGN_UPDATE_FAILURE_ID_NULL = "更新套餐失败-套餐ID不能为空！";

    // 套餐中添加产品
    public static String MARKETING_CAMPAIGN_ADD_PRODUCT_SUCCESS = "添加产品-成功！";
    public static String MARKETING_CAMPAIGN_ADD_PRODUCT_FAILURE_BRAND = "添加产品失败-该产品的通信品牌与套餐中产品的通信品牌不一致！";

    // 套餐中移除产品
    public static String MARKETING_CAMPAIGN_REMOVE_PRODUCT_SUCCESS = "移除产品-成功！";

    // 放弃新增所申请的楼宇
    public static String BUILDING_ABANDON_SUCCESS = "放弃新增所申请的楼宇-成功！";

    // 申请楼
    public static String BUILDING_APPLY_REPEAT = "操作失败，该楼宇已经被处理，不得再次处理！";

    // 新增/编辑地址
    public static String BUILDING_ADDRESS_NULL = "操作失败，楼宇地址仅剩一个，不能继续删除楼宇地址！";

    // 新增编辑系统账户
    public static String SYS_USER_ACCOUNT_REPEAT = "操作失败，该账号已经存在!";

    // 移除角色
    public static String REMOVE_ROLE_FAILURE = "操作失败（未知错误），请联系管理员";

    // 添加权限
    public static String ADD_PERMISSION_SUCCESS = "配置权限-成功！";

}
