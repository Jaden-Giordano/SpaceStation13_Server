package org.psigames.ssserver.tools;

import java.io.Serializable;
import java.net.InetAddress;

/**
 * Created by Jaden on 9/12/2015.
 */
public class DataPacket implements Serializable {

    private static final long serialVersionUID = -968353828490582330L;

    /** Instruction for destination */
    public String function;

    /** Parameters for instruction */
    public Serializable[] params;

    /** Destination port */
    public transient int port;

    /** Destination IP */
    public transient InetAddress ip;

    /**
     * Creates a DataPacket that can be sent to another server or client using given IP address and port
     * @param function - instruction for destination
     * @param addr - address of destination
     * @param port - port of destination
     * @param parameters - parameters of destination
     */
    public DataPacket(String function, InetAddress addr, int port, Serializable... parameters) {
        this.function = function;
        this.params = parameters;
        this.port = port;
        this.ip = addr;
    }

    /**
     * Convenience method to send packet
     */
    public void send() {
        NetworkUtil.sendPacket(this);
    }

}
