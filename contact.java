/*
 * Author: Connor Brereton
 * Course: CS320 - Testing & QA
 * Date: July 15th, 2021
 */

public class Contact {

    private static final int CONTACT_PHONENUM_LENGTH = 10;
    private static final byte CONTACT_ID_LENGTH = 10;
    private static final byte CONTACT_FNAME_LENGTH = 10;
    private static final byte CONTACT_LNAME_LENGTH = 10;
    private static final byte CONTACT_ADDRESS_LENGTH = 30;
    private static final String INITIALIZER = "CONNOR";
    private static final String INITIALIZER_NUM = "1234567890";
    private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // build the contact.
    Contact() {
        this.contactId = INITIALIZER;
        this.firstName = INITIALIZER;
        this.lastName = INITIALIZER;
        this.phoneNumber = INITIALIZER_NUM;
        this.address = INITIALIZER;
    }

    // build the contact id.
    Contact(String contactId) {
        updateContactId(contactId);
        this.firstName = INITIALIZER;
        this.lastName = INITIALIZER;
        this.phoneNumber = INITIALIZER_NUM;
        this.address = INITIALIZER;
    }

    // build the contact id and first name
    Contact(String contactId, String firstName) {
        updateContactId(contactId);
        updateFirstName(firstName);
        this.lastName = INITIALIZER;
        this.phoneNumber = INITIALIZER_NUM;
        this.address = INITIALIZER;
    }

    // build the contact id, first name, last name, and phone number with address.
    Contact(String contactId, String firstName, String lastName) {
        updateContactId(contactId);
        updateFirstName(firstName);
        updateLastName(lastName);
        this.phoneNumber = INITIALIZER_NUM;
        this.address = INITIALIZER;
    }

    // build the contact id, first name, last name, and phone number with address.
    Contact(String contactId, String firstName, String lastName, String phoneNumber) {
        updateContactId(contactId);
        updateFirstName(firstName);
        updateLastName(lastName);
        updatePhoneNumber(phoneNumber);
        this.address = INITIALIZER;
    }

    // build the contact id, first name, last name, and phone number with address.
    Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        updateContactId(contactId);
        updateFirstName(firstName);
        updateLastName(lastName);
        updatePhoneNumber(phoneNumber);
        updateAddress(address);
    }

    // Getters.
    protected final String getContactId() {
        return contactId;
    }

    protected final String getFirstName() {
        return firstName;
    }

    protected final String getLastName() {
        return lastName;
    }

    protected final String getPhoneNumber() {
        return phoneNumber;
    }

    protected final String getAddress() {
        return address;
    }

    // Updaters.
    protected void updateFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("The first name cannot be empty.");
        } else if (firstName.length() > CONTACT_FNAME_LENGTH) {
            throw new IllegalArgumentException(
                    "The first name cannot be longer than " + CONTACT_FNAME_LENGTH + " characters.");
        } else {
            this.firstName = firstName;
        }
    }

    protected void updateLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("The last name cannot be empty.");
        } else if (lastName.length() > CONTACT_LNAME_LENGTH) {
            throw new IllegalArgumentException(
                    "The last name cannot be longer than " + CONTACT_LNAME_LENGTH + " characters");
        } else {
            this.lastName = lastName;
        }
    }

    protected void updatePhoneNumber(String phoneNumber) {
        String regex = "[0-9]+";
        if (phoneNumber == null) {
            throw new IllegalArgumentException("The phone number cannot be empty.");
        } else if (phoneNumber.length() != CONTACT_PHONENUM_LENGTH) {
            throw new IllegalArgumentException(
                    "The phone number length is invalid - make it " + CONTACT_PHONENUM_LENGTH + " digits.");
        } else if (!phoneNumber.matches(regex)) {
            throw new IllegalArgumentException("The phone number must only be numbers.");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    protected void updateAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("The address cannot be empty.");
        } else if (address.length() > CONTACT_ADDRESS_LENGTH) {
            throw new IllegalArgumentException(
                    "The address cannot be longer than " + CONTACT_ADDRESS_LENGTH + " characters");
        } else {
            this.address = address;
        }
    }

    protected void updateContactId(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("The contact ID cannot be empty");
        } else if (contactId.length() > CONTACT_ID_LENGTH) {
            throw new IllegalArgumentException(
                    "The contact ID cannot be longer than " + CONTACT_ID_LENGTH + " characters");
        } else {
            this.contactId = contactId;
        }
    }
}