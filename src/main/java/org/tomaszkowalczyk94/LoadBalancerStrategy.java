package org.tomaszkowalczyk94;

import java.util.Collection;

public interface LoadBalancerStrategy {

    void addHosts(Collection<Host> hosts);
    Host selectHostToHandleRequest();
}
