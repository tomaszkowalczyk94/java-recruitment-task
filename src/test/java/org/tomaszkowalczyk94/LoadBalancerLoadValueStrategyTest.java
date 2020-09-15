package org.tomaszkowalczyk94;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LoadBalancerLoadValueStrategyTest {

    @Test
    public void selectHostToHandleRequest() {
        //given
        LoadBalancerLoadValueStrategy strategy = new LoadBalancerLoadValueStrategy(0.75f);

        HostImpl hostA = new HostImpl(0.61f);
        HostImpl hostB = new HostImpl(0.60f);
        HostImpl hostC = new HostImpl(0.80f);
        HostImpl hostD = new HostImpl(2.0f);

        strategy.addHosts(Arrays.asList(hostA, hostB, hostC, hostD));

        //when
        Host host = strategy.selectHostToHandleRequest();
        //then
        assertSame(hostA, host);

        //when
        hostA.setLoad(99.0f);
        hostB.setLoad(99.0f);
        host = strategy.selectHostToHandleRequest();
        //then
        assertSame(hostC, host);

    }
}