package com.dalaoyang.handler;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


/**
 * @author dalaoyang
 * @project springboot_learn
 * @package com.dalaoyang.handler
 * @email yangyang@dalaoyang.cn
 * @date 2018/7/30
 */
@Component
public class HiHandler {


    public Mono<ServerResponse> Hi(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject("Hi , this is SpringWebFlux"));
    }
}
