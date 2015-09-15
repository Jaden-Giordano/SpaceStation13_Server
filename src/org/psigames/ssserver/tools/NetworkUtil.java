package org.psigames.ssserver.tools;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import static org.psigames.ssserver.tools.SerializableUtil.deserialize;
import static org.psigames.ssserver.tools.SerializableUtil.serialize;

/**
 * Created by Jaden on 9/12/2015.
 */
public class NetworkUtil {

    /** Socket to send and receive packets */
    private static DatagramSocket skt;

    /** Buffer received packets used before they are de-serialized */
    private static DatagramPacket recvPacket;

    /**
     * Initialize this class for use as with server
     * @param port
     */
    public static void initServer(int port) {
        try {
            skt = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        recvPacket = new DatagramPacket(new byte[1024], 1024);
    }

    /**
     * Initialize this class for use as with client
     */
    public static void initClient() {
        try {
            skt = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        recvPacket = new DatagramPacket(new byte[1024], 1024);
    }

    /**
     * Sends a DataPacket to packet's IP and port
     * @param packet
     */
    public static void sendPacket(DataPacket packet) {
        byte[] data;
        try {
            data = serialize(packet);
        } catch (IOException e) {
            data = new byte[]{0};
        }
        DatagramPacket netPacket = new DatagramPacket(data, data.length, packet.ip, packet.port);

        try {
            skt.send(netPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wait for a packet to be sent from another machine for this client/server. <br />
     * Puts the sender's IP address and port in the received packet's IP and port fields
     * @return packet with ip and port set to senders ip and port
     */
    public static DataPacket receivePacket() {
        try {
            skt.receive(recvPacket);
        } catch (IOException e) {
            e.printStackTrace();
            return new DataPacket("", null, 0);
        }
        DataPacket packet;
        try {
            packet = (DataPacket) deserialize(recvPacket.getData());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            return new DataPacket("", null, 0);
        }

        packet.ip = recvPacket.getAddress();
        packet.port = recvPacket.getPort();

        return packet;
    }

}
