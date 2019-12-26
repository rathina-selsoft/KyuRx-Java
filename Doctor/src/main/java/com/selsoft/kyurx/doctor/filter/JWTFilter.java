package com.selsoft.kyurx.doctor.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.selsoft.kyurx.utils.JWTValidationUtils;


@Component
public class JWTFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		try {
			HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
			if (JWTValidationUtils.checkClient(httpServletRequest)) {
				filterChain.doFilter(servletRequest, servletResponse);
			} else {
				String jwt = JWTValidationUtils.resolveToken(httpServletRequest);
				if (StringUtils.isNotBlank(jwt)) {
					if (JWTValidationUtils.checkJWTToken(jwt)) {
						filterChain.doFilter(servletRequest, servletResponse);
					} else {
						((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					}
				} else {
					((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}
		} catch (Exception eje) {
			((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		} catch (Throwable e) {
			((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}
	
	

}

