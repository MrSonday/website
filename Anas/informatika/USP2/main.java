public class main {
    public static void main(String[] args){

    }
}

class student{
    private string name;
    public int id;
    student(String name, int id){
        this.name = name;
        this.id = id;
    }
    String getName(){
        return this.name;
    }
}
class Grandstudent extends Student(){
    private String major;
    private String topic;
    Grandstudent(String name, int id, String major){
        super(name, id);
        this.major = major;
        this.topic = "welcome to graduate school! " + name;
    }
    String getMajor(){
        return this.major;
    }
    void setMajor(String major){
        this.major = major;
    }
    String getTopic(){
        return this.topic;
    }
    void setTopic(String topic){
        this.topic = topic;
    }
}
