package com.company;

import java.util.*;

/**
 * Need to store the strings in distributed cache
 * Based on string, first get the hash value using function getHashValue
 * Based on hashvalue, use mod function to get the node where the string is stored
 */
public class ConsistenHashing {
    private List<ServerNode> servers = new ArrayList<>();
    private NavigableMap<Integer, String> hashCircle = new TreeMap<Integer, String>();

    ConsistenHashing(){
        placeServersOnRing();
    }

    long getHashValue(String str) {
        long result = 0;
        String strLowerCase = str.toLowerCase();
        for (int i=0;i<strLowerCase.length();i++) {
            result += strLowerCase.charAt(i)*(i+1);
        }
        System.out.println(result);
        return result;
    }

    String serverNodeAssignedForValue(String str) {
        long hashValue = getHashValue(str);
        int hashModValue = (int) (hashValue % 360);
        //hashCircle.put(hashModValue, "str");
        Map.Entry<Integer, String> next = hashCircle.higherEntry(hashModValue);
        if (next != null) {
            String serverWithLabel =  next.getValue();
            System.out.println("key: " + str + " Hash value: " + hashValue + " Mod Value: " + hashModValue + " Server with label: " + next.getValue() + " Server Name: " + serverWithLabel.charAt(0))  ;
            return next.getValue();
        } else {
            System.out.println("key: " + str + " Hash value: " + hashValue + " Mod Value: " + hashModValue + " Server Name: deault which is A");
            System.out.println("Returning the default value");
            return "A";
        }
    }

    void addServer(ServerNode serverNode) {
        servers.add(serverNode);
        placeServersOnRing();
    }

    void removeServer(ServerNode serverNode) {
        Iterator hashCircleIterator = hashCircle.entrySet().iterator();
        while (hashCircleIterator.hasNext()) {
            Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) hashCircleIterator.next();
            if (getServerName(serverNode.serverName).equals(entry.getValue())) {
                hashCircle.remove(entry.getKey(), entry.getValue());
            }
        }
    }

    String getServerName(String serverNameWithLabel){
        char serverName = serverNameWithLabel.charAt(0);
        return Character.toString(serverName);
    }

    void placeServersOnRing() {
        servers.add(new ServerNode("A", 3));
        servers.add(new ServerNode("B", 3));
        servers.add(new ServerNode("C", 3));
        servers.add(new ServerNode("D", 3));
        int numOfLabels = 0;
        for (int i =0; i< servers.size(); i++) {
            numOfLabels += servers.get(i).weight;
        }

        //Assuming all the nodes has same weight
        int serversWeight = servers.get(0).weight;
        int currentLabel = 0;

        for (int label = 0; label< serversWeight; label++) {
            for (int server = 0; server< servers.size(); server++) {
                System.out.println("Entry going to be added: " + currentLabel ++* 360/(numOfLabels) + " " + servers.get(server).serverName + Integer.toString(label+1));
                hashCircle.put(currentLabel* 360/(numOfLabels), servers.get(server).serverName + Integer.toString(label+1));
            }
        }
        Iterator circleIterator = hashCircle.entrySet().iterator();
        while (circleIterator.hasNext()) {
            Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) circleIterator.next();
            System.out.println(entry.getValue() + " " + entry.getKey() );
        }
    }
}

class ServerNode {
    String serverName;
    int weight;

    public ServerNode(String serverName, int weight) {
        this.serverName = serverName;
        this.weight = weight;
    }
}