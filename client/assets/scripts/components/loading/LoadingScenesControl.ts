const {ccclass, property} = cc._decorator;

@ccclass
export default class LoadingScenesControl extends cc.Component {

    /**
     * 界面展示的文字信息
     */
    @property(cc.Label)
    labelMsg : cc.Label = null;
    /**
     * 是否正在加载
     */
    @property
    isLoading : boolean = true;
    /**
     * 加载进度
     */
    @property
    progress : number = 0;

    onLoad() : void {
        this.labelMsg = this.node.getComponentInChildren(cc.Label);
    }

    start() : void {
        // 开始预加载当前场景
        this.startPreloading();
        // 当前场景加载完成
        this.onLoadComplete();
    }

    private startPreloading() {
        this.isLoading = true;
        this.labelMsg.string = "正在加载资源，请稍候";
        cc.director.preloadScene('loading', (completedCount, totalCount, item) => {
            this.progress = completedCount / totalCount;
        }, () => {
            cc.director.loadScene("login");
        });
    }
    
    private onLoadComplete() {
        this.isLoading = false;
        this.labelMsg.string = "准备进入游戏";
    }

    update(dt : number) : void{
        if(this.isLoading){
            this.labelMsg.string += Math.floor(this.progress * 100) + "%";   
        }else {
            let t = Math.floor(Date.now() / 1000) % 4;
            for(let i = 0; i < t; ++ i){
                this.labelMsg.string += '.';
            }
        }
    }
}
