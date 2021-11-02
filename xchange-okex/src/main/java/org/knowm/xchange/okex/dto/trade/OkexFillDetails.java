package org.knowm.xchange.okex.v5.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OkexFillDetails {
    @JsonProperty("instType")
    private String instrumentType;

    @JsonProperty("instId")
    private String instrumentId;

    @JsonProperty("tradeId")
    private String tradeId;

    @JsonProperty("ordId")
    private String orderId;

    @JsonProperty("clOrdId")
    private String clientOrderId;

    @JsonProperty("billId")
    private String billId;

    @JsonProperty("tag")
    private String tag;

    @JsonProperty("fillPx")
    private String lastFilledPrice;

    @JsonProperty("fillSz")
    private String lastFilledQuantity;

    @JsonProperty("side")
    private String side;

    @JsonProperty("posSide")
    private String positionSide;

    @JsonProperty("execType")
    private String execType;

    @JsonProperty("feeCcy")
    private String feeCurrency;

    @JsonProperty("fee")
    private String fee;

    @JsonProperty("ts")
    private String timestamp;
}
