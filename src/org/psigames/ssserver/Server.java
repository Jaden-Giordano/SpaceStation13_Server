package org.psigames.ssserver;

import org.psigames.ssserver.tools.DataPacket;
import org.psigames.ssserver.tools.NetworkUtil;

import java.util.ArrayList;

/**
 * Created by Jaden on 9/12/2015.
 */
public class Server {

    public static Server instance;

    private ArrayList<NetClient> clients;

    public static void main(String[] args) {
        instance = new Server();
        instance.run();
    }

    public Server() {
        clients = new ArrayList<NetClient>();
        NetworkUtil.initServer(25565);
    }

    public void run() {
        while (true) {
            DataPacket p = NetworkUtil.receivePacket();
            if (p != null) {
                // Checks if client is new or not
                boolean b = false;
                for (NetClient i : clients) {
                    if (p.equals(i.ip)) {
                        b = true;
                    }
                }
                // If client is not yet in the list of clients; Adds the client
                if (!b) {
                    clients.add(new NetClient(p.ip, p.port, clients.size()));
                }

                // Handles function
                if (p.function.equals("broadcast")) {
                    for (NetClient i : clients) {
                        DataPacket packet = new DataPacket("msg", i.ip, i.port, p.params, i.id);
                        packet.send();
                    }
                }
            }
            // Take in data from clients
            // Update Serverside objects
            // Send data to clients
        }
    }

}
