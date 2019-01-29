package com.teekee.commoncomponets.utils;

import redis.clients.jedis.Jedis;

/**
 * @description: 分布式加锁
 * @author: zhangshuai
 * @create: 2018-11-23 22:02
 */
public class RedisLockUp {

    private static final String LOCK_SUCCESS = "OK";

    //NX，是SET IF NOT EXIST，即当key不存在时，进行set操作；若key已经存在，则不做任何操作
    private static final String SET_IF_NOT_EXIST = "NX";

    //PX，给这个key加一个过期的设置
    private static final String SET_WITH_EXPIRE_TIME = "PX";



    /**

     * 尝试获取分布式锁

     * @param jedis Redis客户端

     * @param lockKey 锁

     * @param requestId 请求标识

     * @param expireTime 超期时间

     * @return 是否获取成功

     */

    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {



        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);



        if (LOCK_SUCCESS.equals(result)) {

            return true;

        }

        return false;



    }

}
