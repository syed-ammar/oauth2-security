package com.way2learnonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
//TODO -1 Write the Annotation to Enable Authorization Server
@EnableAuthorizationServer

// TODO -2 Make this Class to extend AuthorizationServerConfigurerAdapter
public class AuthorizationServerConfig  extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private AuthenticationManager authManager;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws
	Exception {
		endpoints.authenticationManager(authManager);
	}

	//This is to configure client credentials
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("way2learn").secret("way2learn").
		authorizedGrantTypes("password").scopes("read”,”write”,”trust");
	}
}
