public class Ship {

    private int shipID;
    private int hitCount;
    private String status;
    private String shipName;


    public enum shipStatus {Hit, Miss, Sunk}

    public Ship(String shipName, int hitCount) {
        this.shipName = shipName;
        this.hitCount = hitCount;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipID() {
        this.shipID = shipID;
    }

    public int getShipID() {
        return shipID;
    }

}


