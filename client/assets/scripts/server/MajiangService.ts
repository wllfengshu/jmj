import BaseService from "./BaseService";

export default class MajiangService extends BaseService {
     private static readonly serverName : string = "jmj-provider-majiang";
     public static readonly instance : MajiangService = new MajiangService();


}

