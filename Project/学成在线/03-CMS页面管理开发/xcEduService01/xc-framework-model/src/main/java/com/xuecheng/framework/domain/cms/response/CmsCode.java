package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.model.response.ResultCode;
import lombok.ToString;

/**
 * Created by mrt on 2018/3/5.
 */
@ToString
public enum CmsCode implements ResultCode {
    CMS_ADDPAGE_EXISTSNAME(false,24001,"页面名称已存在！"),
    CMS_GENERATEHTML_DATAURLISNULL(false,24002,"从页面信息中找不到获取数据的url！"),
    CMS_GENERATEHTML_DATAISNULL(false,24003,"根据页面的数据url获取不到数据！"),
    CMS_GENERATEHTML_TEMPLATEISNULL(false,24004,"页面模板为空！"),
    CMS_GENERATEHTML_HTMLISNULL(false,24005,"生成的静态html为空！"),
    CMS_GENERATEHTML_SAVEHTMLERROR(false,24005,"保存静态html出错！"),
    CMS_COURSE_PERVIEWISNULL(false,24007,"预览页面为空！");
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CmsCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
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
