public class Ship {
    private int shipID;
    private int hitCount;
    private String status;
    private String shipName;


    public enum shipStatus {Active, Sunk}
    public enum shipNames{BATTLESHIP, CRUISER, SUBMARINE, CARRIER, DESTROYER}

    public Ship(int shipID, String shipName, int hitCount, String status) {
        setShipName(shipName);
        setHitCount(hitCount);
        setShipID(shipID);
        setShipStatus(status);
    }

    //get methods
    public String getShipName() {
        return this.shipName;
    }
    public int getShipID() {
        return this.shipID;
    }

    public int getHitCount(){
        return this.hitCount;
    }
    public String getShipStatus(){
        return this.status;
    }

    //set methods
    public void setShipID(int shipID) {
        this.shipID = shipID;
    }

    public void setShipName(String shipName){
        this.shipName = shipName;
    }

    public void setHitCount(int hitCount){
        this.hitCount = hitCount;
    }
    public void setShipStatus(String status){
        this.status = status;
    }

}
