// package com.example;

// import static org.junit.Assert.assertTrue;
// import org.junit.Test;

// public class MontyHallSimulationTest {
//     @Test
//     public void testAlwaysSwitchStrategy() {
//         MontyHallSimulation simulation = new MontyHallSimulation();
//         AlwaysSwitchStrategy strategy = new AlwaysSwitchStrategy();
//         int wins = simulation.runSimulation(strategy);
        
//         assertTrue("Победы при переключении должны быть > 50%", wins > 500);
//     }

//     @Test
//     public void testNeverSwitchStrategy() {
//         MontyHallSimulation simulation = new MontyHallSimulation();
//         NeverSwitchStrategy strategy = new NeverSwitchStrategy();
//         int wins = simulation.runSimulation(strategy);
        
//         assertTrue("Победы без переключения должны быть < 50%", wins < 500);
//     }
// }


package com.example;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MontyHallSimulationTest {
    @Test
    public void testAlwaysSwitchStrategy() {
        MontyHallSimulation simulation = new MontyHallSimulation();
        AlwaysSwitchStrategy strategy = new AlwaysSwitchStrategy();
        int wins = simulation.runSimulation(strategy);
        
        assertTrue("Победы при переключении должны быть > 50%", wins > 500);
    }

    @Test
    public void testNeverSwitchStrategy() {
        MontyHallSimulation simulation = new MontyHallSimulation();
        NeverSwitchStrategy strategy = new NeverSwitchStrategy();
        int wins = simulation.runSimulation(strategy);
        
        assertTrue("Победы без переключения должны быть < 50%", wins < 500);
    }

    //  Вставляем новый тест для проверки точности стратегии! 
    @Test
    public void testStrategyAccuracy() {
        MontyHallSimulation simulation = new MontyHallSimulation();
        AlwaysSwitchStrategy switchStrategy = new AlwaysSwitchStrategy();
        NeverSwitchStrategy neverSwitchStrategy = new NeverSwitchStrategy();
        
        int switchWins = simulation.runSimulation(switchStrategy);
        int neverWins = simulation.runSimulation(neverSwitchStrategy);
        
        assertTrue("Ожидаем около 66% побед при переключении", switchWins > 600);
        assertTrue("Ожидаем около 33% побед без переключения", neverWins < 400);
    }
}
