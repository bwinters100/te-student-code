package com.techelevator.enumeration;

public class Connection {

    // ***** connection status ************************************************
    public enum Status {
        DISCONNECTED,
        CONNECTING,
        UPDATING,
        ERROR,
        CONNECTED
    }

    // ***** member variables *************************************************

    private Status status = Status.DISCONNECTED;
    private final String name;
    private final String address;
    private int code;


    public Connection(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Update the status of the connection.
     * @param status  the status to set on this connection
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "status=" + status +
                '}';
    }
}
