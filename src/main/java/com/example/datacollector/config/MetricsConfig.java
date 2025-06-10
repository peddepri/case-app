package com.example.datacollector.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

@Configuration
public class MetricsConfig {

    @Bean
    public HandlerInterceptor metricsInterceptor(MeterRegistry meterRegistry) {
        return new MetricsInterceptor(meterRegistry);
    }

    private static class MetricsInterceptor implements HandlerInterceptor {
        private final Counter requestCounter;
        private final Timer requestTimer;

        public MetricsInterceptor(MeterRegistry meterRegistry) {
            this.requestCounter = meterRegistry.counter("http_requests_total");
            this.requestTimer = meterRegistry.timer("http_request_duration_seconds");
        }

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
            requestCounter.increment();
            return true;
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
            requestTimer.record(Duration.between(startTime, Instant.now()));
        }
    }
}