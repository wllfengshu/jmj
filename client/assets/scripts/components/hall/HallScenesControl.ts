const {ccclass, property} = cc._decorator;

@ccclass
export default class HallScenesControl extends cc.Component {

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
