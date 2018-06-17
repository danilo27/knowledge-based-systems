//package com;
//
//import java.util.List;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.converter.MessageConverter;
//import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
//import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
//import org.springframework.messaging.simp.config.ChannelRegistration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	public void configureClientInboundChannel(ChannelRegistration arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	public void configureClientOutboundChannel(ChannelRegistration arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	public boolean configureMessageConverters(List<MessageConverter> arg0) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//	public void configureWebSocketTransport(WebSocketTransportRegistration arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//     
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic");
//        config.setApplicationDestinationPrefixes("/app");
//    }
//
//     
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/gs-guide-websocket").withSockJS();
//    }
//
//
//	
//
//}