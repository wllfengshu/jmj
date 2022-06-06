import HallService from "../../server/HallService";
import RoomService from "../../server/RoomService";
import StringUtil from "../../utils/StringUtil";

const {ccclass, property} = cc._decorator;

@ccclass
export default class JoinRoomControl extends cc.Component {

    /**
     * 对应弹框里面的6位数字
     */
    private nums : cc.Label[] = new Array(6);
    /**
     * 输入的下标
     */
    private inputIndex : number = 0;
    /**
     * 提示信息
     */
    private msgLable : cc.Label = this.node.getChildByName("popup_scene").getChildByName("msg_label").getComponent(cc.Label);

    protected start(): void {
        this.nums[0] = this.node.getChildByName("N0").getComponent(cc.Label);
        this.nums[1] = this.node.getChildByName("N1").getComponent(cc.Label);
        this.nums[2] = this.node.getChildByName("N2").getComponent(cc.Label);
        this.nums[3] = this.node.getChildByName("N3").getComponent(cc.Label);
        this.nums[4] = this.node.getChildByName("N4").getComponent(cc.Label);
        this.nums[5] = this.node.getChildByName("N5").getComponent(cc.Label);
    }

    private onInputFinished(roomIdInput){
        let request = {
            roomId : roomIdInput
        }
        let response = RoomService.instance.joinRoom(request);
        if(response.joinRoomStatusEnum == JoinRoomStatusEnum.NORMAL) {
            cc.director.loadScene("mjgame");
            return;
        }

        let content;
        if(response.joinRoomStatusEnum == JoinRoomStatusEnum.NON_EXISTENT) {
            content = "房间["+ roomIdInput +"]不存在，请重新输入!";
        } else if(response.joinRoomStatusEnum == JoinRoomStatusEnum.FULL) {
            content = "房间["+ roomIdInput + "]已满!";
        }
        this.msgLable.string = content;
        this.onResetClicked();
    }
    
    private onInput(num){
        if(this.inputIndex >= this.nums.length){
            return;
        }
        this.nums[this.inputIndex].string = num;
        this.inputIndex += 1;
        
        if(this.inputIndex == this.nums.length){
            var roomId = this.parseRoomId();
            this.onInputFinished(roomId);
        }
    }

    private parseRoomId(){
        var str = "";
        for(var i = 0; i < this.nums.length; ++i){
            str += this.nums[i].string;
        }
        return str;
    }
    
    onN0Clicked(){
        this.onInput(0);
    }
    onN1Clicked(){
        this.onInput(1);  
    }
    onN2Clicked(){
        this.onInput(2);
    }
    onN3Clicked(){
        this.onInput(3);
    }
    onN4Clicked(){
        this.onInput(4);
    }
    onN5Clicked(){
        this.onInput(5);
    }
    onN6Clicked(){
        this.onInput(6);
    }
    onN7Clicked(){
        this.onInput(7);
    }
    onN8Clicked(){
        this.onInput(8);
    }
    onN9Clicked(){
        this.onInput(9);
    }
    onResetClicked(){
        for(var i = 0; i < this.nums.length; ++i){
            this.nums[i].string = "";
        }
        this.inputIndex = 0;
    }
    onDelClicked(){
        if(this.inputIndex > 0){
            this.inputIndex -= 1;
            this.nums[this.inputIndex].string = "";
        }
    }
    onCloseClicked(){
        this.node.active = false;
    }
}
