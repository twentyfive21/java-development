package hotelOperations;

public class Hotel {

    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuite;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuite, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuite = bookedSuite;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    /*
     * Attempts to book a room based on the given parameters.
     *
     * @param numberOfRooms The number of rooms to book.
     * @param isSuite: A boolean indicating whether the requested room is a suite or not.
     * @return True if the room(s) could be booked, false otherwise.
     */
    public boolean bookRoom(int numberOfRooms, boolean isSuite){
        // Check if the requested room is a suite
        if (isSuite) {
            // Check if there are available suites and if the requested number of rooms can be accommodated
            if (numberOfSuites > bookedSuite && numberOfRooms <= numberOfSuites - bookedSuite) {
                // Book the suite room(s) and update the booked suite count
                bookedSuite += numberOfRooms;
                return true; // Return true indicating successful booking
            } else {
                return false; // Return false indicating unable to book the room(s)
            }
        } else { // If the requested room is not a suite
            // Check if there are available basic rooms and if the requested number of rooms can be accommodated
            if (numberOfRooms <= numberOfRooms - bookedBasicRooms) {
                // Book the basic room(s) and update the booked basic room count
                bookedBasicRooms += numberOfRooms;
                return true; // Return true indicating successful booking
            } else {
                return false; // Return false indicating unable to book the room(s)
            }
        }
    }


    public int getAvailableSuites(){
    return numberOfSuites = bookedSuite;
    }

    public int getAvailableRooms(){
        return numberOfRooms - bookedBasicRooms;
    }
}
