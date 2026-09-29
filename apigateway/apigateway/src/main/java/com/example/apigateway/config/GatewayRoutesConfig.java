package com.example.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.rewritePath;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;

@Configuration
public class GatewayRoutesConfig {
    @Bean
    public RouterFunction<ServerResponse>
    recommendationServiceRoute() {

        return route("recommendation-service")
                .POST(
                        "/recommendationservice/**",
                        http()
                )
                .GET(
                        "/recommendationservice/**",
                        http()
                )
                .PUT(
                        "/recommendationservice/**",
                        http()
                )
                .DELETE(
                        "/recommendationservice/**",
                        http()
                )
                .before(
                        rewritePath(
                                "/recommendationservice/(?<segment>.*)",
                                "/${segment}"
                        )
                )
                .filter(
                        lb("RECOMMENDATION-SERVICE")
                )
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> trainServiceRoute() {

        return route("train-service")
                .GET("/trainservice/**", http())
                .before(rewritePath(
                        "/trainservice/(?<segment>.*)",
                        "/${segment}"
                ))
                .filter(lb("TRAINSERVICE"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> authServiceRoute() {
        return route("auth-service")
                .POST("/authservice/**", http())
                .GET("/authservice/**", http())
                .PUT("/authservice/**", http())
                .DELETE("/authservice/**", http())
                .before(rewritePath(
                        "/authservice/(?<segment>.*)",
                        "/${segment}"
                ))
                .filter(lb("AUTHSERVICE"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> seatInventoryServiceRoute() {
        return route("seat-inventory-service")
                .GET("/inventoryservice/**", http())
                .POST("/inventoryservice/**", http())
                .PUT("/inventoryservice/**", http())
                .DELETE("/inventoryservice/**", http())
                .before(rewritePath(
                        "/inventoryservice/(?<segment>.*)",
                        "/${segment}"
                ))
                .filter(lb("SEAT-INVENTORY-SERVICE"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> scheduleServiceRoute() {
        return route("schedule-service")
                .GET("/scheduleservice/**", http())
                .before(rewritePath(
                        "/scheduleservice/(?<segment>.*)",
                        "/${segment}"
                ))
                .filter(lb("SCHEDULE-SERVICE"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> bookingServiceRoute() {
        return route("booking-service")
                .POST("/bookingservice/**", http())
                .GET("/bookingservice/**", http())
                .PUT("/bookingservice/**", http())
                .DELETE("/bookingservice/**", http())
                .before(rewritePath(
                        "/bookingservice/(?<segment>.*)",
                        "/${segment}"
                ))
                .filter(lb("BOOKING-SERVICE"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> paymentServiceRoute() {
        return route("payment-service")
                .GET("/paymentservice/**", http())
                .POST("/paymentservice/**", http())
                .PUT("/paymentservice/**", http())
                .DELETE("/paymentservice/**", http())
                .before(rewritePath(
                        "/paymentservice/(?<segment>.*)",
                        "/${segment}"
                ))
                .filter(lb("PAYMENT-SERVICE"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> ticketServiceRoute() {
        return route("ticket-service")
                .GET("/ticketservice/**", http())
                .POST("/ticketservice/**", http())
                .PUT("/ticketservice/**", http())
                .DELETE("/ticketservice/**", http())
                .before(rewritePath(
                        "/ticketservice/(?<segment>.*)",
                        "/${segment}"
                ))
                .filter(lb("TICKET-SERVICE"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> searchServiceRoute() {
        return route("search-service")
                .GET("/searchservice/**", http())
                .POST("/searchservice/**", http())
                .PUT("/searchservice/**", http())
                .DELETE("/searchservice/**", http())
                .before(rewritePath(
                        "/searchservice/(?<segment>.*)",
                        "/${segment}"
                ))
                .filter(lb("SEARCH-SERVICE"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> notificationServiceRoute() {
        return route("notification-service")
                .GET("/notificationservice/**", http())
                .POST("/notificationservice/**", http())
                .PUT("/notificationservice/**", http())
                .DELETE("/notificationservice/**", http())
                .before(rewritePath(
                        "/notificationservice/(?<segment>.*)",
                        "/${segment}"
                ))
                .filter(lb("NOTIFICATION-SERVICE"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> liveTrackingServiceRoute() {
        return route("live-tracking-service")
                .GET("/trackingservice/**", http())
                .POST("/trackingservice/**", http())
                .PUT("/trackingservice/**", http())
                .DELETE("/trackingservice/**", http())
                .before(rewritePath(
                        "/trackingservice/(?<segment>.*)",
                        "/${segment}"
                ))
                .filter(lb("LIVE-TRACKING-SERVICE"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> predictionServiceRoute() {
        return route("prediction-service")
                .POST("/predictionservice/**", http())
                .GET("/predictionservice/**", http())
                .PUT("/predictionservice/**", http())
                .DELETE("/predictionservice/**", http())
                .before(rewritePath(
                        "/predictionservice/(?<segment>.*)",
                        "/${segment}"
                ))
                .filter(lb("PREDICTION-SERVICE"))
                .build();
    }

}