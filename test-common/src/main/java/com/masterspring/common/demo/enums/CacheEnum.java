package com.masterspring.common.demo.enums;

public enum CacheEnum {
	PAY("pay","支付"),
	REFUND("refund","退款"),
    AWARD("award","发奖"),
	BETTING("betting-%s","投注"),
	DRAWTICKET("drawticket","出票信息"),
    API_AGENT_RECEIVE("apiAgentReceive", "代理商回调接口"),
    API_AGENT_RECEIVE_ORDER_STATUS("apiAgentReceiveOrderStatus", "代理商回调接口订单状态"),
    SC("sc","异常信息"),
	ISSUE("issue","彩期"),
	WINNER("winner","中奖名单"),
	DEFAULT("default","默认"),
	EXCEPTION("execption","运行错误"),
    DELETE_ORDER("deleteOrder","删除订单"),
    BUY_ORDER("buyOrder","下单验证"),
    JXFC("jxfc","江西福彩接口"),
    LYCBETTING("lycBetting","乐亿彩投注"),
    LYCWINNER("lycWinner","乐亿彩中奖名单"),
    LYCPRIZELEVEL("lycPrize","乐亿彩奖等"),
    LYCORDERSTATUS("lycOderStatus","乐亿彩出票查询"),
    LYCISSUE("lycIssue","乐亿彩同步期"),
    ACTIVITY("activity","活动"),
    SAFE("safe","订单管控"),
    MIGRATION("migration", "数据迁移"),
    CACHELOG("cacheLog", "缓存"),
    ERPORDER("erpOrder", "ERP订单相关"),
    COMMISSION("commission", "结算计费"),
    SZC_NETEXCEPTION("SZC_NETEXCEPTION","数字彩调用接口方网络异常"),

    JC_TOUZHU("JC_TOUZHU", "竞彩投注"),
    JC_PAIJIANG("JC_PAIJIANG", "竞彩派奖"),
    JC_CHUPIAO("JC_CHUPIAO", "竞彩出票"),
    JC_WINNER("JC_WINNER", "竞彩中奖"),
    JC_SUANJIANG("JC_SUANJIANG", "竞彩算奖"),
    JC_SUANJIANG_CHECK("JC_SUANJIANG_CHECK", "竞彩算奖检查"),
    JC_QICI("JC_QICI", "竞彩期次"),
    JC_INTERFACE_RESPONSE("JC_INTERFACE_RESPONSE", "竞彩接口返回的response"),
    JC_WEB_COMMON("JC_WEB_COMMON", "竞彩前台common (日常业务日志)"),
    JC_MAN_COMMON("JC_MAN_COMMON", "竞彩后台common (日常业务日志)"),

    FIND_DATA("FIND_DATA", "前台查询竞彩期"),
    DC_QICI("DC_QICI", "单场期次"),
    DC_QICI_PEILV("DC_QICI_PEILV", "单场更新期赔率"),
    DC_TOUZHU("DC_TOUZHU", "单场投注"),
    DC_CHUPIAO("DC_CHUPIAO", "单场出票"),
    DC_SIAGUO("DC_SAIGUO", "单场获取赛果"),
    DC_SAIHOU_PEILV("DC_SAIHOU_PEILV", "单场获取赛后赔率"),
    DC_WINNER("DC_WINNER", "单场中奖"),
    DC_SUANJIANG("DC_SUANJIANG", "单场算奖"),
    DC_COMMUNICATION("DC_COMMUNICATION", "单场通信日志"),
    DC_ISSUE_COMMUNICATION("DC_ISSUE_COMMUNICATION", "期信息日志"),
    DC_ISSUESP_COMMUNICATION("DC_ISSUESP_COMMUNICATION", "期次赔率日志"),
    DC_BET_COMMUNICATION("DC_BET_COMMUNICATION", "投注日志"),
    DC_EXCEPTION_COMMUNICATION("DC_EXCEPTION_COMMUNICATION", "异常日志"),
    DC_BATCHTRADE_COMMUNICATION("DC_BATCHTRADE_COMMUNICATION", "批量出票日志"),
    DC_LOTTERYPRIZES_COMMUNICATION("DC_LOTTERYPRIZES_COMMUNICATION", "查询中奖日志"),
    DC_GAMESP_COMMUNICATION("DC_GAMESP_COMMUNICATION", "获取赛果日志"),
    
    JCH_BET_COMMUNICATION("JCH_BET_COMMUNICATION","竞彩混合过关投注日志"),
    JCH_TRADE_COMMUNICATION("JCH_TRADE_COMMUNICATION","竞彩混合过关出票日志"),
    JCH_PRIZES_COMMUNICATION("JCH_PRIZES_COMMUNICATION","竞彩混合过关中奖日志"),

	JJC_DATA_STAT("JJC_DATA_STAT","竞技彩数据统计日志"),
	SOLR("solr","solr日志"),
	MQ("mq","MQ消息");
	
	private String key;
    private String value;
    public String format(Object... values) {
        return String.format(key, values[0],values[1]);
    }

    CacheEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValue(String key) {
        for (CacheEnum ft : CacheEnum.values()) {
            if (ft.getKey().equals(key)) {
                return ft.getValue();
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
