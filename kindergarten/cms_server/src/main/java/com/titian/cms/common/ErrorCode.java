package com.titian.cms.common;

/**
 * Description : 错误代码
 *
 * @author : KangWei
 */
public enum ErrorCode {
    database_no_row_effect("数据库操作没有成功"),
    server_error("服务器异常");

    private final String desc;

    ErrorCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
