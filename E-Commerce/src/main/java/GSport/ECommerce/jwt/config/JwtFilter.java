package GSport.ECommerce.jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean{
		
		public static String secret ="CH13Mix-Guapos-y-Modestos-20220711";

		//add uniplomer auto generado por 
		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			// TODO Auto-generated method stub		
			
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String authHeader =  httpServletRequest.getHeader("authorization");
			
			if( ("POST".equals(httpServletRequest.getMethod())) ||
					( ("GET".equals(httpServletRequest.getMethod())) && 
							(! httpServletRequest.getRequestURI().contains("/api/products/") ) ) || 
					("PUT".equals(httpServletRequest.getMethod())) ||
					("DELETE".equals(httpServletRequest.getMethod()))
					
					)
			{
				if(authHeader==null||!authHeader.startsWith("Barer:  "))
				{
					throw new ServletException("1-. Inavalid Token");
				}//if authHeader
				String token=authHeader.substring(7);
				try
				{
					Claims claims=Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
					claims.forEach((key, value)->
					{
						System.out.printf("key: "+ key + "  value: "+value);
					});
				}//try
			catch (SignatureException | MalformedJwtException | ExpiredJwtException e) 
				{ 
					throw new ServletException("2. Invalid Token."); 
				}//catch 
			
			}//ifMethods
			chain.doFilter(request, response);
			
		}//doFilter


}
