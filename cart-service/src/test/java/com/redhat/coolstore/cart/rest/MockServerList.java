package com.redhat.coolstore.cart.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

@Component(value="ribbonServerList")
public class MockServerList implements ServerList {

    private int port;

    @Override
    public List getInitialListOfServers() {
        return getUpdatedListOfServers();
    }

    @Override
    public List getUpdatedListOfServers() {
        List<Server> list = new ArrayList<>();
        list.add(new Server("localhost", port));
        return list;
    }

    public void setPort(int port) {
        this.port = port;
    }
}