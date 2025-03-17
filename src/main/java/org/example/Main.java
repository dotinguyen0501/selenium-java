package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
/**
 * Viet một chương trình tính tiền taxi từ số km nhập vào
 * 1. Nếu số km <= 1 thì in ra "Số tiền phải trả là 5000"
 * 2. Nếu số km > 1 và <= 30 thì in ra "Số tiền phải trả là " + (5000 + (số km - 1) * 4000)
 * 3. Nếu số km > 30 thì in ra "Số tiền phải trả là " + (5000 + 29 * 4000 + (số km - 30) * 3000)
 *
 */
        int soKm = -10;
        int soTien = 0;
        if (soKm < 0){
            throw new IllegalArgumentException("Invalid km");
        }else
        if( (soKm <= 1) || (soKm >= 0)) {
            soTien = 5000;
        } else if (soKm <= 30) {
            soTien = 5000 + (soKm - 1) * 4000;
        } else {
            soTien = 5000 + 29 * 4000 + (soKm - 30) * 3000;
        }
        System.out.println("Số tiền phải trả là " + soTien);
    }

}