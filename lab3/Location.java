/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }
    
    /** Compares this Location to another. **/
    public boolean equals(Object obj) {
        
        // Входит obj в Location?
        if (obj instanceof Location) {
            //Создаем новый obj в Location и затем сравниваем
            Location other = (Location) obj;
            if (xCoord == other.xCoord && yCoord == other.yCoord) {
                return true;
            }
        }
        return false;
    }

    /** Provides a hashCode for each Location. **/
    public int hashCode() {
        int result = 7; // рандомное простое

        // еще одно рандомное
        result = 13 * result + xCoord;
        result = 13 * result + yCoord;
        return result;
    }
}
