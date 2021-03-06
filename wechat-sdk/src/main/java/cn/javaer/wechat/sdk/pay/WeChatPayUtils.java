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

import org.apache.commons.codec.digest.DigestUtils;
import retrofit2.Response;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author zhangpeng
 */
public class WeChatPayUtils
{
    public static void checkAndSignRequest(final WeChatPayUnifiedOrderRequest request, final String mchKey)
    {
        if ("NATIVE".equals(request.getTradeType()) && (request.getProductId() == null || request.getProductId().isEmpty()))
        {
            throw new IllegalArgumentException("When 'TradeType' is 'NATIVE', 'ProductId' must has value.");
        }
        request.setSign(WeChatPayUtils.sign(request, mchKey));
    }
    
    public static String sign(final Object data, final String key)
    {
        
        final Class<?> clazz = data.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        final Map<String, String> dataMap = new TreeMap<>();
        
        try
        {
            for (final Field field : fields)
            {
                field.setAccessible(true);
                final Object objVal;
                objVal = field.get(data);
                
                if (null != objVal && !objVal.toString().isEmpty())
                {
                    final String dataKey = Optional.ofNullable(field.getAnnotation(XmlElement.class))
                        .map(XmlElement::name)
                        .orElse(field.getName());
                    if (!"sign".equals(dataKey))
                    {
                        dataMap.put(dataKey, objVal.toString());
                    }
                }
            }
        } catch (final IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }
        final StringBuilder sb = new StringBuilder();
        
        for (final Map.Entry<String, String> entry : dataMap.entrySet())
        {
            sb.append(entry.getKey()).append('=').append(entry.getValue()).append('&');
        }
        sb.append("key").append('=').append(key);
        return DigestUtils.md5Hex(sb.toString()).toUpperCase();
    }
    
    public static void checkResponse(final Response response)
    {
        if (!response.isSuccessful())
        {
            throw new WeChatPayException("Http response error, response:" + response.toString());
        }
    }
    
    public static void checkResponseBody(final AbstractWeChatPayResponse response, final String mchKey)
    {
        if (null == response)
        {
            throw new WeChatPayException("WeChat pay response is null");
        }
        if (!response.getSign().equals(WeChatPayUtils.sign(response, mchKey)))
        {
            throw new WeChatPayException("WeChat pay response 'sign' error");
        }
        if (!"SUCCESS".equals(response.getReturnCode()))
        {
            throw new WeChatPayException("WeChat pay response error, response:" + response.toString());
        }
        if (!"SUCCESS".equals(response.getResultCode()))
        {
            throw new WeChatPayException("WeChat pay response error, response:" + response.toString());
        }
    }
    
}
