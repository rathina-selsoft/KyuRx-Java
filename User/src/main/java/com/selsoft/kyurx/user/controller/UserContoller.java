package com.selsoft.kyurx.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.selsoft.kyurx.exception.KyuRxException;
import com.selsoft.kyurx.models.User;
import com.selsoft.kyurx.user.service.UserService;
import com.selsoft.kyurx.utils.JWTValidationUtils;

@RestController
@RequestMapping(value = "/user")
public class UserContoller {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addUserWithRole", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addUserWithRole(HttpServletRequest request, HttpServletResponse httpResponse,
			@RequestBody User user) {

		String activationUrl = request.getRequestURL().toString();
		activationUrl = StringUtils.substring(activationUrl, 0, activationUrl.lastIndexOf("/"));

		JSONObject jsonObject = new JSONObject();
		try {
			// JWT Token refresh
			if (!JWTValidationUtils.checkClient(request)) {
				httpResponse.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
				httpResponse.setHeader("Access-Control-Expose-Headers", JWTValidationUtils.REFRESH_TOKEN);
				httpResponse.setHeader(JWTValidationUtils.REFRESH_TOKEN, getJWTResfreshToken(request));
			}

			userService.addUserWithRole(user, activationUrl);
			jsonObject.put("success", true);
			jsonObject.put("user", user.toJSON());
		} catch (KyuRxException e) {
			return e.toString();
		} catch (Exception e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		} catch (Throwable e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		}

		return jsonObject.toString();

	}

	private String getJWTResfreshToken(HttpServletRequest request) {
		String jwt = JWTValidationUtils.resolveToken(request);
		return JWTValidationUtils.refreshToken(jwt);
	}

}
