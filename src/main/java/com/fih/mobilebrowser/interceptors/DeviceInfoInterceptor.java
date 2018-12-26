package com.fih.mobilebrowser.interceptors;

import static com.fih.mobilebrowser.utils.SpringUtil.getProperty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fih.mobilebrowser.models.DeviceInfo;
import com.fih.mobilebrowser.utils.SpringUtil;
import com.fih.mobilebrowser.utils.CryptoUtil;
import com.fih.mobilebrowser.utils.LogUtil;

public class DeviceInfoInterceptor implements HandlerInterceptor {

	final Logger logger = LoggerFactory.getLogger(DeviceInfoInterceptor.class);
	private String deviceinfo_header;
	private String aeskey_header;

	public DeviceInfoInterceptor() {
		deviceinfo_header = getProperty("nb.http.header.deviceinfo", String.class, "device");
		aeskey_header = getProperty("nb.http.header.aeskey", String.class, "key");
	}

	private boolean getDevInfo(HttpServletRequest request) {

		String crypDevinfoJSONStr = null;
		String crypAESKey = null;

		crypDevinfoJSONStr = request.getHeader(deviceinfo_header);
		crypAESKey = request.getHeader(aeskey_header);

		if (crypDevinfoJSONStr == null || crypAESKey == null) {
			logger.debug("Request from {} contains incomplete crypto device info.", request.getRemoteAddr());
		}

		String JSONStr = null;

		try {
			CryptoUtil cryptoUtil = (CryptoUtil) SpringUtil.getBean("cryptoUtil");
			JSONStr = cryptoUtil.getDecryptedJSONString(crypDevinfoJSONStr, crypAESKey);
			DeviceInfo devInfo = new ObjectMapper().readValue(JSONStr, DeviceInfo.class);
			request.setAttribute("deviceinfo", devInfo);
			logger.debug("Device info from {} : "
					+ "Account Id = {}, "
					+ "IMEI = {}, "
					+ "PSN = {}, "
					+ "Android Version = {}, "
					+ "Network Type = {}, "
					+ "Network Operator = {}, "
					+ "Screen Density = {}, "
					+ "Language = {}, "
					+ "Package Name = {}, "
					+ "Android Version Name = {}, "
					+ "Android Version Code = {}, "
					+ "Project = {}, "
					,request.getRemoteAddr()
					,devInfo.getAccId()
					,devInfo.getIMEI()
					,devInfo.getPSN()
					,devInfo.getAnVer()
					,devInfo.getNet()
					,devInfo.getNetOp()
					,devInfo.getSDen()
					,devInfo.getLan()
					,devInfo.getPkgName()
					,devInfo.getAnVerName()
					,devInfo.getAnVerCode()
					,devInfo.getPrj()
			);
			try { devInfo.splitPrj(); }
			catch (Exception splitE){
				logger.debug("Failed to split project in device info from {} Error msg : {}", request.getRemoteAddr(), splitE.getMessage());
			}
		} catch (Exception e) {
			logger.error("Failed to decrypt crypto device info from {} Raw-encrypted device info string = {} Decrypted device info string = {} Error msg : {}", request.getRemoteAddr(), crypDevinfoJSONStr, JSONStr, e.getMessage());
			request.setAttribute("deviceinfo_string", JSONStr);
		}

		return true;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		return getDevInfo(request);
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
