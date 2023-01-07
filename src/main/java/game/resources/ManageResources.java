package game.resources;

public abstract class ManageResources {
    private static int[][] resourcesStorage = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};


    public static int[] getResourcesRoom1() {
        return resourcesStorage[0];
    }

    public static int[] getResourcesRoom2() {
        return resourcesStorage[1];
    }

    public static int[] getResourcesRoom3() {
        return resourcesStorage[2];
    }

    public static int[] getResourcesRoom4() {
        return resourcesStorage[3];
    }

    public static int[] getResourcesRoom5() {
        return resourcesStorage[4];
    }

    public static int[] getResourcesRoom6() {
        return resourcesStorage[5];
    }

    public static int[] getResourcesRoom7() {
        return resourcesStorage[6];
    }

    public static int[] getResourcesRoom8() {
        return resourcesStorage[7];
    }

    public static int[] getResourcesRoom9() {
        return resourcesStorage[8];
    }

    public static int[] getResourcesRoom10() {
        return resourcesStorage[9];
    }

    public static int[] getResourcesRoom11() {
        return resourcesStorage[10];
    }

    public static int[] getResourcesRoom12() {
        return resourcesStorage[11];
    }

    public static int[] getResources(int id) { return resourcesStorage[id - 1]; };

    public static void addResourcesToStorage(int room, int quality, int amount) {
        resourcesStorage[room - 1][quality - 1] += amount;
    }

    public static void removeResourcesFromStorage(int room, int quality, int amount) {
        resourcesStorage[room - 1][quality - 1] -= amount;
    }

    public static void reset() {
        resourcesStorage = new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    }
}
