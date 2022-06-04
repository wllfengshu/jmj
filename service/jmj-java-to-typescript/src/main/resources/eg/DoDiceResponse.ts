interface DoDiceResponse extends GatewayResponse {
     // 投掷的骰子信息
     dices?: [];
     // 骰子数量
     diceNum?: number;
     // 点数之和
     sumPoint?: number;
     // 最小点数
     minPoint?: number;
     // 最大点数
     maxPoint?: number;
}
