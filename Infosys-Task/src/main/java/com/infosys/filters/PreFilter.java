package com.infosys.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.infosys.util.JwtConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.SignatureAlgorithm;

@WebFilter("/*")
public class PreFilter extends HttpFilter{

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(PreFilter.class);
	
	
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		log.info("Inside of PreFilter.doFilter()");
		
		// 1. Get the HTTP header named "Authorization"
		String header = req.getHeader(JwtConfig.HEADER);
		
		
		
		log.info("header before validation in step 2: " + header);
		// 2. Validate the header values and check the prefix
		if(header == null || !header.startsWith(JwtConfig.PREFIX)) {
			log.info("Request originates from an unauthenticated origin");
			//log.info(header);
			
			// 2.1: If there is no header, or one that we provided, then go to the next step in the filter chain (target servlet)
			chain.doFilter(req, resp);
				return;
			}
		
		
		
		log.info("Right before step 3 Get the token");
		// 3. Get the token
		String token = header.replaceAll(JwtConfig.PREFIX, "");
				
		try {
			
			log.info("right before claims, step 4. validate the token");
			// 4. Validate the token
			Claims claims = Jwts.parser()
					.setSigningKey(JwtConfig.signingKey)
					.parseClaimsJws(token)
					.getBody();
			
			
			log.info("after validate token, value of token is: " + claims.get(token));
			// 5. Obtain the principal/subject stored in the JWT
			Principal principal = new Principal();
			
			principal.setId(Integer.parseInt(claims.getId())); 
			log.info("inside of step 5 in PreFilter, print out the principal getId(): " + principal.getId());
			
			principal.setRole(claims.get("Role", String.class));
			log.info("inside of step 5 in PreFilter, print out the principal getRole(): " + principal.getRole());
			
			
			
			// 6. Attach an attribute to the request indicating information about the principal
			req.setAttribute("principal", principal);
			
			log.info("in step 6: Claims are: " + claims);
			log.info("in step 6: principal is: " + principal);
			log.info("in step 6, trying req.getAttribute(principal): " + req.getAttribute("principal"));
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		
		// 7. Send the request to the next filter in the chain (target servlet)
		log.info("about to do step 7, chain.doFilter(req, resp");
		chain.doFilter(req, resp);
		
	}
}