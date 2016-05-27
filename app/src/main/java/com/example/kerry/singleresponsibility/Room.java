package com.example.kerry.singleresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kerry on 2016/5/27.
 */
public class Room {
    public float area;
    public float price;

    public Room(float area, float price) {
        this.area = area;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room [area=" + area + ", price = " + price + "]";
    }
}

class Mediator {
    List<Room> mRooms = new ArrayList<Room>();

    public Mediator() {
        for(int i=0; i<5; i++) {
            mRooms.add(new Room(14 + i, (14 + i)*150));
        }
    }
    public Room rentOut(float area, float price) {
        for(Room room : mRooms) {
            if(isSuitable(area, price, room)) {
                return room;
            }
        }
        return null;
    }
    public boolean isSuitable(float area, float price, Room room) {
        return Math.abs(room.price - price) < Tenant.diffPrice && Math.abs(room.area - area) < Tenant.diffArea;
    }
}

class Tenant {
    public float roomArea;
    public float roomPrice;
    public static final float diffPrice = 100.0001f;
    public static final float diffArea = 0.00001f;

    public void rentRoom(Mediator mediator) {
        System.out.println("租到房子啦! " + mediator.rentOut(roomArea, roomPrice));
    }

}