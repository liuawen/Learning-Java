package com.dalaoyang.back;

import com.dalaoyang.interfaces.FeignInterface;
import org.springframework.stereotype.Service;

/**
 * @author dalaoyang
 * @Description
 * @project springcloud_learn
 * @package com.dalaoyang.back
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/20
 */
@Service
public class FeignFallbackService implements FeignInterface {
    @Override
    public String IndexInfo(){
        return "远程调用失败！";
    };
}
