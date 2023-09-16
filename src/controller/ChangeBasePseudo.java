/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Common.Library;
import java.util.HashMap;
import java.util.Map;
import model.Element;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class ChangeBasePseudo extends Menu<String> {

    Element el = new Element();
    Library lib = new Library();

    static String[] choices = {"Binary", "Decimal", "Hexadecimal"};

    public ChangeBasePseudo() {
        super("Change Base Number App", choices, "Exit");
    }

    @Override
    public void execute(int n) {

        switch (n) {
            case 1: {
                String[] mc = {"Binary", "Decimal", "Hexadecimal"};
                Menu m = new Menu("Conver BIN to another base !!! ", mc, "Exit") {
                    @Override
                    public void execute(int n) {
                        switch (n) {
                            case 1: {
                                String input = lib.checkBinary("Input binary number:");
                                System.out.println("The result when we change BIN to DEC " + input + " is:" + input);

                                break;
                            }
                            case 2: {
                                String input = lib.checkBinary("Input binary number:");
                                System.out.println("The result when we change BIN to DEC " + input + " is:" + handleBINtoDEC(input));
                                break;
                            }
                            case 3: {
                                String input = lib.checkBinary("Input binary number:");
                                System.out.println("The result when we change BIN to HEX " + input + " is:" + handleBINtoHEX(input));
                                break;
                            }
                        }
                    }
                };
                m.run();
                break;
            }

            case 2: {
                String[] mc = {"Binary", "Decimal", "Hexadecimal"};
                Menu m = new Menu("Conver BIN to another base !!! ", mc, "Exit") {
                    @Override
                    public void execute(int n) {
                        switch (n) {
                            case 1: {
                                String input = lib.checkBDecimal("Input decimal number:");
                                System.out.println("The result when we change DEC to BIN " + input + " is:" + handleDECtoBIN(input));
                                break;

                            }
                            case 2: {
                                String input = lib.checkBDecimal("Input decimal number:");
                                System.out.println("The result when we change DEC to DEC " + input + " is:" + input);
                                break;
                            }
                            case 3: {
                                String input = lib.checkBDecimal("Input decimal number:");
                                System.out.println("The result when we change DEC to HEX " + input + " is:" + handleDECtoHEX(input));
                                break;
                            }
                        }

                    }
                };
                m.run();
                break;

            }
            case 3: {
                String[] mc = {"Binary", "Decimal", "Hexadecimal"};
                Menu m = new Menu("Conver BIN to another base !!! ", mc, "Exit") {
                    @Override
                    public void execute(int n) {
                        switch (n) {
                            case 1: {
                                String input = lib.checkBDecimal("Input hexadecimal number:");
                                System.out.println("The result when we change HEX to BIN " + input + " is:" + handleHEXtoBIN(input));
                                break;

                            }
                            case 2: {
                                String input = lib.checkBDecimal("Input hexadecimal number:");
                                System.out.println("The result when we change HEX to DEC " + input + " is:" + handleHEXtoDEC(input));

                                break;
                            }
                            case 3: {
                                String input = lib.checkBDecimal("Input hexadecimal number:");
                                System.out.println("The result when we change HEX to HEX " + input + " is:" + input);
                                break;
                            }
                        }

                    }
                };
                m.run();
                break;

            }
        }
    }

//    Handle BIN to another base type
    public int handleBINtoDEC(String binaryString) {
        int decimalNumber = 0;
        int binaryBase = 2; 

        for (int i = 0; i < binaryString.length(); i++) {
            char binaryDigit = binaryString.charAt(i);

            int binaryValue = binaryDigit - '0';

            decimalNumber = decimalNumber * binaryBase + binaryValue;
        }

        return decimalNumber;
    }

    public static String handleBINtoHEX(String binaryString) {
        int paddingLength = 4 - (binaryString.length() % 4);
        if (paddingLength != 4) {
            StringBuilder padding = new StringBuilder();
            for (int i = 0; i < paddingLength; i++) {
                padding.append('0');
            }
            binaryString = padding + binaryString;
        }

        StringBuilder hexadecimalString = new StringBuilder();

        for (int i = 0; i < binaryString.length(); i += 4) {
            String binaryGroup = binaryString.substring(i, i + 4);
            int decimalValue = Integer.parseInt(binaryGroup, 2);
            char hexDigit = Character.forDigit(decimalValue, 16);
            hexadecimalString.append(hexDigit);
        }

        return hexadecimalString.toString().toUpperCase();
    }
//    Handle DEC to another base type

    public int handleDECtoBIN(String decimalString) {
        int decimalNumber = Integer.parseInt(decimalString);

        if (decimalNumber == 0) {
            return 0; 
        }

        StringBuilder binaryString = new StringBuilder();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            binaryString.insert(0, remainder); 
            decimalNumber /= 2; 
        }

        return Integer.parseInt(binaryString.toString());
    }

    public String handleDECtoHEX(String decimalString) {
        int decimalNumber = Integer.parseInt(decimalString);

        if (decimalNumber == 0) {
            return "0"; 
        }

        StringBuilder hexadecimalString = new StringBuilder();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 16; 
            char hexDigit;

            if (remainder < 10) {
                hexDigit = (char) ('0' + remainder);
            } else {
                hexDigit = (char) ('A' + remainder - 10); 
            }

            hexadecimalString.insert(0, hexDigit); 
            decimalNumber /= 16;
        }

        return hexadecimalString.toString();
    }
//Handle HEX - > another data

    public static String handleHEXtoBIN(String hexadecimalString) {
        Map<Character, String> hexToBinaryMap = new HashMap<>();
        hexToBinaryMap.put('0', "0000");
        hexToBinaryMap.put('1', "0001");
        hexToBinaryMap.put('2', "0010");
        hexToBinaryMap.put('3', "0011");
        hexToBinaryMap.put('4', "0100");
        hexToBinaryMap.put('5', "0101");
        hexToBinaryMap.put('6', "0110");
        hexToBinaryMap.put('7', "0111");
        hexToBinaryMap.put('8', "1000");
        hexToBinaryMap.put('9', "1001");
        hexToBinaryMap.put('A', "1010");
        hexToBinaryMap.put('B', "1011");
        hexToBinaryMap.put('C', "1100");
        hexToBinaryMap.put('D', "1101");
        hexToBinaryMap.put('E', "1110");
        hexToBinaryMap.put('F', "1111");

        StringBuilder binaryString = new StringBuilder();

        for (int i = 0; i < hexadecimalString.length(); i++) {
            char hexDigit = hexadecimalString.charAt(i);

           
            if (hexToBinaryMap.containsKey(hexDigit)) {
                binaryString.append(hexToBinaryMap.get(hexDigit));
            } else {
                return "Invalid Hexadecimal Input";
            }
        }

        return binaryString.toString();
    }

    public static int handleHEXtoDEC(String hexadecimalString) {
        // Kiểm tra chuỗi đầu vào có hợp lệ không
        if (!hexadecimalString.matches("^[0-9A-Fa-f]+$")) {
            return -1;
        }

        try {
       
            int decimalNumber = Integer.parseInt(hexadecimalString, 16);
            return decimalNumber;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
