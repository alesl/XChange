package info.bitrich.xchangestream.okcoin;

import info.bitrich.xchangestream.core.ProductSubscription;
import info.bitrich.xchangestream.core.StreamingExchange;
import io.reactivex.Completable;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.okex.v5.OkexExchange;

public class OkxStreamingExchange extends OkexExchange implements StreamingExchange {
    // Production URIs
    public static final String WS_PUBLIC_CHANNEL_URI = "wss://ws.okx.com:8443/ws/v5/public";
    public static final String WS_PRIVATE_CHANNEL_URI = "wss://ws.okx.com:8443/ws/v5/private";

    public static final String AWS_WS_PUBLIC_CHANNEL_URI = "wss://wsaws.okx.com:8443/ws/v5/public";
    public static final String AWS_WS_PRIVATE_CHANNEL_URI = "wss://wsaws.okx.com:8443/ws/v5/private";

    // Demo(Sandbox) URIs
    public static final String SANDBOX_WS_PUBLIC_CHANNEL_URI = "wss://wspap.okx.com:8443/ws/v5/public?brokerId=9999";
    public static final String SANDBOX_WS_PRIVATE_CHANNEL_URI = "wss://wspap.okx.com:8443/ws/v5/private?brokerId=9999";

    private OkxStreamingService streamingService;

    private OkxStreamingMarketDataService streamingMarketDataService;

    public OkxStreamingExchange() {}


    @Override
    public Completable connect(ProductSubscription... args) {
        ExchangeSpecification exchangeSpec = getExchangeSpecification();
        String apiUrl = getApiUrl();

        this.streamingService = new OkxStreamingService(apiUrl, exchangeSpec);

        applyStreamingSpecification(exchangeSpec, this.streamingService);
        this.streamingMarketDataService = new OkxStreamingMarketDataService(this.streamingService);

        return streamingService.connect();
    }

    private String getApiUrl() {
        String apiUrl;
        ExchangeSpecification exchangeSpec = getExchangeSpecification();
        if (exchangeSpec.getOverrideWebsocketApiUri() != null) {
            return exchangeSpec.getOverrideWebsocketApiUri();
        }

        boolean useSandbox =
                Boolean.TRUE.equals(
                        exchangeSpecification.getExchangeSpecificParametersItem(USE_SANDBOX)
                );
        boolean userAws =
                Boolean.TRUE.equals(
                        exchangeSpecification.getExchangeSpecificParametersItem(Parameters.PARAM_USE_AWS)
                );
        if (useSandbox) {
            apiUrl = SANDBOX_WS_PUBLIC_CHANNEL_URI;
        } else {
            apiUrl = userAws ? AWS_WS_PUBLIC_CHANNEL_URI : WS_PUBLIC_CHANNEL_URI;
        }
        return apiUrl;
    }

    @Override
    public Completable disconnect() {
        OkxStreamingService service = this.streamingService;
        this.streamingService = null;
        this.streamingMarketDataService = null;
        return service.disconnect();
    }

    @Override
    public boolean isAlive() {
        return streamingService != null && streamingService.isSocketOpen();
    }

    @Override
    public void useCompressedMessages(boolean compressedMessages) {
        throw new NotYetImplementedForExchangeException("useCompressedMessage");
    }
}
