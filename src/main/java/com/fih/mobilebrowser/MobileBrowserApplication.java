package com.fih.mobilebrowser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.fih.mobilebrowser.interceptors.DeviceInfoInterceptor;
import com.fih.mobilebrowser.interceptors.SignAuthInterceptor;
import com.fih.mobilebrowser.utils.CryptoUtil;
import com.fih.mobilebrowser.utils.LogUtil;

@SpringBootApplication
public class MobileBrowserApplication implements WebMvcConfigurer {

	final Logger logger = LoggerFactory.getLogger(MobileBrowserApplication.class);

	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(MobileBrowserApplication.class, args);
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public CryptoUtil cryptoUtil() {
		try {
			return new CryptoUtil(rsaPriKeyResource(), rsaPubKeyResource());
		} catch (Exception e) {
			logger.error(LogUtil.getStackTraceString(e));
			return null;
		}
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public ClassPathResource rsaPriKeyResource() {
		try {
			return new ClassPathResource(env.getProperty("nb.resource.file.rsaprikey.name"));
		} catch (Exception e) {
			logger.error(LogUtil.getStackTraceString(e));
			return null;
		}
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public ClassPathResource rsaPubKeyResource() {
		try {
			return new ClassPathResource(env.getProperty("nb.resource.file.rsapubkey.name"));
		} catch (Exception e) {
			logger.error(LogUtil.getStackTraceString(e));
			return null;
		}
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// Device info
		registry.addInterceptor(new DeviceInfoInterceptor()).addPathPatterns("/**");
		// API key authentication
		registry.addInterceptor(new SignAuthInterceptor()).addPathPatterns(env.getProperty("nb.auth.path","/**").split(";"));
	}
}
