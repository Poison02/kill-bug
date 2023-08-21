package com.killbug.gateway.filter;

import com.killbug.gateway.utils.WebFluxUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Zch
 * @date 2023/8/21
 **/
@Component
public class BlackListUrlFilter extends AbstractGatewayFilterFactory<BlackListUrlFilter.Config> {

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            String url = exchange.getRequest().getURI().getPath();
            if (config.matchBlackList(url)) {
                return WebFluxUtils.webFluxResponseWriter(exchange.getResponse(), "Request url cannot be visited");
            }
            return chain.filter(exchange);
        });
    }

    public static class Config {
        private List<String> blackListUrl;

        private List<Pattern> blackListUrlPattern = new ArrayList<>();

        public boolean matchBlackList(String url) {
            return !blackListUrlPattern.isEmpty() && blackListUrlPattern.stream().anyMatch(p -> p.matcher(url).find());
        }

        public List<String> getBlackListUrl() {
            return blackListUrl;
        }

        public void setBlackListUrl(List<String> blackListUrl) {
            this.blackListUrl = blackListUrl;
            this.blackListUrlPattern.clear();
            this.blackListUrl.forEach(url ->
                    this.blackListUrlPattern
                            .add(Pattern.compile(
                                    url.replaceAll("\\*\\*", "(.*?)"),
                                    Pattern.CASE_INSENSITIVE)
                            )
            );
        }
    }

}
