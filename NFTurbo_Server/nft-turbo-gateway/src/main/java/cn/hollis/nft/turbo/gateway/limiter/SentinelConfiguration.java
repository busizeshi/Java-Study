package cn.hollis.nft.turbo.gateway.limiter;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 为了解决这个问题：https://github.com/alibaba/Sentinel/issues/3298
 *
 * @author Hollis
 */
@Configuration
public class SentinelConfiguration {

    @PostConstruct  // 1. 应用启动时自动执行
    public void initGatewayBlockHandler() {
        // 2. 设置“阻塞处理器” (BlockRequestHandler)
        // Sentinel 发现流量超标时，会调用这个方法
        GatewayCallbackManager.setBlockHandler(new BlockRequestHandler() {
            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable ex) {
                // 3. 自定义返回内容
                // 如果不配置这个，Sentinel 默认会返回一个冷冰冰的英文错误，甚至前端无法解析。
                // 这里我们把它变成了友好的 JSON/字符串。
                return ServerResponse.ok().body(Mono.just("限流啦,请求太频繁"), String.class);
            }
        });
    }
}

/**
 * 不在此处配置限流规则的原因如下：
 * 1. 工业界推荐采用规则动态化的设计模式。
 * 2. 将规则写死在代码中会导致灵活性差，每次修改都需要重新部署服务。
 * 3. 推荐将规则存储在 Nacos 配置中心，通过监听配置变化实现实时生效。
 */

