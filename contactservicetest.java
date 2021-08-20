/*
 * Author: Connor Brereton
 * Course: CS320 - Testing & QA
 * Date: July 15th, 2021
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
        protected String contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
        protected String tooLongContactId, tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooShortPhoneNumber,
                        tooLongAddress;

        // sets up the object creation and type casting before testing.
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

        // combination of tests in different orders.
        @Test
        void newContactTest() {
                ContactService service = new ContactService();
                service.newContact();
                assertAll("service", () -> assertNotNull(service.getContactList().get(0).getContactId()),
                                () -> assertEquals("CONNOR", service.getContactList().get(0).getFirstName()),
                                () -> assertEquals("CONNOR", service.getContactList().get(0).getLastName()),
                                () -> assertEquals("1234567890", service.getContactList().get(0).getPhoneNumber()),
                                () -> assertEquals("CONNOR", service.getContactList().get(0).getAddress()));
                service.newContact(firstNameTest);
                assertAll("service", () -> assertNotNull(service.getContactList().get(1).getContactId()),
                                () -> assertEquals(firstNameTest, service.getContactList().get(1).getFirstName()),
                                () -> assertEquals("CONNOR", service.getContactList().get(1).getLastName()),
                                () -> assertEquals("1234567890", service.getContactList().get(1).getPhoneNumber()),
                                () -> assertEquals("CONNOR", service.getContactList().get(1).getAddress()));
                service.newContact(firstNameTest, lastNameTest);
                assertAll("service", () -> assertNotNull(service.getContactList().get(2).getContactId()),
                                () -> assertEquals(firstNameTest, service.getContactList().get(2).getFirstName()),
                                () -> assertEquals(lastNameTest, service.getContactList().get(2).getLastName()),
                                () -> assertEquals("1234567890", service.getContactList().get(2).getPhoneNumber()),
                                () -> assertEquals("CONNOR", service.getContactList().get(2).getAddress()));
                service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
                assertAll("service", () -> assertNotNull(service.getContactList().get(3).getContactId()),
                                () -> assertEquals(firstNameTest, service.getContactList().get(3).getFirstName()),
                                () -> assertEquals(lastNameTest, service.getContactList().get(3).getLastName()),
                                () -> assertEquals(phoneNumberTest, service.getContactList().get(3).getPhoneNumber()),
                                () -> assertEquals("CONNOR", service.getContactList().get(3).getAddress()));
                service.newContact(firstNameTest, lastNameTest, phoneNumberTest, addressTest);
                assertAll("service", () -> assertNotNull(service.getContactList().get(4).getContactId()),
                                () -> assertEquals(firstNameTest, service.getContactList().get(4).getFirstName()),
                                () -> assertEquals(lastNameTest, service.getContactList().get(4).getLastName()),
                                () -> assertEquals(phoneNumberTest, service.getContactList().get(4).getPhoneNumber()),
                                () -> assertEquals(addressTest, service.getContactList().get(4).getAddress()));
        }

        // test that the contact is properly deleted.
        @Test
        void deleteContactTest() {
                ContactService service = new ContactService();
                service.newContact();
                assertThrows(Exception.class, () -> service.deleteContact(contactId));
                assertAll(() -> service.deleteContact(service.getContactList().get(0).getContactId()));
        }

        // test that the first name updated.
        @Test
        void updateFirstNameTest() throws Exception {
                ContactService service = new ContactService();
                service.newContact();
                service.updateFirstName(service.getContactList().get(0).getContactId(), firstNameTest);
                assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
                assertThrows(IllegalArgumentException.class, () -> service
                                .updateFirstName(service.getContactList().get(0).getContactId(), tooLongFirstName));
                assertThrows(IllegalArgumentException.class,
                                () -> service.updateFirstName(service.getContactList().get(0).getContactId(), null));
                assertThrows(Exception.class, () -> service.updateFirstName(contactId, firstNameTest));
        }

        // test that the last name updated.
        @Test
        void updateLastNameTest() throws Exception {
                ContactService service = new ContactService();
                service.newContact();
                service.updateLastName(service.getContactList().get(0).getContactId(), lastNameTest);
                assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
                assertThrows(IllegalArgumentException.class, () -> service
                                .updateLastName(service.getContactList().get(0).getContactId(), tooLongLastName));
                assertThrows(IllegalArgumentException.class,
                                () -> service.updateLastName(service.getContactList().get(0).getContactId(), null));
                assertThrows(Exception.class, () -> service.updateLastName(contactId, lastNameTest));
        }

        // test that the phone number updated.
        @Test
        void updatePhoneNumberTest() throws Exception {
                ContactService service = new ContactService();
                service.newContact();
                service.updatePhoneNumber(service.getContactList().get(0).getContactId(), phoneNumberTest);
                assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber());
                assertThrows(IllegalArgumentException.class, () -> service
                                .updatePhoneNumber(service.getContactList().get(0).getContactId(), tooLongPhoneNumber));
                assertThrows(IllegalArgumentException.class,
                                () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(),
                                                tooShortPhoneNumber));
                assertThrows(IllegalArgumentException.class, () -> service
                                .updatePhoneNumber(service.getContactList().get(0).getContactId(), contactId));
                assertThrows(IllegalArgumentException.class,
                                () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), null));
                assertThrows(Exception.class, () -> service.updatePhoneNumber(contactId, lastNameTest));
        }

        // test that the address updated.
        @Test
        void updateAddressTest() throws Exception {
                ContactService service = new ContactService();
                service.newContact();
                service.updateAddress(service.getContactList().get(0).getContactId(), addressTest);
                assertEquals(addressTest, service.getContactList().get(0).getAddress());
                assertThrows(IllegalArgumentException.class, () -> service
                                .updateAddress(service.getContactList().get(0).getContactId(), tooLongAddress));
                assertThrows(IllegalArgumentException.class,
                                () -> service.updateAddress(service.getContactList().get(0).getContactId(), null));
                assertThrows(Exception.class, () -> service.updateAddress(contactId, addressTest));
        }
}