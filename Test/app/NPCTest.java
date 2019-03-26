package app;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NPCTest {

    /**
     * Tests the getName method of the NPC class. Players can select whatever name they want. This test ensures that special characters
     * and different combinations are tested.
     */
    @Test
    void getName() {
        NPC npc = new NPC("Bob", 102);
        assertEquals("Bob",npc.getName(),"Expected a name of Bob when creating a new NPC");
    }

    /**
     * Tests the setName method and changes the name of the NPC that was created. Special characters are not allowed allowed.
     * This test ensures that different combinations are tested, and that the method works as it is intended to.
     */
    @Test
    void setName() {
        NPC npc = new NPC("Bob", 102);
        NPC npc2 = new NPC("John", 102);
        npc.setName("John");
        npc2.setName("!@#$");
        assertEquals("John",npc.getName(),"Expected a name of John when changing name of the npc");
        assertEquals("John",npc2.getName(),"Expected the name not to change when setting a new name with Special Characters");
    }

    /**
     * The testConstructors method tests the different combinations that people can create an NPC with. Room numbers that are not valid and
     * names with special characters are not allowed in this test.
     */
    @Test
    void testConstructors() {
        NPC npc = new NPC("Drake",102);
        NPC npc2 = new NPC("!@#$", 102);
        NPC npc3 = new NPC("Martha Focker", 106);
        assertEquals(102,npc.getRoomNumber(),"Created an NPC with a room number 102");
        assertEquals("Drake",npc.getName(),"Created an NPC with a name Drake");
        assertEquals("",npc2.getName(),"Expected a blank name when creating NPC with special characters");
        assertEquals(0,npc3.getRoomNumber(),"Created an NPC with an invalid room number. Should default to 0");
    }

    /**
     * This tests the default constructor for the NPC class. Special characters are not allowed, as well as testing for if
     * the room number is valid or not
     */
    @Test
    void testDefaultConstructor() {
        NPC npc = new NPC("Josh");
        NPC npc3 = new NPC("Martha Focker", 208);
        assertEquals("Josh", npc.getName(), "Created an NPC with name Josh");
        assertEquals(0,npc.getRoomNumber(),"Default NPC should have no room number assigned to it. Defaults to 0");
        assertEquals(0,npc3.getRoomNumber(),"Created an NPC with an invalid room number. Should default to 0");
    }

    /**
     * Tests the getRoomNumber method in the NPC class.
     */
    @Test
    void getRoomNumber() {
        NPC npc = new NPC("Bob", 103);
        NPC npc2 = new NPC("Martha Focker", 800);
        assertEquals(103,npc.getRoomNumber(),"Created an NPC with room number 103");
        assertEquals(0,npc2.getRoomNumber(),"NPC with an invalid room number should default to 0");
    }

    /**
     * Tests the setRoomNumber of the NPC class. The method changes the NPC's room number. This tests to see if all the standards
     * of the room number change are followed, and if the room number change used a valid room number.
     */
    @Test
    void setRoomNumber() {
        NPC npc = new NPC("Bob", 102);
        NPC npc2 = new NPC("Drake", 104);
        npc.setRoomNumber(203);
        npc2.setRoomNumber(69);
        assertEquals(203,npc.getRoomNumber(),"Changed the room number of the NPC to a room number of 203");
        assertEquals(104,npc2.getRoomNumber(),"Room number should not change when setting an invalid number");
    }

    /**
     * Incomplete.
     */
    @Test
    void initializeCharacters() {
        NPC npc = new NPC("Bob", 104);
        ArrayList<NPC> dailyCharacters = new ArrayList<>();
        dailyCharacters = npc.initializeCharacters(1);
    }

    /**
     * Tests the to string method of the NPC class. Should return the name and room number of the npc.
     */
    @Test
    void testToString() {
        NPC npc = new NPC("Bob", 203);
        assertEquals("Bob 203",npc.toString(),"Expected to string to return (name (room number))");
    }


    /**
     * Incomplete
     */
    @Test
    void getDialogue() {

    }
}