import LoginRequest from "../../server/model/LoginRequest";
import PlayerServer from "../../server/PlayerServer";
import StringUtil from "../../utils/StringUtil";

const {ccclass, property} = cc._decorator;

@ccclass
export default class UserLoginControl extends cc.Component {

    /**
     * 点击确认
     */
    onBtnEnterClicked() {
        let alertMsg = this.node.getChildByName("alert_msg").getComponent(cc.Label);
        let username = this.node.getChildByName("username").getComponent(cc.EditBox);
        let password = this.node.getChildByName("password").getComponent(cc.EditBox);
        if(StringUtil.isBlack(username.string) || StringUtil.isBlack(password.string)) {
            alertMsg.string = "用户名或密码为空";
            return;
        }
        
        let request = new LoginRequest();
        request.username = username.string;
        request.password = password.string;
        let response = PlayerServer.instance.login(request);
        if(null != response && null != response.token) {
            cc.sys.localStorage.setItem("token", response.token);
            cc.sys.localStorage.setItem("playerPO", response.playerPO);
            cc.director.loadScene("hall");
            return;
        }
        alertMsg.string = "用户名或密码错误";
        username.string = "";
        password.string = "";
    }

    /**
     * 点击取消
     */
    onBtnCancelClicked() {
        this.node.active = false;
        let alertMsg = this.node.getChildByName("alert_msg").getComponent(cc.Label);
        alertMsg.string = "登陆";
    }
}
