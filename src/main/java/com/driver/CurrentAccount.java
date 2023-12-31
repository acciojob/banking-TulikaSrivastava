package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

        super(name, balance, 5000.0); // Call the parent class (BankAccount) constructor with the provided arguments
        this.tradeLicenseId = tradeLicenseId;
        if (balance < 5000.0) {
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        if (!isLicenseIdValid()) {
            if (!rearrangeLicenseId()) {
                throw new Exception("Valid License cannot be generated");
            }
        }
    }

    private boolean isLicenseIdValid() {
        for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean rearrangeLicenseId() {
        char[] licenseIdChars = tradeLicenseId.toCharArray();
        for (int i = 0; i < licenseIdChars.length - 1; i++) {
            if (licenseIdChars[i] == licenseIdChars[i + 1]) {
                for (int j = i + 2; j < licenseIdChars.length; j++) {
                    if (licenseIdChars[i] != licenseIdChars[j]) {
                        char temp = licenseIdChars[i + 1];
                        licenseIdChars[i + 1] = licenseIdChars[j];
                        licenseIdChars[j] = temp;
                        tradeLicenseId = new String(licenseIdChars);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    }


