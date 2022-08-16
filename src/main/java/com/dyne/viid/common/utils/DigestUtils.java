package com.dyne.viid.common.utils;


import cn.hutool.core.util.IdUtil;
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
        // Digest realm="dyne1400",nonce="a2d901442d904574a7dc2255d20c6096",qop="auth"
        //Digest username=%s, realm=%s, nonce=%s, uri="/VIID/System/Register", algorithm="MD5", response=%s
        DigestAuthInfo authInfoObject = getAuthInfoObject(auth);
        String realm = authInfoObject.getRealm();
        String nonce = authInfoObject.getNonce();
        String qop = authInfoObject.getQop();
        String HA1 = md5(StrUtil.format(TEMPLATE_THREE, username, realm, password));
        String HD = StrUtil.format(TEMPLATE_FOUR, nonce, authInfoObject.getNc(), authInfoObject.getCnonce(), authInfoObject.getQop());
        String HA2 = md5(StrUtil.format(TEMPLATE_TWO, "POST", "/VIID/System/Register"));
        log.info("md5 str : {}", StrUtil.format(TEMPLATE_THREE, HA1, HD, HA2));
        String responseValid = md5(StrUtil.format(TEMPLATE_THREE, HA1, HD, HA2));
        log.info("{}-{}-{}", HA1, HA2, HD);
        log.info("HD:{}", HD);
        String authorization = StrUtil.format("Digest username={}, realm={}, nonce={}, uri=\"/VIID/System/Register\", algorithm=\"MD5\",qop={},response={}", username, realm, nonce, qop, responseValid);
        log.info("authorization");
        return authorization;
    }

//    3339608253b9a9f919e7bafe080fc45c:76aed177548d458ea8808a68acda988e:null:null:auth:e981db7569f065fda647d8236af6f901
//    3339608253b9a9f919e7bafe080fc45c:e2aa711a61474a8fa8bdde0d39b412d0:null:null:null:e981db7569f065fda647d8236af6f901

//    HD:c6cdc1c4ed2e496ab3daf4bf3ed879a0:null:null:auth
//    HD:e2aa711a61474a8fa8bdde0d39b412d0:null:null:null
}
