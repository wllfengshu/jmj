import PlayerService from "../../server/PlayerService";

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
        cc.sys.localStorage.setItem("token", response.token);
        cc.sys.localStorage.setItem("playerPO", response.playerPO);
        cc.director.loadScene("hall");
    }

    /**
     * 点击账号登陆
     */
    onBtnLoginLoginClicked() {
        this.node.getChildByName("alert_user_login").active = true;
    }

}
