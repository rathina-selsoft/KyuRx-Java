package com.selsoft.kyurx.doctor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.selsoft.kyurx.doctor.service.DoctorService;
import com.selsoft.kyurx.utils.JWTValidationUtils;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(value = "/addDiceAccount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addClient(HttpServletRequest request, HttpServletResponse httpResponse,
			@RequestBody DiceInfo diceInfo) {

		JSONObject jsonObject = new JSONObject();
		try {
			// JWT Token refresh
			if (!JWTValidationUtils.checkClient(request)) {
				httpResponse.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
				httpResponse.setHeader("Access-Control-Expose-Headers", JWTValidationUtils.REFRESH_TOKEN);
				httpResponse.setHeader(JWTValidationUtils.REFRESH_TOKEN, getJWTResfreshToken(request));
			}

			diceService.addDiceAccount(diceInfo);

			jsonObject.put("success", true);
			jsonObject.put("diceInfo", diceInfo.toJSON());
		} catch (DiceException e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.toString());
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
