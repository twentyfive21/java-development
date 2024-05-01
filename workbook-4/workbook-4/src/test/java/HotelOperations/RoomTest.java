package HotelOperations;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @org.junit.jupiter.api.Test
    void checkIn_only_if_room_is_not_occupied_and_dirty() {
    // arrange
       Room room =
               new Room(2, 100.00, false,false,true);
    // act
        room.checkIn();
    // assert
        assertFalse(room.isAvailable());
        assertTrue(room.isDirty());
        assertTrue(room.isOccupied());
    }

    @org.junit.jupiter.api.Test
    void checkOut_only_if_room_is_not_occupied_or_dirty_and_is_available() {
    // arrange
        Room room =
                new Room(2, 100.00, true,true,false);
    // act
        room.checkOut();
    // assert
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
        assertTrue(room.isAvailable());
    }

    @org.junit.jupiter.api.Test
    void cleanRoom_if_is_not_occupied_and_is_dirty() {
     // arrange
        Room room =
                new Room(2, 100.00, true,true,false);
     // act
        room.cleanRoom();
     // assert
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
        assertTrue(room.isAvailable());
    }
}