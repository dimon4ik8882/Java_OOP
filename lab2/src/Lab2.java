import java.util.*;
import java.lang.*;

public class Lab2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Координаты первой точки: ");
        String scan1 = in.nextLine();
        System.out.print("Координаты второй точки: ");
        String scan2 = in.nextLine();
        System.out.print("Координаты третьей точки: ");
        String scan3 = in.nextLine();
        String[] split1 = scan1.split(" ");
        String[] split2 = scan2.split(" ");
        String[] split3 = scan3.split(" ");
        Point3d a = new Point3d(Double.parseDouble(split1[0]),Double.parseDouble(split1[1]),Double.parseDouble(split1[2]));
        Point3d b = new Point3d(Double.parseDouble(split2[0]),Double.parseDouble(split2[1]),Double.parseDouble(split2[2]));
        Point3d c = new Point3d(Double.parseDouble(split3[0]),Double.parseDouble(split3[1]),Double.parseDouble(split3[2]));
        if (a.equal(b) || b.equal(c) || c.equal(a)) {
            System.out.println("Треугольник построить невозможно, есть равные точки");
            System.exit(0);
        }
        double square = computeArea(a, b, c);
        System.out.printf("Площадь треугольника: %.4f\n", square);
    }

    public static double computeArea(Point3d point0, Point3d point1, Point3d point2) {
        double j = point0.distanceTo(point1);
        double k = point1.distanceTo(point2);
        double l = point0.distanceTo(point2);
        double s = (j + k + l)/2;
        return Math.sqrt(s * (s - j) * (s - k) * (s - l));
    }
}
