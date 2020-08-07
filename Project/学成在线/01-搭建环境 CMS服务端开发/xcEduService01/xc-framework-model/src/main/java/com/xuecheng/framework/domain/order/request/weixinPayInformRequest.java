package com.xuecheng.framework.domain.order.request;

import com.xuecheng.framework.model.request.RequestData;
import lombok.Data;

/**
 * Created by mrt on 2018/3/27.
 */
@Data
public class weixinPayInformRequest extends RequestData {

//    返回状态码	（SUCCESS/FAIL此字段是通信标识）
    String return_code;
//    返回信息
    String return_msg;
//    公众账号ID
    String appid;
//    商户号
    String mch_id;
//    随机字符串
    String nonce_str;
//    签名
    String sign;
//    签名类型
    String sign_type;
//    业务结果	（SUCCESS/FAIL）
    String result_code;
//    错误代码
    String err_code;
//    用户标识	（用户在商户appid下的唯一标识）
    String openid;
//    交易类型	（JSAPI、NATIVE、APP）
    String trade_type;
//    付款银行
    String bank_type;
//    订单金额
    String total_fee;
//    现金支付金额
    String cash_fee;
//    微信支付订单号
    String transaction_id;
//    商户订单号
    String out_trade_no;
//    支付完成时间
    String time_end;
}
