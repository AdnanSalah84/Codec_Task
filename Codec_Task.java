/**
 * Codec_Task
 */
public class Codec_Task {
    
    Integer x = 1;
    Integer y = 1;
    String Face = "N";

    Integer x_max = 5;
    Integer y_max = 5;

    public void setPosition(Integer x, Integer y) {
        x_max = x;
        y_max = y;
    }
    
    public void printPosition() {
        System.out.println(x + "," + y + "," + Face);
    }
    
    public void process(String commands) {
        for (int idx = 0; idx < commands.length(); idx++) {
            process(commands.charAt(idx));
        }
    }
    
    private void process(Character command) {
        
        if (command.equals('L') || command.equals('R')) {
            if (Face == "N") {
                if (command.equals('L')) {
                    Face = "W";
                } else if (command.equals('R')) {
                    Face = "E";
                }
            } else if (Face == "E") {
                if (command.equals('L')) {
                    Face = "N";
                } else if (command.equals('R')) {
                    Face = "S";
                }
            } else if (Face == "S") {
                if (command.equals('L')) {
                    Face = "E";
                } else if (command.equals('R')) {
                    Face = "W";
                }
            } else if (Face == "W") {
                if (command.equals('L')) {
                    Face = "S";
                } else if (command.equals('R')) {
                    Face = "N";
                }
            }
    
        } else {
    
            if (command.equals('F') && Face == "N") {
                if (y < y_max)
                    y++;
            } else if (command.equals('F') && Face == "E") {
                if (x < x_max)
                    x++;
    
            } else if (command.equals('F') && Face == "S") {
                if (y > 0)
                    y--;
    
            } else if (command.equals('F') && Face == "W") {
                if (x > 0)
                    x--;
            }
        }
    }

    public static void main(String[] args) {
        Codec_Task CT = new Codec_Task();

        CT.setPosition(5, 5);
        CT.process("FFRFLFLF");
        CT.printPosition(); // prints 1,4,W
    }
}