public class Student {
    private int ID;
    private String name;
    private String birDate;
    private String gender;

    public Student (int ID, String name, String birDate, String gender) {
        this.ID = ID;
        this.name = name;
        this.birDate = birDate;
        this.gender = gender;
    }

    /*public Student() {}*/
    //未使用到Student()

    public int getID() {
        return ID;
    }
    public String getName(){
        return name;
    }
    public String getBirDate(){
        return birDate;
    }
    public String getGender(){
        return gender;
    }
    //访问每个字段的值；

/*    public void setID(int ID){
        this.ID = ID;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setBirDate(String birDate){
        this.birDate = birDate;
    }
    public void setGender(String gender){
        this.gender = gender;
    }*/
    //单个修改
    //未使用到，注释掉




}
