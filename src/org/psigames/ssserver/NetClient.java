package org.psigames.ssserver;

import java.net.InetAddress;

/**
 * Created by Jaden on 9/12/2015.
 */
public class NetClient {

    public InetAddress ip;
    public int port, id;

    public NetClient(InetAddress i, int p, int id) {
        this.ip = i;
        this.port = p;
        this.id = id;
    }

}
