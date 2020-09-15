package org.tomaszkowalczyk94;

import java.util.*;

class LoadBalancerLoadValueStrategy implements LoadBalancerStrategy {

    private float limitValue;

    private final List<Host> hosts = new ArrayList<>();

    public LoadBalancerLoadValueStrategy(float limitValue) {
        this.limitValue = limitValue;
    }

    @Override
    public void addHosts(Collection<Host> hostsParam) {
        hosts.addAll(hostsParam);
    }

    @Override
    public Host selectHostToHandleRequest() {
        if(hosts.isEmpty()) {
            throw new LackOfHostsException();
        }

        return getFirstUnderLimitValue()
                .orElseGet(this::getTheLowest);

    }

    private Optional<Host> getFirstUnderLimitValue() {
        return hosts
                .stream()
                .filter(host -> host.getLoad() < limitValue)
                .findFirst();
    }

    private Host getTheLowest() {
        return hosts
                .stream()
                .min(Comparator.comparing(Host::getLoad))
                .orElseThrow(LackOfHostsException::new);
    }
}
