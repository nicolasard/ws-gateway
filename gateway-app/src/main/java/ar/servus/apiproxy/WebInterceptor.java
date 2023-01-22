package ar.servus.apiproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.Enumeration;

/*
    Interceptor used for log the requests to our app at very first time and creates an UUID.
 */
public class WebInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(GatewayApp.class);

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        StringBuffer jb = new StringBuffer();
        logger.info("{} {}",request.getMethod(), request.getRequestURL());
        Enumeration<String> headerNames = request.getHeaderNames();
        logger.info("Query String: {}",request.getQueryString());
        while (headerNames.hasMoreElements()) {
            String param = headerNames.nextElement();
            String paramValue = request.getHeader(param);
            logger.info("Header: {}:{}",param,paramValue);
        }
        /*
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            throw e;
        }
        logger.info(line);
        */
        logger.info("Response Status: {}",response.getStatus());
        return true;
    }

}