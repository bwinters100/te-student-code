package com.techelevator;

public class Television {
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void turnOff(){
        isOn = false;
    }
    public void turnOn(){
        isOn = true;
    }
    public void changeChannel(int newChannel){
        if(isOn && (newChannel >= 3 && newChannel <= 18)) {
            currentChannel = newChannel;
        }

    }
    public void channelUp(){
        if(isOn)
        currentChannel++;
        if(currentChannel > 18){
            currentChannel = 3;
        }
    }
    public void channelDown(){
        if(isOn)
            currentChannel--;
        if(currentChannel < 3){
            currentChannel = 18;
        }
    }
    public void raiseVolume(){
        if(isOn && currentVolume < 10)
        currentVolume++;
    }
    public void lowerVolume(){
        if(isOn && currentVolume > 0)
        currentVolume--;
    }

}
