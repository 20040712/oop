public class Room {
    private String name;
    private String description;
    private char symbol;
    private Position position;
    private String roomNumber;
    private boolean hasGuard; 

    public Room(String name, String description, char symbol, Position position, String roomNumber, boolean hasGuard) {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.position = position;
        this.roomNumber = roomNumber;
        this.hasGuard = hasGuard;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public char getSymbol() { return symbol; }
    public Position getPosition() { return position; }
    public String getRoomNumber() { return roomNumber; }
    public boolean hasGuard() { return hasGuard; } 
}

