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
        NPC npc = new NPC("Bob");
        assertEquals("Bob",npc.getName(),"Expected a name of Bob when creating a new NPC");
    }

    /**
     * Tests the setName method and changes the name of the NPC that was created. Special characters are not allowed allowed.
     * This test ensures that different combinations are tested, and that the method works as it is intended to.
     */
    @Test
    void setName() {
        NPC npc = new NPC("Bob");
        NPC npc2 = new NPC("John");
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
        NPC npc = new NPC("Drake");
        NPC npc2 = new NPC("!@#$");
        NPC npc3 = new NPC("Martha");
        assertEquals(0,npc.getRoomNumber(),"Created an NPC with a room number 0");
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
        NPC npc3 = new NPC("Martha");
        assertEquals("Josh", npc.getName(), "Created an NPC with name Josh");
        assertEquals(0,npc.getRoomNumber(),"Default NPC should have no room number assigned to it. Defaults to 0");
        assertEquals(0,npc3.getRoomNumber(),"Created an NPC with an invalid room number. Should default to 0");
    }

    /**
     * Tests the getRoomNumber method in the NPC class.
     */
    @Test
    void getRoomNumber() {
        NPC npc = new NPC("Bob");
        NPC npc2 = new NPC("Martha Focker");
        assertEquals(0,npc.getRoomNumber(),"Created an NPC with room number 103");
        assertEquals(0,npc2.getRoomNumber(),"NPC with an invalid room number should default to 0");
    }

    /**
     * Tests the setRoomNumber of the NPC class. The method changes the NPC's room number. This tests to see if all the standards
     * of the room number change are followed, and if the room number change used a valid room number.
     */
    @Test
    void setRoomNumber() {
        NPC npc = new NPC("Bob");
        NPC npc2 = new NPC("Drake");
        npc.setRoomNumber(203);
        npc2.setRoomNumber(69);
        assertEquals(203,npc.getRoomNumber(),"Changed the room number of the NPC to a room number of 203");
        assertEquals(0,npc2.getRoomNumber(),"Room number should not change when setting an invalid number");
    }

    /**
     *
     */
    @Test
    void testSetCheckedIn() {
        NPC npc = new NPC("Bob");
        npc.setCheckedIn(false);
        assertEquals(false,npc.isCheckedIn(),"NPC Bob has checked out, should change isCheckedIn to false");
    }

    @Test
    void testIsCheckedIn() {
        NPC npc = new NPC("Bob");
        npc.setCheckedIn(true);
        assertEquals(true,npc.isCheckedIn(),"Checked in an NPC Bob");
    }


    /**
     * Tests the to string method of the NPC class. Should return the name and room number of the npc.
     */
    @Test
    void testToString() {
        NPC npc = new NPC("Bob");
        assertEquals("Bob 0",npc.toString(),"Expected to string to return (name (room number))");
    }

    @Test
    void setBooking() {
        Booking one = new Booking("Josh",204,"King");
        Booking two = new Booking("Jim",304,"Suite");
        NPC npc = new NPC("Bob");
        NPC npc2 = new NPC("John");

        npc.setBooking(one);
        npc2.setBooking(two);
        assertEquals(one,npc.getBooking(),"Expected the same booking");
        assertEquals(two,npc2.getBooking(),"Expected the same booking");
    }

    @Test
    void testGetBooking() {
        Booking one = new Booking("Bob",104,"Deluxe");
        NPC npc = new NPC("Bob");
        npc.setBooking(one);
        assertEquals(one,npc.getBooking(),"Expected booking to be the same");
    }


}