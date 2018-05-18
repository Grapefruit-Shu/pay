package com.xishanju.payment.domain.service;

import com.xishanju.payment.domain.dto.RequestDto;
import com.xishanju.payment.vo.OrderVo;

public interface AliPayTradeService {

    OrderVo sendAliPayTradeService(RequestDto aliRequestDto);
}
