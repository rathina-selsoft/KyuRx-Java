package com.selsoft.kyurx.utils;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.function.Function;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;


import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class JWTValidationUtils {
	
	public static final String HEADER_TEXT = "Authorization";
	public static final String REFRESH_TOKEN = "Refresh-Token";
	public static final String CLIENT = "Client";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String SECRET_KEY = "P317XQ";

	/**
	 * 
	 * Create JWT Token
	 * 
	 * @param user
	 * @return JWTToken
	 */

//	public static String createJWTForUser(User user) {
//
//		if (user == null)
//			return null;
//
//		String jwt = null;
//		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//		JwtBuilder builder = null;
//
//		byte[] apiKeySecretBytes = null;
//		try {
//			// apiKeySecretBytes =
//			// DatatypeConverter.parseBase64Binary(environment.getProperty("jwt.secretKey"));
//			apiKeySecretBytes = SECRET_KEY.getBytes("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//		// Let's set the JWT Claims
//		builder = Jwts.builder().setHeaderParam("typ", "JWT").setId(SECRET_KEY)
//				.setIssuedAt(RTSUtils.getCurrentUTCTimeAsSqlTimestamp())
//				.setExpiration(RTSUtils.addTimeToCurrentUTCTimeAsSqlTimestamp(RTSUtils.TIMEOUT))
//				.signWith(signatureAlgorithm, signingKey).setSubject(user.getUserId() + "");
//
//		jwt = builder.compact();
//		return StringUtils.join(TOKEN_PREFIX, jwt);
//	}
	
	/**
	 * 
	 * Verify the JWT Token
	 * 
	 * @param jwt
	 * @return userId
	 */

	public static String verfiyToken(String jwt) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = null;
		try {
			apiKeySecretBytes = SECRET_KEY.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(jwt).getBody();
		return claims.getSubject();
	}

	/**
	 * 
	 * Check token validation
	 * 
	 * @param authToken
	 * @return
	 * @throws Throwable
	 */

	public static boolean checkJWTToken(String authToken) throws Throwable {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = null;
		try {
			apiKeySecretBytes = SECRET_KEY.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		try {
			Jwts.parser().setSigningKey(signingKey).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Refresh token
	 * 
	 * 
	 */

	public static String refreshToken(String token) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = null;
		try {
			apiKeySecretBytes = SECRET_KEY.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		final Claims claims = getAllClaimsFromToken(token);
		claims.setIssuedAt(KyuRXUtils.getCurrentUTCTimeAsSqlTimestamp());
		claims.setExpiration(KyuRXUtils.addTimeToCurrentUTCTimeAsSqlTimestamp(KyuRXUtils.TIMEOUT));

		String refreshToken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, signingKey).compact(); 
		return StringUtils.join(TOKEN_PREFIX, refreshToken);
	}

	private static Claims getAllClaimsFromToken(String token) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = null;
		try {
			apiKeySecretBytes = SECRET_KEY.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
	}

	/**
	 * Resolve Token
	 * 
	 * @param request
	 * @return
	 */

	public static String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(HEADER_TEXT);
		if (StringUtils.isNotBlank(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX)) {
			String jwt = StringUtils.replace(bearerToken, TOKEN_PREFIX, "");
			return jwt;
		}
		return null;
	}
	
	/**
	 * 
	 * Checks Client is Mobile or Not
	 * 
	 * @param request
	 * @return
	 */
	
	public static boolean checkClient(HttpServletRequest request) {
		String client = request.getHeader(CLIENT);
		if (StringUtils.isNotBlank(client) && client.startsWith("Mobile")) {
			return true;
		}
		return false;
	}

	public static <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	public static String getJWTResfreshToken(HttpServletRequest request) {
		String jwt = resolveToken(request);
		return refreshToken(jwt);
	}

}
