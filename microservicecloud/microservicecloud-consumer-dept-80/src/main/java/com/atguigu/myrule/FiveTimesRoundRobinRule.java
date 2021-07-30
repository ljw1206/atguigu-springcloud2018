package com.atguigu.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class FiveTimesRoundRobinRule extends AbstractLoadBalancerRule {

	// invokedTimes =0, 当invokedTimes==5以后，我们的指针才能往下走
	// currentIndex = 0（在eureka中注册的微服务索引，例如eureka中有3台，0 表示第一台）, 当前对外提供服务的服务器地址（机器号）
	// 当上一台服务器轮询5次之后，invokedTimes需要重新置零，并且index+1（下一台对外提供服务的服务器索引）
	// 分析：假设eureka注册中心只有3台存活可对外服务的微服务8001、8002、8003 (注意了，是指存活的，down掉的不计算在内：upList.get(index))，
	// 所以currentIndex叠加到第三台之后，我们需要重新拉回来，又重新开始新的一轮（还是上面的步骤）
	
    private int invokedTimes = 0;  // 总共被调用的次数，目前要求每台被调用5次
    private int currentIndex = 0;  // 当前提供服务的机器号
	
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }

        Server server = null;
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes only get more restrictive.
                 */
                return null;
            }

            if (invokedTimes < 5) {
                server = upList.get(currentIndex);
                invokedTimes++;
            } else {
                invokedTimes = 0;
                currentIndex++;
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were somehow trimmed.
                 * This is a transient condition. Retry after yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return server;
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;
    }
    
	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}
 
	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		
	}

}
