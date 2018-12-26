package com.fih.mobilebrowser.interceptors;

import static com.fih.mobilebrowser.utils.SpringUtil.*;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fih.mobilebrowser.models.AppServiceGeneralResponse;
import com.fih.mobilebrowser.utils.CryptoUtil;
import com.fih.mobilebrowser.utils.LogUtil;
import com.google.gson.Gson;

public class SignAuthInterceptor implements HandlerInterceptor {

	final Logger logger = LoggerFactory.getLogger(SignAuthInterceptor.class);

	private String deviceinfo_header;
	private String aeskey_header;
	private String hash_header;
	private String signature_header;
	private Boolean auth_open;
	private Long auth_expired_time;
	private Boolean auth_expired_time_open;

	public SignAuthInterceptor() {
		deviceinfo_header = getProperty("nb.http.header.deviceinfo", String.class, "devinfo");
		aeskey_header = getProperty("nb.http.header.aeskey", String.class, "key");
		hash_header = getProperty("nb.http.header.hash", String.class, "hash");
		signature_header = getProperty("nb.http.header.signature", String.class, "sign");
		auth_open = getProperty("nb.auth.open", Boolean.class, true);
		auth_expired_time = getProperty("nb.auth.expiredtime", Long.class, new Long(30000));
		auth_expired_time_open = getProperty("nb.auth.expiredtime.open", Boolean.class, false);
	}

	private boolean auth(HttpServletRequest request, HttpServletResponse response) {
		try {
			// authenticate logic
		} catch (Exception e) {
			logger.error("API sigature authenticating failed from {} Error msg : {}", request.getRemoteAddr(), e.getMessage());
			// Preparing returning Json.
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			AppServiceGeneralResponse<?> res = new AppServiceGeneralResponse<Void>();
			res.setErrorMessage("API Signature unauthorized.");
			res.setStatus("Error");
			String json = new Gson().toJson(res);
			try { response.getWriter().write(json); }
			catch (IOException ioe) { logger.error(LogUtil.getStackTraceString(ioe)); }
		}

		return false;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		boolean res = true;

		if (auth_open) {
			res = auth(request, response);
		}

		return res;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
