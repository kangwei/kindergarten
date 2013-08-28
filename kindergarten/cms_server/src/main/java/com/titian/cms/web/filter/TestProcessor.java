/**
 * ClassName: TestProcessor
 * CopyRight: TalkWeb
 * Date: 13-8-26
 * Version: 1.0
 */
package com.titian.cms.web.filter;

import com.opensoft.common.web.filter.processor.AbstractProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description :
 *
 * @author : KangWei
 */
public class TestProcessor extends AbstractProcessor {
    private static final Logger log = LoggerFactory.getLogger(TestProcessor.class);

    @Override
    public boolean execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("这是测试的过滤器.............");
        return super.execute(request, response);
    }
}
