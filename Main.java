class Main{
  public static void main(String[] args){
    Character joe = new Character(5, "joe");
    System.out.println(joe.toString());
    joe.levelUp(1);
    System.out.println(joe.toString());
    joe.levelUp(100);
    System.out.println(joe.toString());
    System.out.println("-----------------\n\n-----------------");
    Character poopJoe = new Character(4, "poopjoe");
    System.out.println(poopJoe.toString());
    poopJoe.levelUp(1);
    System.out.println(poopJoe.toString());
    poopJoe.levelUp(100);
    System.out.println(poopJoe.toString());
  }
}