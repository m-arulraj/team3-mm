
package com.moneymanager.client.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.moneymanager.client.domain.User;
import com.moneymanager.client.service.ClientService;

@Component
public class MoneyManagerAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	ClientService clientService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		User user = clientService.getLoginUser(username, password);
		if (!user.getUserName().equalsIgnoreCase(username)) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}

		List<GrantedAuthority> role = new ArrayList<GrantedAuthority>();
		role.add(new SimpleGrantedAuthority("USER"));

		return new UsernamePasswordAuthenticationToken(username, password, role);
	}

	@Override
	public boolean supports(Class<?> authentication) { // TODO Auto-generated method stub
		return true;
	}
}
