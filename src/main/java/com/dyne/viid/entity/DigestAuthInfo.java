package com.dyne.viid.entity;

import lombok.Data;

/**
 * Digest 鉴权消息
 */
@Data
public class DigestAuthInfo {
    /**
     * 系统用户名；客户端自行填充
     */
    private String username;
    /**
     * 领域；服务端通过WWW-Authenticate头返回内容可以自己随便定，但其目的是用于提示客户端当前是什么系统，
     * 所以规范来说应类似于“myhost@testrealm.com”的形式。
     */
    private String realm;
    /**
     * 服务端通过WWW-Authenticate头返回的随机数
     */
    private String nonce;
    /**
     * 请求接口或资源
     */
    private String uri;
    /**
     * 认证最主要的值，前面各字段除algorithm外全要参与该值的计算
     */
    private String response;
    /**
     * quality of protection，进一步限定response的计算方法，服务端通过WWW-Authenticate头返回
     */
    private String qop;
    /**
     * nonce count，用于标识进行请求的次数
     */
    private String nc;
    /**
     * client nonce，客户端生成的随机数
     */
    private String cnonce;
}
