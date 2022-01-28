package com.revature.services;

import com.revature.models.UserDTO;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.security.NoSuchAlgorithmException;

public class LoginService {

    private UserDAO userDAO;
    private Logger logger = LoggerFactory.getLogger("Login Service Logger");

    public LoginService() {
        userDAO = new UserDAOImpl();
    }

    public LoginService(UserDAO mockedDAO) {
        this.userDAO = mockedDAO;
    }

    public UserDTO login(String username, String password){
        if (username == null){
            logger.debug("The passed in username is null");
        }
        if (password == null){
            logger.debug("The passed in password is null");
        }

        UserDTO userFromDb = userDAO.login(username);

        if (userFromDb == null){
            logger.debug("userFromDb is null; login failed");
            return null;
        }else{
            try {
                String encryptedPass = LoginService.toHexString(LoginService.getSHA(password));

            if(encryptedPass.equals(userFromDb.password)){
                logger.info("Input password and returned password match");
                return userFromDb;
            }else{
                return null;
            }
            }catch (NoSuchAlgorithmException e){ logger.debug("Unsuccessful encryption of password");}
        }
        return null;
    }



// Java program to calculate SHA hash value


    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }




}