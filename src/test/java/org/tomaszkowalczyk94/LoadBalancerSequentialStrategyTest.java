package org.tomaszkowalczyk94;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LoadBalancerSequentialStrategyTest {

    @Test
    public void selectHostToHandleRequest() {
        //given
        LoadBalancerSequentialStrategy loadBalancerSequentialStrategy = new LoadBalancerSequentialStrategy();

        HostImpl hostA = new HostImpl(0);
        HostImpl hostB = new HostImpl(1);

        loadBalancerSequentialStrategy.addHosts(Arrays.asList(hostA, hostB));

        //when
        Host firstHost = loadBalancerSequentialStrategy.selectHostToHandleRequest();
        Host secondHost = loadBalancerSequentialStrategy.selectHostToHandleRequest();
        Host thirdHost = loadBalancerSequentialStrategy.selectHostToHandleRequest();

        //then
        assertSame(firstHost, hostA);
        assertSame(secondHost, hostB);
        assertSame(thirdHost, hostA);

    }
}