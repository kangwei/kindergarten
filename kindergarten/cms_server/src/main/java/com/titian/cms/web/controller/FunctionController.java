/**
 * ClassName: FunctionController
 * CopyRight: TalkWeb
 * Date: 13-8-26
 * Version: 1.0
 */
package com.titian.cms.web.controller;

import com.titian.cms.common.Result;
import com.titian.core.dao.FunctionMapper;
import com.titian.core.domain.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description :
 *
 * @author : KangWei
 */
@Controller
@RequestMapping("function")
public class FunctionController extends AbstractBaseController {
    private static final Logger log = LoggerFactory.getLogger(FunctionController.class);

    @Autowired
    FunctionMapper functionMapper;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(Function function) {
       return effectiveResult(functionMapper.insert(function));
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public String update(Function function) {
        return effectiveResult(functionMapper.updateByPrimaryKey(function));
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(Integer functionId) {
        return effectiveResult(functionMapper.deleteByPrimaryKey(functionId));
    }
}
