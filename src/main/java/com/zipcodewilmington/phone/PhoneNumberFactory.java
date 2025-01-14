package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger LOGGER = Logger.getLogger("com.zipcodewilmington.phone");

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray (int phoneNumberCount) throws InvalidPhoneNumberFormatException{
        PhoneNumber [] arrayOfPhoneNumbers = new PhoneNumber[phoneNumberCount];

        for (int i = 0; i < phoneNumberCount; i++){
            int areadCode = RandomNumberFactory.createInteger(100,999);
            int centralOfficeCode = RandomNumberFactory.createInteger(100,999);
            int phoneCOde = RandomNumberFactory.createInteger(1000,9999);

            arrayOfPhoneNumbers[i] = createPhoneNumberSafely(areadCode,centralOfficeCode,phoneCOde);
        }

        return arrayOfPhoneNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() throws InvalidPhoneNumberFormatException {
        int areaCode = RandomNumberFactory.createInteger(100,999);
        int centralOfficeCode = RandomNumberFactory.createInteger(100,999);
        int phoneCode = RandomNumberFactory.createInteger(1000,9999);

        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) throws InvalidPhoneNumberFormatException {
        String newPhoneNumber = "";

        newPhoneNumber = "(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode;

        try {
            return  createPhoneNumber(newPhoneNumber);
        } catch (InvalidPhoneNumberFormatException e){
            LOGGER.info(newPhoneNumber + " is not a valid phone number");
            return null;
        }

    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        LOGGER.info("Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);
        PhoneNumber newPhoneNumber = new PhoneNumber(phoneNumberString);
        return newPhoneNumber;

    }
}
