package com.xuecheng.framework.domain.portalview.response;

import com.google.common.collect.ImmutableMap;
import com.xuecheng.framework.model.response.ResultCode;
import lombok.ToString;


/**
 * Created by admin on 2018/3/5.
 */
@ToString
public enum PortalViewCode implements ResultCode {
    PortalView_ADDVIEWCOURSE_COURSEIDISNULL(false,42001,"课程id为空！"),
    PortalView_PUBLISH_PREVIEWCOURSE_ISNULL(false,42002,"预览课程视图为空！"),
    PortalView_PUBLISH_PREVIEWMEDIA_ISNULL(false,42003,"预览课程媒资视图为空！");

    //操作代码
    boolean success;

    //操作代码
    int code;
    //提示信息
    String message;
    private PortalViewCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    private static final ImmutableMap<Integer, PortalViewCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, PortalViewCode> builder = ImmutableMap.builder();
        for (PortalViewCode commonCode : values()) {
            builder.put(commonCode.code(), commonCode);
        }
        CACHE = builder.build();
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
