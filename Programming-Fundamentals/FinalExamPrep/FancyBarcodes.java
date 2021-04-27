package com.JavaFundamentals.FinalExamPrep;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String BarcodeRegex = "(@)#+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])(\\1)#+";
        Pattern pattern = Pattern.compile(BarcodeRegex);


        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcode);
            if (matcher.find()) {
                //valid
                String product = matcher.group("product");
                String productGroup = "";
                for (int index = 0; index < product.length(); index++) {
                    char currentSymbol = product.charAt(index);
                    if(Character.isDigit(currentSymbol)){
                        productGroup += currentSymbol;
                    }
                }
                if(productGroup.equals("")){
                    System.out.println("Product group: 00");
                }else{
                    System.out.println("Product group: "+ productGroup);
                }
            } else {
                //invalid
                System.out.println("Invalid barcode");
            }
        }
    }
}
