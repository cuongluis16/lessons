class Student {
  public String name;
}

public class test {
  public static void main ( String[] args ) {
    System.out.println( "hello" );
    
    // Studentクラスのインスタンスを生成する = new する
    Student yamada = new Student();
    yamada.name = "Yamada Taro";
    
    // yamada の名前を表示する
    System.out.println( yamada.name );
  }
}