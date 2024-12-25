import java.util.Arrays;
import java.util.Comparator;

public class PiecewiseLinearInterpolation {

    // Класс для представления точки (x, y)
    static class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Метод для выполнения интерполяции
    public static double interpolate(Point[] points, double x) {
        // Сначала сортируем точки по возрастанию x
        Arrays.sort(points, Comparator.comparingDouble(p -> p.x));

        // Если x меньше минимального или больше максимального, выбрасываем исключение
        if (x < points[0].x || x > points[points.length - 1].x) {
            throw new IllegalArgumentException("x вне диапазона известных точек");
        }

        // Ищем отрезок, на котором находится x
        for (int i = 0; i < points.length - 1; i++) {
            Point p1 = points[i];
            Point p2 = points[i + 1];

            if (x >= p1.x && x <= p2.x) {
                // Вычисляем значение y по формуле линейной интерполяции
                return p1.y + (x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x);
            }
        }

        // Если ничего не найдено (что маловероятно), возвращаем NaN
        return Double.NaN;
    }

    // Тестовый пример
    public static void main(String[] args) {
        // Задаем известные точки
        Point[] points = {
                new Point(1.0, 2.0),
                new Point(3.0, 4.0),
                new Point(5.0, 3.0),
                new Point(7.0, 5.0)
        };

        // Точка, которую нужно интерполировать
        double x = 4.0;

        try {
            double y = interpolate(points, x);
            System.out.println("Интерполированное значение y для x = " + x + " равно " + y);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
