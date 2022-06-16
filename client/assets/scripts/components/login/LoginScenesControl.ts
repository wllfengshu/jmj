import PlayerService from "../../server/PlayerService";
import ConstantUtil from "../../utils/ConstantUtil";
import LocalCacheUtil from "../../utils/LocalCacheUtil";

const {ccclass, property} = cc._decorator;

@ccclass
export default class LoginScenesControl extends cc.Component {

    /**
     * 点击游客登陆
     */
    onBtnTravelerLoginClicked() {
        let request : LoginRequest = {
            username : "admin",
            password : "admin"
        }
        let response = PlayerService.instance.login(request);
        LocalCacheUtil.setLocalStorage(ConstantUtil.TOKEN, response.token);
        LocalCacheUtil.setLocalStorage(ConstantUtil.LOGIN_INFO, response.playerPO);
        cc.director.loadScene("hall");
    }

    /**
     * 点击账号登陆
     */
    onBtnUserLoginClicked() {
        this.node.getChildByName("alert_user_login").active = true;
    }

}
