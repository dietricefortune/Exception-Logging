package hbcu.stay.ready.phone;

import hbcu.stay.ready.exceptions.InvalidPhoneNumberFormatException;


public final class PhoneNumber {
    private final String phoneNumberString;

    // default constructor is uncallable
    private PhoneNumber() throws InvalidPhoneNumberFormatException {
        this(null);
    }

    // non-default constructor is package-protected
    protected PhoneNumber(String phoneNumber) throws InvalidPhoneNumberFormatException {
        //validate phone number with format `(###)-###-####`
        if (!phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            throw new InvalidPhoneNumberFormatException();
        }
        this.phoneNumberString = phoneNumber;
    }

    public String getAreaCode() {
        return toString().substring(1, 4);
    }

    public String getCentralOfficeCode() {
        return toString().substring(6, 9);
    }

    public String getPhoneLineCode() {
        return toString().substring(10, 14);
}

    @Override
    public String toString() {
        return phoneNumberString;
    }


}
