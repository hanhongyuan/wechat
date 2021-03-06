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

package cn.javaer.wechat.spring.boot.autoconfigure.pay;

import cn.javaer.wechat.sdk.pay.WeChatPayException;

/**
 * 微信支付服务
 *
 * @author zhangpeng
 */
public interface WeChatPayService
{
    /**
     * 微信支付-扫码支付-模式二, 统一下单
     *
     * @param unifiedOrderRequest 扫码支付-模式二 请求，在官方原始api上尽可能最少化
     * @return 响应结果已处理掉官方的return和result的异常流程
     * @throws WeChatPayException 支付接口调用失败
     */
    ScanQrCodePayTwoUnifiedOrderResponse unifiedOrder(
        ScanQrCodePayTwoUnifiedOrderRequest unifiedOrderRequest) throws WeChatPayException;
}
