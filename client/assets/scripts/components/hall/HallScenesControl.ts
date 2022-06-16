import ConstantUtil from "../../utils/ConstantUtil";
import LocalCacheUtil from "../../utils/LocalCacheUtil";

const {ccclass, property} = cc._decorator;

@ccclass
export default class HallScenesControl extends cc.Component {

    protected start(): void {
        // 1设置个人信息
        let playerPO = LocalCacheUtil.getPlayerPO();
        this.node.getChildByName("top_left").getChildByName("headinfo").getChildByName("nickname").getComponent(cc.Label).string = playerPO.nickname;
        // 2
    }

    /**
     * 点击创建房间
     */
    onCreateRoomClicked() {
        this.node.getChildByName("create_room").active = true;
    }

    /**
     * 加入房间
     */
    onJoinRoomClicked() {
        this.node.getChildByName("join_room").active = true;
    }
}
