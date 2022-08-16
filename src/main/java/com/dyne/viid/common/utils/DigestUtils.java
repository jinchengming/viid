package com.dyne.viid.common.utils;


import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.dyne.viid.entity.DigestAuthInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * DigestUtils
 */
@Slf4j
public class DigestUtils {

    private static final String TEMPLATE_TWO = "{}:{}";
    private static final String TEMPLATE_THREE = "{}:{}:{}";
    private static final String TEMPLATE_FOUR = "{}:{}:{}:{}";
    private static final String DIGEST_TEMPLATE = "Digest realm=\"{}\",nonce=\"{}\",qop=\"auth\"";

    public static String HEAD = "digest ";

    /**
     * 生成一个随机字符串
     *
     * @return
     */
    public static String generateToken() {
        return IdUtil.simpleUUID();
    }

    public static String md5(String data) {
        return SecureUtil.md5(data);
    }

    /**
     * 该方法用于将 Authorization 请求头的内容封装成一个对象。
     * <p>
     * Authorization 请求头的内容为：
     * Digest username="aaa", realm="no auth", nonce="b2b74be03ff44e1884ba0645bb961b53",
     * uri="/BootDemo/login", response="90aff948e6f2207d69ecedc5d39f6192", qop=auth,
     * nc=00000002, cnonce="eb73c2c68543faaa"
     */
    public static DigestAuthInfo getAuthInfoObject(String authStr) {
        if (authStr == null || authStr.length() <= HEAD.length()) {
            return null;
        }
        if (authStr.toLowerCase().indexOf(HEAD) >= 0) {
            // 截掉前缀 Digest
            authStr = authStr.substring(HEAD.length() - 1);
        }

        // 将双引号去掉
        authStr = authStr.replaceAll("\"", "");
        DigestAuthInfo digestAuthObject = new DigestAuthInfo();
        String[] authArray = new String[8];
        authArray = authStr.split(",");

        for (String auth : authArray) {
            String key = auth.substring(0, auth.indexOf("=")).trim();
            String value = auth.substring(auth.indexOf("=") + 1).trim();
            switch (key) {
                case "username":
                    digestAuthObject.setUsername(value);
                    break;
                case "realm":
                    digestAuthObject.setRealm(value);
                    break;
                case "nonce":
                    digestAuthObject.setNonce(value);
                    break;
                case "uri":
                    digestAuthObject.setUri(value);
                    break;
                case "response":
                    digestAuthObject.setResponse(value);
                    break;
                case "qop":
                    digestAuthObject.setQop(value);
                    break;
                case "nc":
                    digestAuthObject.setNc(value);
                    break;
                case "cnonce":
                    digestAuthObject.setCnonce(value);
                    break;
                default:
                    break;
            }
        }
        return digestAuthObject;
    }

    public static String generateAuthorization(String auth, String username, String password) {
        String cnonce = RandomUtil.randomString(8);
        DigestAuthInfo authInfoObject = getAuthInfoObject(auth);
        String realm = authInfoObject.getRealm();
        String nonce = authInfoObject.getNonce();
        log.info("ha1 : {}", StrUtil.format(TEMPLATE_THREE, username, realm, password));
        String HA1 = md5(StrUtil.format(TEMPLATE_THREE, username, realm, password));
        String HD = StrUtil.format(TEMPLATE_FOUR, nonce, "00000001", cnonce, authInfoObject.getQop());
        String HA2 = md5(StrUtil.format(TEMPLATE_TWO, "POST", "/VIID/System/Register"));
        log.info("md5 str : {}", StrUtil.format(TEMPLATE_THREE, HA1, HD, HA2));
        String responseValid = md5(StrUtil.format(TEMPLATE_THREE, HA1, HD, HA2));
        log.info("{}-{}-{}", HA1, HA2, HD);
        log.info("HD:{}", HD);
        String authorization = StrUtil.format("Digest username={}, realm={}, nonce={}, uri=/VIID/System/Register, algorithm=MD5,qop=auth, nc={}, cnonce={}, response={}", username, realm, nonce, "00000001", cnonce, responseValid);
        log.info("authorization");
        return authorization;
    }

    public static void main(String[] args) {
        // Digest username="chengmingceshi", realm="32010400", nonce="1b98bfe63bb9ad6dbac1498864e3e246", uri="/VIID/System/Register", algorithm="MD5", qop=auth, nc=00000001, cnonce="DlWzJ2CZ", response="e744917c563af5c234fc6c58045e6961"
        String s = generateAuthorization("Digest realm=32010400, nonce=1b98bfe63bb9ad6dbac1498864e3e246, qop=auth", "chengmingceshi", "chengmingceshi");
        System.out.println(s);
    }
}
