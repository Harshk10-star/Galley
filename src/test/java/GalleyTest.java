import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GalleyTest {

    @Test
    public void test_01(){
        Crate crate=new Crate("1");
        crate.add(new Basket());
        assertEquals("There are 0 HibalGlasses, 1 Baskets, 0 Coffe Cups, 0 WaterBottles,and 0 Hotspots", crate.getFullInfo());

        Assertions.assertThrows(RuntimeException.class, ()->{
            crate.add(new HibalGlass());
        });

    }

    @Test
    public void test_02(){
        WaterStation waterStation= new WaterStation();
        GCart i=new GCart("1");
        waterStation.addGCart(i);
        for(int k=0;k<30;k++){
            waterStation.addCrate(new Crate(""+k));

        }
        assertEquals(30,waterStation.getCrates().size());
        waterStation.makeWater("waterSmall");
        assertEquals(342,waterStation.getSmallStack().size());
        waterStation.refillStacks();
        assertEquals(30,waterStation.getSmallStack().size());


    }

    @Test
    public void test_03(){
        WaterStation waterStation=new WaterStation();
        GCart gCart=new GCart("1");
        waterStation.addGCart(gCart);
        for(int i=0;i<20;i++){
            waterStation.addCrate(new Crate(""+i));
        }
        for(int i=0;i<20;i++){
            waterStation.makeWater("waterSmall");
        }
        waterStation.fillCart("1");
        assertEquals(0,waterStation.getCrates().size());
        Crate crate= waterStation.getCrate(0,0,"1","0");
        assertEquals("0",crate.getID());
        assertEquals(null,gCart.getCrates()[0][0]);

        waterStation.addCrate(new Crate("LP"));
        waterStation.refillStacks();
        waterStation.makeWater("waterSmall");
        waterStation.addWater("1","LP",0);

        assertNotNull(gCart.getCrates()[0][0]);

    }

    @Test
    public void test_04(){
            TrollieWashingMachine trollieWashingMachine=new TrollieWashingMachine();
            trollieWashingMachine.addTrollies(new Trollie("1"));
            trollieWashingMachine.cleanTrollies();
            assertTrue(trollieWashingMachine.getCleanTrollies().get(0).isClean());
    }

    @Test
    public void test_05(){
        TrollieStation trollieStation=new TrollieStation();
        TrollieWashingMachine trollieWashingMachine=new TrollieWashingMachine();

        Ticket ticket=new Ticket();
        ticket.addItem("waterSmall");
        ticket.addItem("coffeeCup");
        ticket.addItem("Basket");
        ticket.addItem("HibalGlass");

        trollieWashingMachine.addTrollies(new Trollie(ticket,"1"));

        trollieWashingMachine.cleanTrollies();
        trollieStation.getCleanTrollies(trollieWashingMachine);

        assertTrue(trollieStation.getTrollies().get(0).isClean());

        WaterStation waterStation=new WaterStation();

        for(int i=0;i<20;i++){
            waterStation.addCrate(new Crate(""+i));
        }

        GCart gCart=new GCart("1");
        waterStation.addGCart(gCart);

        waterStation.makeWater("waterSmall");
        waterStation.fillCart("1");

        trollieStation.getWaterCart(waterStation);

        assertEquals(1,trollieStation.getSmallStack().size());
        Crate[] crates=new Crate[4];
       crates[0]=new Crate("0");
       crates[1]=new Crate("1");
       crates[2]=new Crate("2");
       crates[3]=new Crate("3");

       trollieStation.addToTrollieStation(crates,"1");

       assertTrue(trollieStation.getTrollies().get(0).hasItems());



    }
}