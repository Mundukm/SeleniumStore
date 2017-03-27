package pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kolja on 25.03.2017.
 */
public class Encoder {

    //v
    private String textToEncode;
    //v
    private String brand;
    //v
    private String state;
    //v
    private String age;
    //v
    private int num1;
    //v
    private int num2;
    //v
    private int num3;

    //v
    private String price;
    //v
    private String male;
    //v
    private String title;
    //v
    private String description;

    private String category;
    private String subCategory;
    private String type;





    //words mean female
    private static List<String> femaleList = new ArrayList<>();
    static{
        String [] names = {"девочка" , "девочку", "девочке", "девочкам" , "девушка"};
        femaleList.addAll(Arrays.asList(names));
    }
    //words mean male
    private static List<String> maleList = new ArrayList<>();
    static{
        String [] names = {"мальчик" , "мальчику", "мальчика", "мальчикам" , "мальчики"};
        maleList.addAll(Arrays.asList(names));
    }

    public Encoder(String textToEncode) {
        encode(textToEncode);
    }
    public Encoder() {

    }

    public void encode(String str){
        this.textToEncode = str;
        encodeMale();
        encodeBrand();
        encodeTitle();
        encodePrice();
        encodeDescription();
        encodeState();
    }

    //decide what male is
    public void encodeMale(){
        for(String s: femaleList){
            if(textToEncode.contains(s)){
                male = "girl";
            }
        }
        for(String s: maleList){
            if(textToEncode.contains(s)){
                male = "boy";
            }
        }

    }

    //decide what brand
    public void encodeBrand(){
        String res = "";
        for(int i = 0; i<textToEncode.length()-1; i++){
            if(textToEncode.substring(i, i+1).matches("[a-z A-Z &]")){
                res+=textToEncode.substring(i, i+1);
            }else{break;}
        }
        brand = res;
    }

    //decide what title
    public void encodeTitle(){
        int end = 0;
        for(int i = 0; i<textToEncode.length()-4; i++){
            if(textToEncode.substring(i,i+4).equals("мес(")||
                    textToEncode.substring(i,i+4).equals("лет(")||
                    textToEncode.substring(i,i+4).equals("год(")||
                    textToEncode.substring(i,i+4).equals("мес ")||
                    textToEncode.substring(i,i+4).equals("лет ")||
                    textToEncode.substring(i,i+4).equals("год ")){
                end = i+3;
            }
        }
        for(int i = 0; i<textToEncode.length()-5; i++){
            if(textToEncode.substring(i,i+5).equals("года ")||
                    textToEncode.substring(i,i+5).equals("года(")){
                end = i+4;
            }
        }
        title = textToEncode.substring(0,end);
    }

    //decide what price
    public void encodePrice(){
        String withoutSpaces = textToEncode.replaceAll(" ", "");
        int endIndex=0;
        int startIndex=0;
        for(int i = 0; i<withoutSpaces.length()-2;i++){
            if(withoutSpaces.substring(i,i+3).equals("грн")){
                endIndex = i;
            }
        }
        for(int i = endIndex-1;i>0;i--){
            if(withoutSpaces.substring(i,i+1).matches("[0-9]")){
                startIndex = i;
            }else{
                break;
            }
        }
        price = withoutSpaces.substring(startIndex,endIndex);

    }

    //decide what description
    public void encodeDescription(){
        String res = "";
        String [] array = textToEncode.split(" ");

        for(int i = 0; i<array.length-2;i++){
            res+=array[i] + " ";
        }
        description = res;
    }

    //decide what state
    public void encodeState(){
        state = "by";
    }


    @Override
    public String toString() {
        return
                "brand='" + brand + '\'' +
                ", state='" + state + '\'' +
                ", age='" + age + '\'' +
                ", price='" + price + '\'' +
                ", male='" + male + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", type='" + type + '\'' + "|" + num1  + num2 + num3;
    }

    // GETTERSSETTERS
    public static List<String> getFemaleList() {
        return femaleList;
    }

    public static void setFemaleList(List<String> femaleList) {
        Encoder.femaleList = femaleList;
    }

    public String getTextToEncode() {
        return textToEncode;
    }

    public void setTextToEncode(String textToEncode) {
        this.textToEncode = textToEncode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        switch (age){
            case "<6мес":
                num1= 62;num2=68;num3=74;break;
            case "6-9мес":
                num1= 68;num2=74;num3=80;break;
            case "9-12мес":
                num1= 74;num2=80;num3=86;break;
            case "12-18мес":
                num1= 80;num2=86;num3=92;break;
            case "18-24мес":
                num1= 86;num2=92;num3=98;break;
            case "2-3года":
                num1= 92;num2=98;num3=104;break;
            case "3-4года":
                num1= 98;num2=104;num3=110;break;
            case "4-5год":
                num1= 104;num2=110;num3=116;break;
            case "5-6год":
                num1= 110;num2=116;num3=122;break;
            case "6-7год":
                num1= 116;num2=122;num3=128;break;
            case "7-8год":
                num1= 122;num2=128;num3=134;break;
            case "8-9год":
                num1= 128;num2=134;num3=140;break;
            case "9-10год":
                num1= 134;num2=140;num3=146;break;
            case "10-11год":
                num1= 140;num2=146;num3=152;break;
            case "11-12год":
                num1= 146;num2=152;num3=158;break;
            case "12-13год":
                num1= 152;num2=158;num3=0;break;
        }
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
