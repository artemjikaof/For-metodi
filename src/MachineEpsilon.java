public class MachineEpsilon {
    public static void main(String[] args) {
        // Инициализация машинного эпсилона
        double epsilon = 1.0;

        // Уменьшаем epsilon, пока 1.0 + epsilon != 1.0
        while (1.0 + epsilon > 1.0) {
            epsilon /= 2.0;
        }

        // Удваиваем значение, так как последнее деление сделало сумму равной 1.0
        epsilon *= 2.0;

        // Вывод машинного эпсилона
        System.out.println("Machine Epsilon: " + epsilon);
    }
}
