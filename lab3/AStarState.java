import java.util.*;


/**
 * This class stores the basic state necessary for the A* algorithm to compute 
 * a path across a map.  This state includes a collection of "open waypoints" 
 * and another collection of "closed waypoints."  In addition, this class 
 * provides the basic operations that the A* pathfinding algorithm needs to 
 * perform its processing.
 **/
public class AStarState
{
    /** 
     * This is a reference to the map that the A* algorithm
     * is navigating.
     **/
    private Map2D map;

    /** Initialize a map of all open waypoints and their locations. **/
    private Map<Location, Waypoint> open_waypoints
    = new HashMap<Location, Waypoint> ();
    
    /** Initialize a map of all closed waypoints and their locations. **/
    private Map<Location, Waypoint> closed_waypoints
    = new HashMap<Location, Waypoint> ();

    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this 
     * method returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        //если нет открытых вершин, возвращает null
        if (numOpenWaypoints() == 0)
            return null;

        //Инициализируем keySet для всех вершин, итератор проходится по всему списку,
        //и хранит лучшую вершину и вес до нее
        Set open_waypoint_keys = open_waypoints.keySet();
        Iterator i = open_waypoint_keys.iterator();
        Waypoint best = null;
        float best_cost = Float.MAX_VALUE;
        
        // Проходимся по всем вершинам
        while (i.hasNext())
        {
            // сохраняем текущее положение
            Location location = (Location)i.next();
            // сохраняем текущую вершину
            Waypoint waypoint = open_waypoints.get(location);
            // сохраняем общий вес все вершин
            float waypoint_total_cost = waypoint.getTotalCost();

            //Если общий вес текущей вершины меньше чес сохраненный, заменяем
            //точку и вес
            if (waypoint_total_cost < best_cost)
            {
                best = open_waypoints.get(location);
                best_cost = waypoint_total_cost;
            }
            
        }
        // возвращаем вершину с минимальным весом
        return best;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint 
     * already in) the "open waypoints" collection.  If there is not already 
     * an open waypoint at the new waypoint's location then the new waypoint 
     * is simply added to the collection.  However, if there is already a 
     * waypoint at the new waypoint's location, the new waypoint replaces 
     * the old one <em>only if</em> the new waypoint's "previous cost" value 
     * is less than the current waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // находим положение вершины
        Location location = newWP.getLocation();
        
        // Смотрим, есть ли она в закрытых или открытых вершинах
        if (open_waypoints.containsKey(location))
        {
            // Если вершина уже в списке открытых, то сравниваем веса
            Waypoint current_waypoint = open_waypoints.get(location);
            if (newWP.getPreviousCost() < current_waypoint.getPreviousCost())
            {
                // если новая меньше, заменяем, и ретерним true
                open_waypoints.put(location, newWP);
                return true;
            }
            // если больше или =, false
            return false;
        }
        // Если еще нет вершины в списке открытых ,добавить в список и вернуть true
        open_waypoints.put(location, newWP);
        return true;
    }


    /** Returns the current number of open waypoints. **/


    public int numOpenWaypoints()
    {
        return open_waypoints.size();
    }

    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/

    // Метод закрытия точки
    public void closeWaypoint(Location loc)
    {
        Waypoint waypoint = open_waypoints.remove(loc);
        closed_waypoints.put(loc, waypoint);
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    //Закрыты ли точки из списка
    public boolean isLocationClosed(Location loc)
    {
        return closed_waypoints.containsKey(loc);
    }
}