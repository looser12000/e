package edu.kit.informatik;

/**
 * models an advent calendar
 * @author uqgrm
 * @version 1.0
 */
public class AdventCalendar {
    private String[] sweets = new String[24];
    private boolean[] isOpen = new boolean[24];
    private int day;
    
    /**
     * constructor sets sweets and day
     * @param sweets
     * the sweets that go into the calendar
     */
    public AdventCalendar(String[] sweets) {
        this.sweets = sweets;
        day = 0;
    }
    
    /**
     * standard getter
     * @return
     * returns day
     */
    public int getDay( ) {
        return day;
    }
    
    /**
     * increases day by 1 if possible
     * @return
     * returns true, if day got increased
     */
    public boolean nextDay() {
        if (day < 24) {
            day++;
            return true;
        }
        else return false; 
    }
    
    /**
     * increased day by days if possible
     * @param days
     * days to increase day by
     * @return
     * returns true, if day got increased
     */
    public boolean nextDays(int days) {
        if (day <= 0) {
            return false;
        }
        else if (day + days <= 24) {
            day = day + days;
            return true;
        }
        return false;
    }
    
    /**
     * checks if the door at number is open
     * @param number
     * number of the door to check
     * @return
     * returns true, if the door is open
     */
    public boolean isDoorOpen(int number) {
        if (number <= 24 && number > 0) {
            return isOpen[number];
        }
        return false;
    }
    
    /**
     * opens door at number if possible
     * @param number
     * number of the door
     * @return
     * returns the sweet behind the door if it was closed and opens it, and null otherwise
     */
    public String openDoor(int number) {
        if (number > 24 || number < 1) {
            return null;
        }
        else if (number > day) {
            return null;
        }
        else {
            isOpen[number] = true;
            return sweets[number];
        }
    }
    
    /**
     * calculates the number of doors, that could be opened until day and are not open yet
     * @return
     * returns the number of doors, that could be opened until day and are not open yet
     */
    public int numberOfUnopenedDoors() {
        if (day > 0) {
            int count = day;
            for (int i = 1; i <= day; i++) {
                if (isOpen[i]) {
                    count--;
                }
            }
            return count;
        }
        else return 0;
    }
    
    /**
     * resets the calendar to its state directly after initialization
     */
    public void reset() {
        isOpen = new boolean[24];
        day = 0;
    }
    
    /**
     * returns the calendar as String
     */
    @Override
    public String toString() {
        String toString = "";
        for (int i = 0; i <= 23; i++) {
            if (isOpen[i]) {
                toString += "[ ]";
            }
            else {
                toString += "[" + sweets[i] + "]";
            }
            if (i == 3 || i == 7 || i == 11 || i == 15 || i == 19) {
                toString += "\n";
            }
        }
        return toString;
    }
}
