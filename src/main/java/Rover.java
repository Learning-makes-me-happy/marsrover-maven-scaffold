public class Rover {
    private Area area;
    private int x;
    private int y;
    private String orientation;

    public void land(Area area, int x, int y, String orientation) {
        this.area = area;
        this.x = x;
        this.y =y;
        this.orientation = orientation;
    }

    public String getPosition() {
        return ""+x+y+orientation;
    }

    public void move() {
        if(x < area.getAreaX() && y < area.getAreaY()){
            if(orientation.equals("E")){
                x++;
            }else if(orientation.equals("W")){
                x--;
            }else if(orientation.equals("N")){
                y++;
            }else if(orientation.equals("S")){
                y--;
            }
        }else{
            throw new IllegalArgumentException("out of bound !");
        }
    }

    public void turnLeft() {
        if ("E".equals(orientation)) {
            this.orientation = "N";
        } else if ("S".equals(orientation)) {
            this.orientation = "E";
        } else if ("W".equals(orientation)) {
            this.orientation = "S";
        } else if ("N".equals(orientation)) {
            this.orientation = "W";
        }
    }

    public void turnRight() {
        if ("E".equals(orientation)) {
            this.orientation = "S";
        } else if ("S".equals(orientation)) {
            this.orientation = "W";
        } else if ("W".equals(orientation)) {
            this.orientation = "N";
        } else if ("N".equals(orientation)) {
            this.orientation = "E";
        }
    }
}
