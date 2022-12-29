package game.room;

public abstract class RoomsManagement {
    public static Room[] rooms = new Room[] {
            new Room("POKÓJ 1 OSOBOWY ",840, 200, 3.2, new int[] {5765, 8480, 11730}, new int[] {4955, 6600, 8310}, new double[] {1, 1, 1, 0.9, 1, 1, 1.1, 1.1, 1, 1, 1, 0.9}, 1),
            new Room("POKÓJ 2 OSOBOWY", 960, 250, 3.2, new int[] {6065, 9380, 12830}, new int[] {4955, 6600, 8310}, new double[] {0.9, 1, 1, 1, 1, 1, 1.1, 1.1, 1, 1, 1, 0.9}, 1),
            new Room("POKÓJ 3 OSOBOWY", 540, 300, 3.2, new int[] {7165, 10800, 13730}, new int[] {4955, 6600, 8310}, new double[] {1, 1, 1, 1, 1, 1, 1.2, 1.2, 1, 1, 0.8, 0.8}, 1),
            new Room("APARTAMENT", 240, 450, 3.2, new int[] {10515, 15680, 21430}, new int[] {6455, 9100, 11310}, new double[] {1, 1, 0.9, 0.9, 0.8, 0.9, 1.2, 1.2, 1.1, 1, 1, 1}, 2),
            new Room("POKÓJ 3 OSOBOWY RODZINNY", 3000, 320, 3.2, new int[] {6965, 1080, 13730}, new int[] {4955, 6600, 8310}, new double[] {0.9, 0.9, 0.9, 1, 1, 1, 1.2, 1.1, 1, 1, 1, 1}, 3),
            new Room("POKÓJ 4 OSOBOWY RODZINNY", 240, 400, 3.2, new int[] {7265, 10980, 14830}, new int[] {4955, 6600, 8310}, new double[] {1, 1, 0.9, 0.9, 1, 1, 1.2, 1.2, 1, 1, 0.9, 0.9}, 3),
            new Room("CHRZCINY (20 OSÓB)", 48, 2000, 4, new int[] {0, 0, 0}, new int[] {10400, 18800, 27900}, new double[] {1.1, 1, 1, 1, 1, 0.9, 0.9, 0.9, 1, 1, 1, 1.2}, 4),
            new Room("URODZINY (50 OSÓB)", 120, 3500, 8, new int[] {0, 0, 0}, new int[] {10400, 18800, 27900}, new double[] {1.1, 1.1, 1, 1, 1, 0.9, 0.9, 0.9, 0.9, 1, 1.1, 1.1}, 4),
            new Room("WESELE (100 OSÓB)", 72, 30000, 12, new int[] {0, 0, 0}, new int[] {10400, 18800, 27900}, new double[] {1, 1, 0.8, 1, 1.1, 1.1, 1.1, 1.1, 1, 1, 0.8, 1}, 4),
            new Room("DRINK BAR", 1200, 100, 1, new int[] {0, 0, 0}, new int[] {5050, 7900, 11250}, new double[] {1, 1, 1, 1, 1, 1.1, 1.1, 1.1, 0.9, 0.9, 0.9, 1}, 4),
            new Room("KOLACJA", 1440, 30, 0.5, new int[] {0, 0, 0}, new int[] {10400, 18800, 27900}, new double[] {1.1, 1.1, 1, 1, 0.9, 0.9, 1.1, 1.1, 0.9, 0.9, 1, 1}, 4),
            new Room("ŚNIADANIE", 2040, 25, 0.5, new int[] {0, 0, 0}, new int[] {10400, 18800, 27900}, new double[] {1, 1, 1, 1.1, 1.1, 0.9, 0.9, 1, 1, 1, 1, 1}, 4)

    };



}
