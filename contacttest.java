/*
 * Author: Connor Brereton
 * Course: CS320 - Testing & QA
 * Date: July 15th, 2021
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
    protected String contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
    protected String tooLongContactId, tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooShortPhoneNumber,
            tooLongAddress;

    @BeforeEach
    void setUp() {
        contactId = "1234567890";
        firstNameTest = "Connor";
        lastNameTest = "Brereton";
        phoneNumberTest = "4088088888";
        addressTest = "123 Main Street";
        tooLongContactId = "00112233445566778899";
        tooLongFirstName = "Connor William Connor William";
        tooLongLastName = "Brereton Brereton Brereton Brereton";
        tooLongPhoneNumber = "40888888888888";
        tooShortPhoneNumber = "408802";
        tooLongAddress = "123 Main Street San Francisco, CA, 94109";
    }

    // constructor
    @Test
    void contactTest() {
        Contact contact = new Contact();
        assertAll("constructor.", () -> assertNotNull(contact.getContactId()),
                () -> assertNotNull(contact.getFirstName()), () -> assertNotNull(contact.getLastName()),
                () -> assertNotNull(contact.getPhoneNumber()), () -> assertNotNull(contact.getAddress()));
    }

    // test the contact id
    @Test
    void contactIdConstructorTest() {
        Contact contact = new Contact(contactId);
        assertAll("constructor one.", () -> assertEquals(contactId, contact.getContactId()),
                () -> assertNotNull(contact.getFirstName()), () -> assertNotNull(contact.getLastName()),
                () -> assertNotNull(contact.getPhoneNumber()), () -> assertNotNull(contact.getAddress()));
    }

    // test the contract id and the first name with setting up tests instances
    @Test
    void contactIdAndFirstNameConstructorTest() {
        Contact contact = new Contact(contactId, firstNameTest);
        assertAll("constructor two.", () -> assertEquals(contactId, contact.getContactId()),
                () -> assertEquals(firstNameTest, contact.getFirstName()), () -> assertNotNull(contact.getLastName()),
                () -> assertNotNull(contact.getPhoneNumber()), () -> assertNotNull(contact.getAddress()));
    }

    // test the contract id and the full name with setting up tests instances
    @Test
    void contactIdAndFullNameConstructorTest() {
        Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
        assertAll("constructor three.", () -> assertEquals(contactId, contact.getContactId()),
                () -> assertEquals(firstNameTest, contact.getFirstName()),
                () -> assertEquals(lastNameTest, contact.getLastName()), () -> assertNotNull(contact.getPhoneNumber()),
                () -> assertNotNull(contact.getAddress()));
    }

    // test the contract id and the full name with setting up tests instances
    @Test
    void contactIdFullNamePhoneNumberConstructorTest() {
        Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
        assertAll("constructor four.", () -> assertEquals(contactId, contact.getContactId()),
                () -> assertEquals(firstNameTest, contact.getFirstName()),
                () -> assertEquals(lastNameTest, contact.getLastName()),
                () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
                () -> assertNotNull(contact.getAddress()));
    }

    // tests all of the proper things :)
    @Test
    void allTheProperThingsConstructorTest() {
        Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
        assertAll("constructor all.", () -> assertEquals(contactId, contact.getContactId()),
                () -> assertEquals(firstNameTest, contact.getFirstName()),
                () -> assertEquals(lastNameTest, contact.getLastName()),
                () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
                () -> assertEquals(addressTest, contact.getAddress()));
    }

    // tests for the updating of the first name
    @Test
    void updateFirstNameTest() {
        Contact contact = new Contact();
        contact.updateFirstName(firstNameTest);
        assertAll("first name: ", () -> assertEquals(firstNameTest, contact.getFirstName()),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(tooLongFirstName)));
    }

    // tests for the updating of the last name
    @Test
    void updateLastNameTest() {
        Contact contact = new Contact();
        contact.updateLastName(lastNameTest);
        assertAll("last name: ", () -> assertEquals(lastNameTest, contact.getLastName()),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(tooLongFirstName)));
    }

    // tests for the updating of the phone number
    @Test
    void updatePhoneNumberTest() {
        Contact contact = new Contact();
        contact.updatePhoneNumber(phoneNumberTest);
        assertAll("phone number: ", () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(tooLongPhoneNumber)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> contact.updatePhoneNumber(tooShortPhoneNumber)),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(contactId)));
    }

    // tests for the updating of the address
    @Test
    void updateAddressTest() {
        Contact contact = new Contact();
        contact.updateAddress(addressTest);
        assertAll("phone number: ", () -> assertEquals(addressTest, contact.getAddress()),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(tooLongAddress)));
    }

    // tests for the updating of the contact id
    @Test
    void updateContactIdTest() {
        Contact contact = new Contact();
        contact.updateContactId(contactId);
        assertAll("contact ID: ", () -> assertEquals(contactId, contact.getContactId()),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(tooLongContactId)));
    }
}