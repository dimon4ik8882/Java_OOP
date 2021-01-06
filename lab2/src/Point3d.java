public class Point3d extends Point2d{

    private double zCoord;

    public Point3d(double x, double y, double z) {
        super(x, y);
        zCoord = z;
    }

    public Point3d() {
        this (0, 0, 0);
    }
    public double getZ() {
        return zCoord;
    }

    public void setZ(double val) {
        zCoord = val;
    }

    public boolean equal(Object obj) {
        Point3d other = (Point3d) obj;
        return xCoord == other.getX() && yCoord == other.getY() && zCoord == other.getZ();
    }

    public double distanceTo(Point3d other_point) {
        return Math.sqrt(Math.pow(xCoord - other_point.getX(), 2) +
                Math.pow(yCoord - other_point.getY(), 2) +
                Math.pow(zCoord - other_point.getZ(), 2));
    }
}
