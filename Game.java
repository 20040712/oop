import java.util.Scanner;
import javax.swing.text.Position;

public class Game {
    private static Inventory inventory = new Inventory();
    private static Score score = new Score(0);  
    private static Map map = new Map(10, 6);  
    private static Position playerPosition = new Position(0, 0);
    private static boolean guardDefeated = false; 

    public static void main(String[] args) {

        Room room101 = new Room("101", "hall,There was a key, silenced pistols and a key to room 102.", '1', new Position(0, 0), "101", false);
        Room room102 = new Room("102", "There was a security key and a key to room 103.", '2', new Position(0, 1), "102", false);
        Room room103 = new Room("103", "There was a key to room 201 .", '3', new Position(0, 2), "103", false);
        Room room201 = new Room("201", "Second floor room. Guards suddenly appear! There was a key ", '4', new Position(1, 0), "201", true); 
        Room room202 = new Room("202", "There was a security key and a key to room 203.", '5', new Position(1, 1), "202", false);
        Room room203 = new Room("203", "There was a key to room 301 .", '6', new Position(1, 2), "203", false);
        Room room301 = new Room("301", "There was a key to room 301 and a security key.", '7', new Position(2, 0), "301", false);
        Room room302 = new Room("302", "There was a key to room 303.", '8', new Position(2, 1), "302", false);
        Room room303 = new Room("303", "There was a key to floor 4 room 401 and a last security key.", '9', new Position(2, 2), "303", false);
        Room room401 = new Room("401", "Console, insert five keys, and press the nuke destruction activation button.", '0', new Position(3, 0), "401", false);

        
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println("Current position: " + playerPosition.x + ", " + playerPosition.y);
            System.out.println("Input command（For example：look, move north, search 101）：");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "quit":
                    System.out.println("Game over！");
                    gameRunning = false;
                    break;
                case "look":
                    System.out.println("you are in a room:" + room201.getRoomNumber());
                    System.out.println(room201.getDescription());
                    break;
                case "move north":
                    playerPosition.y--;
                    break;
                case "move south":
                    playerPosition.y++;
                    break;
                case "move east":
                    playerPosition.x++;
                    break;
                case "move west":
                    playerPosition.x--;
                    break;
                case "search 101":
                    inventory.addItem("silenced pistols");
                    inventory.addItem("a key to room 102");
                    score.visitRoom(); 
                    System.out.println("You found the silencer pistol in room 101 and a key to room 102!");
                    break;
                case "search 102":
                    inventory.addItem("the first security key");
                    inventory.addItem("a key to room 103");
                    score.visitRoom(); 
                    System.out.println("You found a security key and a key to the room 193!");
                    break;
                case "search 201":
                    if (room201.hasGuard()) {
                        System.out.println("Suddenly, the guard appeared and drew his gun and fired!!");
                        System.out.println("You must react!input 'fight' to fight,or input 'run' to run:");
                        String response = scanner.nextLine().toLowerCase();  
                        

                        if (response.equals("fight")) {
                            System.out.println("You managed to defeat the guard!");
                            guardDefeated = true;
                            inventory.addItem("a key to room 202");
                        } else if (response.equals("run")) {
                            System.out.println("You chose to run. Back to safety!");
                            playerPosition = new Position (0,0);
                        } else {
                            System.out.println("Invalid command. The guards are still threatening you!");
                        }
                    } else {
                        inventory.addItem("a key to room 202");
                        score.visitRoom();
                        System.out.println("You found the key to 202 in room 201!");
                    }
                    break;
                
                case "inventory":
                    System.out.println("Your things: " + inventory.displayInventory());
                    break;
                case "search 401":
                    if (score.canDestroyNuclearButton()) {
                        System.out.println("You hit the destroy button. Game won! \n");
                        System.out.println("Peace to the world. Game over!");
                        gameRunning = false; 
                    } else {
                        System.out.println("You haven't explored enough to hit the destroy button!");
                    }
                    break;
                default:
                    System.out.println("Invalid command, please try again.");
                    break;
            }

            if (inventory.displayInventory().contains("the last security key") && gameRunning) {
                System.out.println("You've collected all the keys and are ready to destroy the nuclear warheads!");
            }

            System.out.println("Current score: " + score.getScore());
        }
        scanner.close();
    }
}
