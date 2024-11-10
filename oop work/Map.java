public class Map {
    private final char EMPTY = '.';
    private char[][] map;

    public Map(int width, int height) {
        map = new char[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = EMPTY;
            }
        }
    }

    public void placeRoom(Position pos, char symbol) {
        map[pos.x][pos.y] = symbol;
    }

    public String display() {
        StringBuilder mapDisplay = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                mapDisplay.append(map[i][j]).append(" ");
            }
            mapDisplay.append("\n");
        }
        return mapDisplay.toString();
    }
}


