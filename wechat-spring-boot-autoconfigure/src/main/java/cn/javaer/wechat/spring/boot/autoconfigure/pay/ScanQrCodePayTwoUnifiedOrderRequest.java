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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * 扫码支付模式二，请求参数
 *
 * @author zhangpeng
 */
@SuppressWarnings("WeakerAccess")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScanQrCodePayTwoUnifiedOrderRequest
{
    @NonNull private String  body;
    @NonNull private String  outTradeNo;
    @NonNull private Integer totalFee;
    @NonNull private String  productId;
}
