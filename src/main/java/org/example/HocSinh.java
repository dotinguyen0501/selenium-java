package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Random;

public class HocSinh {
    private String id;
    private String name;
    private int age;
    private double score;
    public HocSinh( String name, int age, double score) {
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);
        this.id = "TVN-Ak48-" + randomNumber;
        //random student id with prefix "TVN-Ak48-"
        this.name = name;
        this.age = age;
        this.score = score;
    }
public void infor() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student Mark: " + score);

    }
    public Rating rate(HocSinh hocSinh) {
        enum XepLoai{
            YEU, TRUNGBINH, KHA, GIOI, XUATSAC
        }
        if (this.score < 0 || this.score > 10) {
            throw new IllegalArgumentException("Invalid mark");
        }
        if (this.score < 5){
            return Rating.YEU;
        }else if(this.score < 6.5) {
            return Rating.TRUNGBINH;
        }else if (this.score < 8) {
            return Rating.KHA;
        } else if (this.score<9){
            return Rating.GIOI;
        } else {
            return Rating.XUATSAC;

        }
    }

    public static void main(String[] args) {
        List<HocSinh> classroom = new ArrayList<HocSinh>();
        //Tao 1 danh sach hoc sinh voi 10 bạn
        //random score from 1.0 to 10.0 in double
        //random age from 18 to 25 in int
        //random name from array {"Hoa", "Lan", "Cuc", "Mai", "Huong", "Linh", "Tuan", "Hai", "Dung", "Hieu"}
        for (int i =0; i <10; i++){
            classroom.add(new HocSinh(randomName(), randomAge(), randomScore()));
        }
        classroom.stream()
                .filter(hocSinh -> hocSinh.rate(hocSinh) == Rating.YEU)
                .forEach(HocSinh::infor);
    }
    public static String randomName(){
        String[] names = {"Hoa", "Lan", "Cuc", "Mai", "Huong", "Linh", "Tuan", "Hai", "Dung", "Hieu"};
        Random random = new Random();
        int index = random.nextInt(names.length);
        return names[index];
    }
    public static int randomAge(){
        Random random = new Random();
        return random.nextInt(25-18 + 1) + 18;
    }
    public static double randomScore(){
        Random random = new Random();
        return Math.round((1.0 + (10.0 - 1.0) * random.nextDouble()) * 100.0) / 100.0;
    }
}

