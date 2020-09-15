package org.tomaszkowalczyk94;

import java.util.logging.Logger;

public class HostImpl implements Host {

    private final static Logger LOGGER = Logger.getLogger(HostImpl.class.getName());

    private float load;

    public HostImpl(float load) {
        this.load = load;
    }

    public void setLoad(float load) {
        this.load = load;
    }

    @Override
    public float getLoad() {
        return load;
    }

    @Override
    public void handleRequest(Request request) {
        LOGGER.fine("handling request");
    }
}
