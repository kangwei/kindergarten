/**
 * ClassName: Menu
 * CopyRight: TalkWeb
 * Date: 13-9-4
 * Version: 1.0
 */
package com.titian.core.domain;

import java.util.List;

/**
 * Description :
 *
 * @author : KangWei
 */
public class Menu extends Function {
    private List<Menu> children;

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
