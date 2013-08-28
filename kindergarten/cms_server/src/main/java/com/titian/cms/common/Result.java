/**
 * Result
 * Date: 12-6-7
 * Copyright: TalkWeb
 * Version: 1.0
 */
package com.titian.cms.common;

import com.opensoft.common.utils.json.gson.GsonUtils;
import com.titian.core.domain.TitianObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 接口返回结果
 *
 * @author : kangwei
 */
public class Result extends TitianObject {
    private static final Logger log = LoggerFactory.getLogger(Result.class);

    private boolean success;

    private String desc;

    private Map<String, Object> data = new HashMap<String, Object>();

    private Result() {
    }

    private Result(boolean success, String desc) {
        this.success = success;
        this.desc = desc;
    }

    public static Result fail(String desc) {
        return new Result(false, desc);
    }

    public static Result success() {
        return new Result(true, "成功");
    }

    public boolean isSuccess() {
        return success;
    }

    public String getDesc() {
        return desc;
    }

    public Result setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Result setData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Object getDataValueByKey(String key) {
        return data.get(key);
    }

    public String toJson() {
        return GsonUtils.toJson(this);
    }
}
