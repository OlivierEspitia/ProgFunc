package practica;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int numero = 10;
        int numero2 = 12;
        int[] numeros = {10, 20, 30, 40, 50, 20, 20};
        int[] aleatorio = {1, 2, 3, 4, 5, 6, 7, 8, 9,};
        List<Integer> numerosPo = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = List.of("1", "2", "3", "4");
        List<String> strings2 = List.of("a", "b", "codi");
        List<Integer> calificaciones = List.of(9,8,9,5,4,10,7);
        


        promedio ave = () -> {
            return (int) IntStream.of(numeros).average().orElse(0);
        };
        System.out.println(ave.CalcularPromedio());

        factorial fac = n -> {
            int resultado = 1;
            for (int i = 1; i <= n; i++) {
                resultado *= i;
            }
            return resultado;
        };

        System.out.println("Factorial de " + numero + ": " + fac.factorialNumerico(numero));

        Par p = nums -> {
            for (int num : nums) {
                if (num % 2 == 0) {
                    System.out.println(num);
                }
            }
            return 0;
        };
        p.imprimirPares(aleatorio);

        IntSupplier encontrarMayor = () -> {
            if (numeros.length == 0) {
                throw new IllegalArgumentException("El arreglo no debe estar vacío.");
            }
            return Arrays.stream(numeros).max().getAsInt();  // Uso de stream para encontrar el máximo
        };

        // Llamar a la función anónima y mostrar el resultado
        System.out.println("El número mayor es: " + encontrarMayor.getAsInt());

        IntSupplier encontrarMenor = () -> {
            if (numeros.length == 0) {
                throw new IllegalArgumentException("El arreglo no debe estar vacío.");
            }
            return Arrays.stream(numeros).min().getAsInt();
        };
        System.out.println("El numero menor es: " + encontrarMenor.getAsInt());

        IntSupplier numeroMasRepetido = () -> {
            Map<Integer, Integer> contador = new HashMap<>();
            for (int num : numeros) {
                contador.put(num, contador.getOrDefault(num, 0) + 1);
            }
            int maxCount = Collections.max(contador.values());
            for (Map.Entry<Integer, Integer> entry : contador.entrySet()) {
                if (entry.getValue() == maxCount) {
                    return entry.getKey(); // Retorna el número con la mayor frecuencia
                }
            }
            return -1; // Retorna -1 en caso de que el arreglo esté vacío o no haya un único número más repetido
        };

        List<Integer> result = numerosPo.stream() //Es importante saber que al usar cualquier metodo stream no vamos a modificar la colección original
                .map(num -> num * num) // El metodo map retorna un nuevo string
                .collect(Collectors.toList());
        System.out.println(numerosPo);
        System.out.println(result);

        List<Integer> numerosCo = strings.stream()
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());

        System.out.println(strings);
        System.out.println(numerosCo);

        strings = strings2.stream()
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(strings);

        List<Boolean> booleans = calificaciones.stream()
                .map(x -> x > 5)
                .collect(Collectors.toList());

        System.out.println(booleans);
    }
}


