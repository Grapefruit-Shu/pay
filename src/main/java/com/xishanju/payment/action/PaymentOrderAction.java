package com.xishanju.payment.action;

import com.xishanju.payment.common.Result;
import com.xishanju.payment.common.ResultSet;
import com.xishanju.payment.common.RetCode;
import com.xishanju.payment.domain.dto.RequestDto;
import com.xishanju.payment.domain.enums.ChannelEnums;
import com.xishanju.payment.domain.service.AliPayTradeService;
import com.xishanju.payment.domain.service.WeChatTradeService;
import com.xishanju.payment.dto.OrderDetailDto;
import com.xishanju.payment.vo.OrderVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shuyong
 * @date 2018/5/16 16:54
 */
@RestController
@RequestMapping("/payment/order")
public class PaymentOrderAction {

    @Resource
    private AliPayTradeService aliPayTradeService;

    @Resource
    private WeChatTradeService weChatTradeService;

    @RequestMapping(value = "/tradePay.do" , method = RequestMethod.POST)
    public ResultSet<OrderVo> tradePay(@RequestParam("order_no") String order_no, @RequestParam("amount") String amount, @RequestParam("app") String app,
                              @RequestParam("channel") String channel, @RequestParam("currency") String currency, @RequestParam("client_ip") String client_ip,
                              @RequestParam("subject") String subject, @RequestParam("body") String body, @RequestParam("trade_type") String trade_type) {
        RequestDto requestDto = new RequestDto();
        ResultSet<OrderVo> resultSet = new ResultSet<OrderVo>();
        requestDto.setSubject(subject);
        requestDto.setOrder_no(order_no);
        requestDto.setAmount(amount);
        requestDto.setApp(app);
        requestDto.setBody(body);
        requestDto.setTrade_type(trade_type);
        requestDto.setChannel(channel);
        requestDto.setClient_ip(client_ip);
        requestDto.setCurrency(currency);
        requestDto.setTimeOutExpress("30m");
        if (ChannelEnums.ALI.getType().equalsIgnoreCase(requestDto.getChannel())) {
            OrderVo orderVo = aliPayTradeService.sendAliPayTradeService(requestDto);
            resultSet.setData(orderVo);
        } if (ChannelEnums.WEIXIN.getType().equalsIgnoreCase(requestDto.getChannel())) {
            OrderVo orderVo = weChatTradeService.wechatPrePay(requestDto);
            resultSet.setData(orderVo);
        }
        resultSet.setCode(RetCode.SUCCESS);
        return resultSet;
    }

    @RequestMapping(value = "/getOrderDetail.do" , method = RequestMethod.POST)
    public Result getOrderDetail() {
        OrderDetailDto detail = new OrderDetailDto();
        detail.setOrder_no(145654654);
        detail.setAmount("3499.00");
        detail.setApp("XIAOMI MIX2S");
        detail.setBody("sdakjfsldajf");
        detail.setSubject("askdfjsldaf");
        return new Result(detail);
    }
}
