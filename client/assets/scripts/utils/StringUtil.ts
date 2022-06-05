
/**
 * 字符串工具类
 */
export default class StringUtil {

    /**
     * 是空
     * 
     * @param str 
     * @returns 
     */
    public static isBlack(str : string) : boolean {
        let result;
        if(null == str) {
            result = true;
        }
        if("" == str) {
            result = true;
        }
        if('' == str) {
            result = true;
        }
        return result;
    }

    /**
     * 不是空
     * 
     * @param str 
     * @returns 
     */
     public static isNotBlack(str : string) : boolean {
        return !StringUtil.isBlack(str);
    }
}
