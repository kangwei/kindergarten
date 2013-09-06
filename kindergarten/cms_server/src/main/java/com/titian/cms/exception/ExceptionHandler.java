package com.titian.cms.exception;

import com.opensoft.common.utils.CloseableUtils;
import com.titian.cms.common.ErrorCode;
import com.titian.cms.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Description:统一的异常处理
 * User: 康维
 * Date: 11-12-29
 */
public class ExceptionHandler implements HandlerExceptionResolver {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        log.error("访问" + request.getRequestURL().toString() + "时发生异常。" + "\n"
                + "异常发生类：" + o.getClass().getName() + "\n"
                + "异常：" + e.getMessage(), e);
        ErrorCode errorCode = null;
        if (e instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) e;
            errorCode = serviceException.getErrorCode();
        }

        if (errorCode == null) {
            errorCode = ErrorCode.server_error;
        }

        String errorMsg = errorCode.getDesc() + ":" + e.getMessage();
        if (request.getHeader("ajax") != null) {
            handlerResponse(request, response, Result.fail(errorMsg).toJson());
        }
        request.setAttribute("errorMsg", errorMsg);
        return new ModelAndView("500");
    }

    /**
     * 向response中写入信息
     *
     * @param request  request
     * @param response response
     * @param str      信息
     */
    public void handlerResponse(HttpServletRequest request, HttpServletResponse response, String str) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"));
            writer.write(str);
            writer.flush();
        } catch (IOException e) {
            log.error("将信息" + str + "写入response异常", e);
        } finally {
            CloseableUtils.close(writer);
        }
    }


}
