package com.no.hallstead.gardeningapp;

import org.junit.Test;

import java.lang.reflect.GenericArrayType;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void plantTypeConstructorTest() {
        int waterFreq = 2;
        int timeToHarvest = 30;
        String name = "Carrot";
        PlantType carrotType = new PlantType(name, waterFreq, timeToHarvest);
        assertEquals(carrotType.getTimeToHarvest(), timeToHarvest);
        assertEquals(carrotType.getWaterFreq(), waterFreq);
        assertEquals(carrotType.getName(), name);
    }

    @Test
    public void plantConstructorTest() {
        PlantType carrotType = new PlantType("Carrot", 2, 30);
        GregorianCalendar carrotPlantDate = new GregorianCalendar();
        Plant carrot = new Plant(carrotType, carrotPlantDate);
        assertEquals(carrot.getName(), "Carrot");
        assertEquals(carrot.getDatePlanted(), carrotPlantDate);
    }

    @Test
    public void plantWaterTest() {
        GregorianCalendar carrotPlantDate = new GregorianCalendar();
        carrotPlantDate.add(GregorianCalendar.DAY_OF_MONTH, -2);
        PlantType carrotType = new PlantType("Carrot", 2, 30);
        Plant carrot = new Plant(carrotType, carrotPlantDate);
        carrot.water();
        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar lastWatered = carrot.getDateLastWatered();
        assertEquals(today.DAY_OF_MONTH, lastWatered.DAY_OF_MONTH);



    }

    @Test
    public void createDifferentPlantsTest() {
        GregorianCalendar potatoPlantDate = new GregorianCalendar();
        PlantType potatoType = new PlantType("Potato", 3, 40);
        Plant potato = new Plant(potatoType, potatoPlantDate);
        potatoPlantDate.add(GregorianCalendar.DAY_OF_MONTH, -2);

        GregorianCalendar tomatoPlantDate = new GregorianCalendar();
        PlantType tomatoType = new PlantType("Tomato", 2, 30);
        Plant tomato = new Plant(tomatoType, tomatoPlantDate);
        tomatoPlantDate.add(GregorianCalendar.DAY_OF_MONTH, -2);

        assert(potato != tomato);
    }


}