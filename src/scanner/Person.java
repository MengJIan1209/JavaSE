package scanner;

/**
 * @author
 * @description
 * @date 2021/11/12
 */
class Perosn{

    public static void main(String[] args) {

    }

}



class Person {


    private String name;
    private String location;

    public Person(){

    }

    public Person(String name){
        this.name = name;
    }

    public Person(String name ,String location){

    }

    public void info(){
        System.out.println("名字"+name+"籍贯"+location);
    }
}

class Teacher extends Person{
    private  String captical;

    public Teacher(){

    }

    public Teacher(String name,String location,String captical){

    }
}
