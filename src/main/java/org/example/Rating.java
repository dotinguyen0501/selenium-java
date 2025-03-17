package org.example;

public enum Rating {
    YEU(0, "Yeu"),
    TRUNGBINH (5, "Trung Binh"),
    KHA (6.5, "Kha"),
    GIOI(8, "Gioi"),
    XUATSAC (9, "Xuat sac");
    private final double minScore;
    private final String description;
    Rating (double minScore, String description){
        this.minScore = minScore;
        this.description = description;
    }
    public static Rating getRating(double score){
        for (Rating rating : Rating.values()){
            if (score >= rating.minScore){
                return rating;
            }
        }
        return null;
    }
    public String getDescription(){
        return description;
    }
}

