package com.dyne.viid.common.constant;


public class Constants {
    /**
     * 请求头token属性值
     */
    public static final String TOKEN_HEADER = "Authorization";

    /**
     * token过期时长，5分钟后过期  5 * 60 * 1000
     */
    public final static Long TOKEN_EXPIRE = 300L;

    /**
     * 用户token 3day
     */
    public final static Long USER_TOKEN_EXPIRE = 259200L;

//    /**
//     * token缓存，定时清理时间1s  1 * 1000
//     */
//    public final static Long TOKEN_CLEAN_DELAY = 1000L;

    /**
     * 请求头-用户身份，值为DeviceID的value
     */
    public static final String USER_IDENTIFY = "User-Identify";
    /**
     * 请求头-授权标识
     */
    public static final String AUTHORIZATION = "Authorization";
    /**
     * 第一次请求 nonce 的值
     */
    public static final String FIRST_NONCE = "00000001";

    public static final String MSG_EXCHANGE = "alarm-msg-1400";


    public static final String MSG_ROUTING_KEY = "alarm.msg";

    // redis 服务器缓存 视图库ID
    public static final String SERVER_kEY = "server::";

    // redis 认证缓存 注册保活
    public static final String KEEP_ALIVE = "keep::";

    public static final String USER_TOKEN = "user::";

    // 订阅缓存
    public static final String SUBSCRIBE = "sub::";

    // Serial number
    public static final String NOTIFY_SERIAL = "serial::notify";
}
