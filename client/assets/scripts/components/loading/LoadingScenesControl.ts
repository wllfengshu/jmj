
const {ccclass, property} = cc._decorator;

@ccclass
export default class LoadingScenesControl extends cc.Component {

    protected start(): void {
        cc.director.loadScene("login");
    }
}
