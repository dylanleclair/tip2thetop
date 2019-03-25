package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NPCTest {

    /**
     * Tests the getName method of the NPC class. Players can select whatever name they want. This test ensures that special characters
     * and different combinations are tested.
     */
    @Test
    void getName() {
        NPC npc = new NPC("Bob", 123);
        NPC npc2 = new NPC("!@#$", 123);
        assertEquals("Bob",npc.getName(),"Expected a name of Bob when creating a new NPC");
        assertEquals("!@#$",npc2.getName(),"Expected a name with special characters '!@#$' when creating a new NPC");
    }

    /**
     * Tests the setName method and changes the name of the NPC that was created. Special characters are allowed, as well as any name
     * that is possible. This test ensures that different combinations are tested, and that the method works as it is intended to.
     */
    @Test
    void setName() {
        NPC npc = new NPC("Bob", 123);
        NPC npc2 = new NPC("John", 123);
        npc.setName("John");
        npc2.setName("!@#$");
        assertEquals("John",npc.getName(),"Expected a name of John when changing name of the npc");
        assertEquals("!@#$",npc2.getName(),"Expected a name with special characters '!@#$' when changing names");
    }

    @Test
    void getRoomNumber() {
        NPC npc = new NPC("Bob", 123);
        assertEquals(123,npc.getRoomNumber(),"Created an NPC with room number 123");
    }

    @Test
    void setRoomNumber() {
        NPC npc = new NPC("Bob", 123);
        npc.setRoomNumber(69);
        assertEquals(69,npc.getRoomNumber(),"Changed the room number of the NPC to a room number of 69");
    }

    @Test
    void initializeCharacters() {
    }


    @Test
    void getDialogue() {
    }
}