package OLD.Game;

import java.util.*;

public class Fleet {
    private enum shipsInFleet { BATTLESHIP, CRUISER, CARRIER, DESTROYER, SUBMARINE };
    private final ArrayList<Ship> ships = new ArrayList<Ship>(5);
    private int shipsRemaining;

    public Fleet(){
        setShipRemaining(ships.size());
    }

    //get methods
    public int getShipsRemaining(){
        return this.ships.size();
    }

    public ArrayList<Ship> getFleet(){
        return this.ships;
    }

    //set methods
    public void setShipRemaining(int shipsRemainingInFleet){
        this.shipsRemaining = shipsRemainingInFleet;
    }

    //other methods
    public void hitShip(Ship ship){
        ship.setHitCount(ship.getHitCount() - 1);
        if(isShipSunk(ship)){
            shipIsSunk(ship);
        }
    }

    /**
     * Remove ship from fleet when its been sunk
     * @param
     */

    public boolean isShipSunk(Ship ship){
        if(ship.getHitCount() == 0){
            return true;
        }else{
            return false;
        }
    }
    public void shipIsSunk(Ship sunkenShip){
        removeShipFromFleetByShipID(sunkenShip.getShipID());
        sunkenShip.setShipStatus(Ship.shipStatus.SUNK.toString());
    }

    public void removeShipFromFleetByShipID(int shipID){
        int index = shipID - 1;
        this.ships.remove(index);
        this.shipsRemaining--;
    }

    public void createNewFleet(){
        addNewShip(this.ships, 1, shipsInFleet.DESTROYER.toString(), 2, Ship.shipStatus.ACTIVE.toString());
        addNewShip(this.ships, 2, shipsInFleet.SUBMARINE.toString(), 3, Ship.shipStatus.ACTIVE.toString());
        addNewShip(this.ships, 3, shipsInFleet.CRUISER.toString(), 3, Ship.shipStatus.ACTIVE.toString());
        addNewShip(this.ships, 4, shipsInFleet.BATTLESHIP.toString(), 4, Ship.shipStatus.ACTIVE.toString());
        addNewShip(this.ships, 5, shipsInFleet.CARRIER.toString(), 5, Ship.shipStatus.ACTIVE.toString());
    }

    public void addNewShip(ArrayList<Ship> ships, int shipID, String shipName, int hitCount, String status){
        Ship s = new Ship(shipID, shipName, hitCount, status);
        ships.add(s);
    }
}
