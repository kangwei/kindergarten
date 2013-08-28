/**
 * ClassName: OperateLogAop
 * CopyRight: TalkWeb
 * Date: 13-8-27
 * Version: 1.0
 */
package com.titian.cms.aop;

import com.titian.core.dao.OperateLogMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Description : 操作日志AOP
 *
 * @author : KangWei
 */
@Configurable
@Aspect
public class OperateLogAop {
    private static final Logger log = LoggerFactory.getLogger(OperateLogAop.class);

    public static final String POINT = "execution(public String com.titian.cms.web.controller.*.*(..))";

    @Autowired
    OperateLogMapper operateLogMapper;

    @AfterReturning(pointcut = POINT, returning = "returnVal")
    public void after(JoinPoint joinPoint, Object returnVal) {
        Object[] args = joinPoint.getArgs();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        log.info("请求{}-{}服务，参数：{}，返回：{}", new Object[]{
                className, method, args, returnVal
        });
    }
}
