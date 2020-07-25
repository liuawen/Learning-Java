package com.dalaoyang.router;

import com.dalaoyang.handle.UserHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.router
 * @email yangyang@dalaoyang.cn
 * @date 2018/9/1
 */
@Configuration
public class UserRouter {
    @Bean
    public RouterFunction<ServerResponse> routeCity(UserHandle userHandle) {
        return RouterFunctions.route(GET("/user/{id}").and(accept(APPLICATION_JSON)), userHandle::getUser)
                .andRoute(GET("/listPeople").and(accept(APPLICATION_JSON)), userHandle::listPeople)
                .andRoute(POST("/saveUser"), userHandle::saveUser);
    }
}
