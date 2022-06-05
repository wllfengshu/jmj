
/**
 * 日志工具类（控制台）
 */
export default class LogUtil {

    /**
     * info
     */
    public static info(title : string, content : any) {
        console.info(LogUtil.giveResult(title, content));
    }

    /**
     * error
     */
    public static error(title : string, content : any) {
        console.error(LogUtil.giveResult(title, content));
    }

    private static giveResult(title : string, content : any) : string{
        let result = title;
        if(typeof content === "string") {
            result += ":" + content;
        }else {
            result += ":" + JSON.stringify(content);
        }
        return result;
    }
}
