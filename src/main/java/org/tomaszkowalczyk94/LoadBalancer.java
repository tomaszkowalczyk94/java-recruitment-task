package org.tomaszkowalczyk94;

import java.util.Collection;

public class LoadBalancer {

    private final LoadBalancerStrategy loadBalancerStrategy;

    LoadBalancer(Collection<Host> hosts, LoadBalancerStrategy loadBalancerStrategy) {
        this.loadBalancerStrategy = loadBalancerStrategy;
        loadBalancerStrategy.addHosts(hosts);
    }

    public void handleRequest(Request request) {
        Host host = loadBalancerStrategy.selectHostToHandleRequest();
        host.handleRequest(request);
    }
}
