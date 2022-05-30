import { json } from "stream/consumers";
import LogUtil from "./LogUtil";

const {ccclass, property} = cc._decorator;

/**
 * http工具类
 */
export default class HttpUtil {

    /**
     * 发送http的post请求
     * 
     * @param url 请求地址
     * @param params 参数
     */
    public static sendHttpPost(url : string, params : any) : string {
        LogUtil.info("HttpUtil.sendHttpPost", "url=" + url + ",request=" + JSON.stringify(params));
        let result = "";
        let xhr = cc.loader.getXMLHttpRequest();
        xhr.open("POST", url, false);
        xhr.setRequestHeader("Content-Type", "Application/json; charset=utf-8");
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
