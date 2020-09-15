package org.tomaszkowalczyk94;

import com.google.common.collect.Iterators;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

class LoadBalancerSequentialStrategy implements LoadBalancerStrategy {

    private Iterator<Host> iterator = Collections.emptyIterator();

    @Override
    public void addHosts(Collection<Host> hosts) {
        iterator =  Iterators.cycle(hosts);
    }

    @Override
    public Host selectHostToHandleRequest() {
        if(iterator.hasNext()) {
            return iterator.next();
        }
        throw new LackOfHostsException();
    }
}
