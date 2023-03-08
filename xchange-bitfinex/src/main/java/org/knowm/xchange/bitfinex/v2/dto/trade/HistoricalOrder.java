package org.knowm.xchange.bitfinex.v2.dto.trade;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/** https://docs.bitfinex.com/reference/rest-auth-orders-history */
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@Setter
@Getter
@ToString
public class HistoricalOrder {

    /** Order ID */
    private long id;
    /** Group ID */
    private Long gid;
    /** Client Order ID */
    private Long cid;
    /** Pair (tBTCUSD, …) */
    private String symbol;
    /** Millisecond timestamp of creation */
    private long timestampCreate;
    /** Millisecond timestamp of update */
    private Long timestampUpdate;
    /** Positive means buy, negative means sell. */
    private BigDecimal amount;
    /** Original amount. */
    private BigDecimal amountOrig;
    /**
     * The type of the order: LIMIT, MARKET, STOP, TRAILING STOP, EXCHANGE MARKET, EXCHANGE LIMIT,
     * EXCHANGE STOP, EXCHANGE TRAILING STOP, FOK, EXCHANGE FOK, IOC, EXCHANGE IOC.
     */
    private String type;
    /** Previous order type */
    private String typePrev;
    /** Millisecond timestamp of Time-In-Force: automatic order cancellation */
    private Long timestampTimeInForce;
    private Object placeholder1;
    /** See https://docs.bitfinex.com/v2/docs/flag-values. */
    private int flags;
    /**
     * Order Status: ACTIVE, EXECUTED, PARTIALLY FILLED, CANCELED, RSN_DUST (amount is less than
     * 0.00000001), RSN_PAUSE (trading is paused / paused due to AMPL rebase event)
     */
    private String orderStatus;
    private Object placeholder2;
    private Object placeholder3;
    /** Price */
    private BigDecimal price;
    /** Average price */
    private BigDecimal priceAvg;
    /** The trailing price */
    private BigDecimal priceTrailing;
    /** Auxiliary Limit price (for STOP LIMIT) */
    private BigDecimal priceAuxLimit;
    private Object placeholder4;
    private Object placeholder5;
    private Object placeholder6;
    private Object placeholder7;
    /** 0 if false, 1 if true */
    private int hidden;
    /** If another order caused this order to be placed (OCO) this will be that other order's ID */
    private Long placedId;
    private Object placeholder8;
    private Object placeholder9;
    /** indicates origin of action: BFX, ETHFX, API>BFX, API>ETHFX */
    private String routing;
    private Object placeholder10;
    private Object placeholder11;
    /** Additional meta information about the order ( $F7 = IS_POST_ONLY (0 if false, 1 if true), $F33 = Leverage (int)) */
    private Object meta;

}
