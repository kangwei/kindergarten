/**
 * ClassName: ViewController
 * CopyRight: TalkWeb
 * Date: 13-8-26
 * Version: 1.0
 */
package com.titian.cms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description :
 *
 * @author : KangWei
 */
@Controller
public class ViewController {
    @RequestMapping("/{viewName}")
    public String returnView(@PathVariable String viewName) {
        return viewName;
    }
}
