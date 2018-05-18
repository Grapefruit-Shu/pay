package com.xishanju.payment.domain.service;

import com.xishanju.payment.domain.dto.RequestDto;
import com.xishanju.payment.vo.OrderVo;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 10:54 2018/5/17
 */
public interface WeChatTradeService {

    OrderVo wechatPrePay(RequestDto requestDto);
}
