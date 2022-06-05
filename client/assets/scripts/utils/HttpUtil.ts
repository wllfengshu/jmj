import ConstantUtil from "./ConstantUtil";
import LogUtil from "./LogUtil";
import StringUtil from "./StringUtil";

/**
 * http工具类
 */
export default class HttpUtil {

    /**
     * 发送http的post请求
     * 
     * @param url 请求地址
     * @param params 参数
     * @param token 登陆凭证（可选，将放到请求头中）
     */
    public static sendHttpPost(url : string, params : any, token ?: string) : string {
        LogUtil.info("HttpUtil.sendHttpPost", "url=" + url + ",request=" + JSON.stringify(params) + ",token=" + token);
        let result = "";
        let xhr = cc.loader.getXMLHttpRequest();
        xhr.open("POST", url, false);
        xhr.setRequestHeader("Content-Type", "Application/json; charset=utf-8");
        if(StringUtil.isNotBlack(token)) {
            xhr.setRequestHeader(ConstantUtil.TOKEN, token);
        }
        xhr.onreadystatechange = ()=> {
            if(xhr.readyState === 4
                && xhr.status >= 200
                && xhr.status < 300) {
                result = xhr.responseText;
                LogUtil.info("HttpUtil.sendHttpPost", "http success, response=" + result);
            }else {
                LogUtil.error("HttpUtil.sendHttpPost", "http fail");
            }
        };
        xhr.send(JSON.stringify(params));
        return result;
    }

}
