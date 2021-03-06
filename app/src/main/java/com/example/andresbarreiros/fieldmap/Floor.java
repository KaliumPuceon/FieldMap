package com.example.andresbarreiros.fieldmap;
/**
 * Created by Nyashadzaishe Bryan on 26/1/2018.
 */

import java.util.List;
import java.util.ArrayList;

public class Floor{

    /*
     *
     * The floor object is generated to store the database of mac addresses
     * locally while the program is running. It allows the fingerprinting
     * system to drill down in both structure and complexity to figure out
     * which room the user is in. In the final prototype, areas and rooms
     * were merged into a single unit, this is not reflected outside the
     * database itself.
     *
     */

    /*
     *
     * Object Structure:
     *
     * A Floor has a name and many Rooms
     * - A Room has a unique ID, a name, and many Areas
     *   -An Area has a unique ID, and an array of Mac Addresses
     *      -A Mac has a max strength, a min strength and an address
     *
     * The Database handler creates an object representing an entire floor at a
     * time, which is used by the rest of the program. This data is horrifically
     * incomplete and could be Really, Really improved if we had more time.
     *
     */

    private List<Room> listOfRooms;
    private int floorID;
    private String floorName;

    public Floor(){
        this.listOfRooms = new ArrayList<Room>();
    }

    /* Setter methods */

    public void addRoom(Room newRoom){ this.listOfRooms.add(newRoom);  }

    public void setFloorID(int ID){
        this.floorID = ID;
    }

    public void setFloorName(String name){
        this.floorName = name;
    }

    /*Getter Methods */

    public List<Room> getRooms(){
        return this.listOfRooms;
    }

    public int getFloorID(){
        return this.floorID;
    }

    public String getFloorName(){
        return this.floorName;
    }

    /* Other Methods */

    public boolean contains(Room room){
        return this.listOfRooms.contains(room);
    }

    public String toString(){
        return this.getFloorName();
    }
    /* Room Class */

    class Room{ //Room Class Starts here

        private List<Area> listOfAreas = new ArrayList<Area>();
        private int roomID;
        private String roomName;

        Room(){
        }

        Room(int ID){
            this.roomID = ID;
        }

        Room(int ID, String name){
            this.roomID = ID;
            this.roomName = name;
        }

        /* Setter methods */

        public void addArea(Area newArea){
            this.listOfAreas.add(newArea);
        }

        public void setRoomID(int ID){
            this.roomID = ID;
        }

        public void setRoomName(String name){
            this.roomName = name;
        }

        /* Getter Methods */

        public List<Area> getAreas(){
            return this.listOfAreas;
        }

        public int getRoomID(){
            return this.roomID;
        }

        public String getRoomName(){
            return this.roomName;
        }

        /* Other methods */

        public boolean equals(Object other){
            if (this.getClass() == other.getClass()){

                if(this.roomID == ((Room)other).roomID) return true;
                else return false;
            }
            else return false;
        }

    }

    //Room Class Ends

    class Area{ //Area Class starts here

        private List<Mac> listOfMacs = new ArrayList<Mac>();
        private int areaID;

        Area(){
        }

        Area(int ID){
            this.areaID = ID;
        }

        /* Setter Methods */

        public void addMac(Mac newMac){
            this.listOfMacs.add(newMac);
        }

        public void setAreaID(int ID){
            this.areaID = ID;
        }

        /* Getter Methods */

        public List<Mac> getMacs(){
            return this.listOfMacs;
        }

        public int getAreaID(){
            return this.areaID;
        }

        /* Other Methods */

        public boolean equals (Object other){
            if (this.getClass() == other.getClass()){
                if (this.areaID == ((Area)other).areaID) return true;
                else return false;
            }
            else return false;
        }
    }

    //Area Class ends her

    class Mac{ //Mac class starts here

        private String address;
        private int highRead;
        private int lowRead;

        Mac(String address,int highRead,int lowRead){
            this.address = address;
            this.highRead = highRead;
            this.lowRead = lowRead;
        }

        Mac(){

        }

        /*Getter Methods */

        public String getAddress(){
            return this.address;
        }

        public int getHighRead(){
            return this.highRead;
        }

        public int getLowRead(){
            return this.lowRead;
        }

        /* Setter Methods */

        public void setAddress(String address) {
            this.address = address;
        }

        public void setHighRead(int highRead) {
            this.highRead = highRead;
        }

        public void setLowRead(int lowRead) {
            this.lowRead = lowRead;
        }
    }
    //Mac Class ends here
}
