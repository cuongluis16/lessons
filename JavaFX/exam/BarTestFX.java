import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

public class BarTestFX extends Application {
  private BreakoutThread breakoutthread;

  public static void main ( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage stage ) {
    Key key = new Key();
    stage.setTitle( "Bar Test" );

    Pane pane = new Pane();
    Scene scene = new Scene( pane );
    stage.setScene( scene );

     scene.setOnKeyPressed(
         new EventHandler<KeyEvent>() {
           public void handle( KeyEvent e ) {
             key.keyPressed( e );
           }
         }
       );

    Canvas canvas = new Canvas( 640, 480 );
    GraphicsContext gc = canvas.getGraphicsContext2D();
    pane.getChildren().add( canvas );

    breakoutthread = new BreakoutThread( gc );
    breakoutthread.start();

    stage.show();
  }
}

class BreakoutThread extends AnimationTimer {

  private GraphicsContext gc;
  private Ball ball;
  private Bar bar;

  public BreakoutThread( GraphicsContext gc ) {
    this.gc = gc;
    ball = new Ball();
  }

  @Override
  public void handle( long time ) {

    gc.clearRect( 0, 0, 640, 480 );

    ball.draw( gc );

    ball.move();
  }
}

class Bar {
    private int x;
    private int y;
    private int width;
    private int height;

  public Bar() {
    this.x = 20;
    this.y = 0;
    this.width = 20;
    this.height = 60;
  }

  public void draw( GraphicsContext gc ) {
    gc.setFill( Color.RED );
    gc.fillRect( 20, y, 20, 60 );
  }
  public void move() {
    this.x += this.width;
    this.y += this.height;

  }
}
  class Key {

     public void keyPressed( KeyEvent e ) {
       switch( e.getCode() ) {
      case LEFT:
       System.out.println( "LEFT pressed." );
       break;
       case RIGHT:
       System.out.println( "RIGHT pressed." );
       break;
       default:
       break;
     }
  }
}