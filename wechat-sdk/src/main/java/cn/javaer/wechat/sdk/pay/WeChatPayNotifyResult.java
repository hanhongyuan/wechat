/*
 *    Copyright 2017 zhangpeng
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package cn.javaer.wechat.sdk.pay;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author zhangpeng
 */
@EqualsAndHashCode(callSuper = true)
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class WeChatPayNotifyResult extends AbstractWeChatPayResponse
{
    @XmlElement(name = "appid")
    private String appId;
    
    @XmlElement(name = "mch_id")
    private String mchId;
    
    @XmlElement(name = "device_info")
    private String deviceInfo;
    
    @XmlElement(name = "sign_type")
    private String signType;
    
    @XmlElement(name = "openid")
    private String openId;
    
    @XmlElement(name = "is_subscribe")
    private String isSubscribe;
    
    @XmlElement(name = "trade_type")
    private String tradeType;
    
    @XmlElement(name = "bank_type")
    private String bankType;
    
    @XmlElement(name = "settlement_total_fee")
    private String settlementTotalFee;
    
    @XmlElement(name = "fee_type")
    private String feeType;
    
    @XmlElement(name = "total_fee")
    private String totalFee;
    
    @XmlElement(name = "cash_fee")
    private String cashFee;
    
    @XmlElement(name = "cash_fee_type")
    private String cashFeeType;
    
    @XmlElement(name = "coupon_fee")
    private String couponFee;
    
    @XmlElement(name = "coupon_count")
    private String couponCount;
    
    // @XmlElement(name = "coupon_type_$n", required = false)
    // private String couponType;
    //
    // @XmlElement(name = "coupon_id_$n", required = false)
    // private String couponId;
    //
    // @XmlElement(name = "coupon_fee_$n", required = false)
    // private String couponFee;
    
    @XmlElement(name = "transaction_id")
    private String transactionId;
    
    @XmlElement(name = "out_trade_no")
    private String outTradeNo;
    
    @XmlElement(name = "attach")
    private String attach;
    
    @XmlElement(name = "time_end")
    private String timeEnd;
}
