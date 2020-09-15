package org.tomaszkowalczyk94;

public interface Host {
    float getLoad();
    void handleRequest(Request request);
}
