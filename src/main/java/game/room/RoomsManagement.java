package game.room;

public abstract class RoomsManagement {
    public static Room[] rooms = new Room[] {
            new Room("POKÓJ 1 OSOBOWY ",840, 200, 3.2, new int[] {5765, 8480, 11730}, new double[] {1, 1, 1, 0.9, 1, 1, 1.1, 1.1, 1, 1, 1, 0.9}),
            new Room("POKÓJ 2 OSOBOWY", 960, 250, 3.2, new int[] {6065, 9380, 12830}, new double[] {0.9, 1, 1, 1, 1, 1, 1.1, 1.1, 1, 1, 1, 0.9})
    };


}
