package pdev.spring.Config;

import pdev.spring.handler.WebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final static String CHAT_ENDPOINT = "/chat";

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(getChatWebSocketHandler(), CHAT_ENDPOINT)
                .setAllowedOrigins("http://localhost:4200");
    }

    @Bean
    public WebSocketHandler getChatWebSocketHandler(){
        return new WebSocketHandler();
    }
}
/*
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;
	@Configuration
	@EnableWebSocketMessageBroker
	public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	    @Override
	    public void registerStompEndpoints(StompEndpointRegistry registry) {
	        registry.addEndpoint("/socket").withSockJS();
	    }

	    @Override
	    public void configureMessageBroker(MessageBrokerRegistry registry) {
	        registry.setApplicationDestinationPrefixes("/app");
	        registry.enableSimpleBroker("/message");
	    }*/
	    
	/*    public void configureMessageBroker1(MessageBrokerRegistry registry) {
	        registry.setApplicationDestinationPrefixes("/app");

	        // Use this for enabling a Full featured broker like RabbitMQ
	        registry.enableStompBrokerRelay("/topic")
	                .setRelayHost("localhost")
	                .setRelayPort(61613)
	                .setClientLogin("guest")
	                .setClientPasscode("guest");
	    }*/
