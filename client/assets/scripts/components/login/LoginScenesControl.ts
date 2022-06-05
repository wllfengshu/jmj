import PlayerService from "../../server/PlayerService";
import ConstantUtil from "../../utils/ConstantUtil";

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
        cc.sys.localStorage.setItem(ConstantUtil.TOKEN, response.token);
        cc.sys.localStorage.setItem(ConstantUtil.LOGIN_INFO, response.playerPO);
        cc.director.loadScene("hall");
    }

    /**
     * 点击账号登陆
     */
    onBtnLoginLoginClicked() {
        this.node.getChildByName("alert_user_login").active = true;
    }

}
