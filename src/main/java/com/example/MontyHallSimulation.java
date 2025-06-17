// package com.example;

// import java.util.Random;

// public class MontyHallSimulation {
//     private static final int NUM_ROUNDS = 1000;

//     public int runSimulation(GameStrategy strategy) {
//         int wins = 0;
//         Random random = new Random();

//         for (int i = 0; i < NUM_ROUNDS; i++) {
//             int prizeDoor = random.nextInt(3);
//             int playerChoice = random.nextInt(3);

//             int revealedDoor;
//             do {
//                 revealedDoor = random.nextInt(3);
//             } while (revealedDoor == prizeDoor || revealedDoor == playerChoice);

//             if (strategy.shouldSwitch()) {
//                 playerChoice = 3 - playerChoice - revealedDoor;
//             }

//             if (playerChoice == prizeDoor) {
//                 wins++;
//             }
//         }

//         return wins;
//     }

//     //  Вставляем `main` метод здесь! 
//     public static void main(String[] args) {
//         AlwaysSwitchStrategy strategy = new AlwaysSwitchStrategy();
//         MontyHallSimulation simulation = new MontyHallSimulation();
//         int wins = simulation.runSimulation(strategy);
        
//         System.out.println("Количество побед при переключении: " + wins);
//     }
// }

// package com.example;

// import java.util.Random;

// public class MontyHallSimulation {
//     private static final int NUM_ROUNDS = 1000;

//     public int runSimulation(GameStrategy strategy) {
//         int wins = 0;
//         Random random = new Random();

//         for (int i = 0; i < NUM_ROUNDS; i++) {
//             int prizeDoor = random.nextInt(3);
//             int playerChoice = random.nextInt(3);

//             int revealedDoor;
//             do {
//                 revealedDoor = random.nextInt(3);
//             } while (revealedDoor == prizeDoor || revealedDoor == playerChoice);

//             if (strategy.shouldSwitch()) {
//                 playerChoice = 3 - playerChoice - revealedDoor;
//             }

//             if (playerChoice == prizeDoor) {
//                 wins++;
//             }
//         }

//         return wins;
//     }

//     // Вставляем `main` метод правильно! 
//     public static void main(String[] args) {
//         NeverSwitchStrategy strategy = new NeverSwitchStrategy(); // Используем стратегию "Не переключать"
//         MontyHallSimulation simulation = new MontyHallSimulation();
//         int wins = simulation.runSimulation(strategy);
        
//         System.out.println("Количество побед без переключения: " + wins);
//     }
// }


package com.example;

import java.util.Random;

/**
 * Класс MontyHallSimulation моделирует парадокс Монти Холла.
 * Использует разные стратегии выбора.
 */
public class MontyHallSimulation {
    private static final int NUM_ROUNDS = 1000;

    /**
     * Запускает симуляцию с заданной стратегией на указанное количество раундов.
     * @param strategy Стратегия игрока (AlwaysSwitch или NeverSwitch)
     * @return Количество выигранных игр
     */
    public int runSimulation(GameStrategy strategy) {
        int wins = 0;
        Random random = new Random();

        for (int i = 0; i < NUM_ROUNDS; i++) {
            int prizeDoor = random.nextInt(3);  // Дверь с призом
            int playerChoice = random.nextInt(3);  // Выбор игрока

            // Ведущий открывает дверь без приза
            int revealedDoor;
            do {
                revealedDoor = random.nextInt(3);
            } while (revealedDoor == prizeDoor || revealedDoor == playerChoice);

            // Если стратегия требует переключения, игрок меняет выбор
            if (strategy.shouldSwitch()) {
                playerChoice = 3 - playerChoice - revealedDoor;
            }

            // Проверяем, выиграл ли игрок
            if (playerChoice == prizeDoor) {
                wins++;
            }
        }

        return wins;
    }

    //  Точка входа в программу 
    public static void main(String[] args) {
        AlwaysSwitchStrategy switchStrategy = new AlwaysSwitchStrategy();
        NeverSwitchStrategy neverSwitchStrategy = new NeverSwitchStrategy();
        
        MontyHallSimulation simulation = new MontyHallSimulation();
        int switchWins = simulation.runSimulation(switchStrategy);
        int neverWins = simulation.runSimulation(neverSwitchStrategy);
        
        System.out.println("Количество побед при переключении: " + switchWins);
        System.out.println("Количество побед без переключения: " + neverWins);
    }
}
