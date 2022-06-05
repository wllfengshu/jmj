import HallService from "../../server/HallService";
import RoomService from "../../server/RoomService";
import StringUtil from "../../utils/StringUtil";

const {ccclass, property} = cc._decorator;

@ccclass
export default class CreateRoomControl extends cc.Component {

    /**
     * 点击确定创建房间
     */
    onBtnEnterClicked() {
        let password = this.node.getChildByName("need_password").getChildByName("input_password").getComponent(cc.EditBox);
        
        let request : CreateRoomRequest = {
            roomPassword :  password.string
        }
        let response = RoomService.instance.createRoom(request);
        if(null != response) {
            cc.director.loadScene("mjgame");
            return;
        }
    }
}
