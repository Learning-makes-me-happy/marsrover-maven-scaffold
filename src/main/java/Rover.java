public class Rover {
    public static final String EAST = "E";
    public static final String SOUTH = "S";
    public static final String WEST = "W";
    public static final String NORTH = "N";
    private Area area;
    private int x;
    private int y;
    private String orientation;

    public void land(Area area, int x, int y, String orientation) {
        this.area = area;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public String getPosition() {
        return "" + x + y + orientation;
    }

    public void move() {
        if (x < area.getAreaX() && y < area.getAreaY()) {
            if (orientation.equals(EAST)) {
                x++;
            } else if (orientation.equals(WEST)) {
                x--;
            } else if (orientation.equals(NORTH)) {
                y++;
            } else if (orientation.equals(SOUTH)) {
                y--;
            }
        } else {
            throw new IllegalArgumentException("out of bound !");
        }
    }

    public void turnLeft() {
        if (orientation.equals(EAST)) {
            this.orientation = NORTH;
        } else if (orientation.equals(SOUTH)) {
            this.orientation = EAST;
        } else if (orientation.equals(WEST)) {
            this.orientation = SOUTH;
        } else if (orientation.equals(NORTH)) {
            this.orientation = WEST;
        }
    }

    public void turnRight() {
        if (orientation.equals(EAST)) {
            this.orientation = SOUTH;
        } else if (orientation.equals(SOUTH)) {
            this.orientation = WEST;
        } else if (orientation.equals(WEST)) {
            this.orientation = NORTH;
        } else if (orientation.equals(NORTH)) {
            this.orientation = EAST;
        }
    }
}
