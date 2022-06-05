/**
 * 常量集合
 */
 export default class ConstantUtil {

    /**
     * 请求的地址前缀（所有接口都必须通过网关调用）
     */
     public static readonly httpDomain : string = "http://localhost:8001/gateway/";
    
    /**
     * 登陆凭证的key
     */
     public static readonly TOKEN : string = "token";

    /**
     * 登陆的用户信息
     */
     public static readonly LOGIN_INFO : string = "loginInfo";

 }