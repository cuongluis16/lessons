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

public class BreakoutMain extends Application {
    private BreakoutThread breakoutthread;
    public static void main(String[] args) {
      launch( args );
    }
    scene.setOnKeyPressed(
     new EventHandler<KeyEvent>(){
       public void handle( KeyEvent e ) {
         System.out.println( e.getCode() );
       }
     }
   );
    @Override
    public void start( Stage stage ) {
      stage.setTitle( "BreakoutGame" );

      Pane pane = new Pane();
      Scene scene = new Scene( pane );
      stage.setScene( scene );

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
      this.ball = new Ball();
      this.bar = new Bar();
    }

    @Override
    public void handle( long time ) {
      gc.clearRect( 0, 0, 640, 480 );

      ball.draw();
      ball.move();

      bar.draw();
    }
  }



  class Ball {
　   private int x;
　   private int y;
　   private int x_speed;
　   private int y_speed;

　   public Ball() {
　     x = 0;
　     y = 0;
　     x_speed = 3;
　     y_speed = 3;
　   }
     public void move() {
        x += x_speed;
        y += y_speed;

      if( y > 480 ) {
      y_speed *= -1;
      }
    }
    class Bar {
    private int x;
    private int y;
    private int w;
    private int h;
    private int x_speed;
    private int y_speed;

    public Bar(){
      x = 50;
      y = 450;
      w = 100;
      h = 20;
    }
    public void draw( GraphicsContext gc ){
      gc.setFill( Color.BLUE );
      gc.fillRect( x, y, w, h );
    }
  }
    public void move() {
      x += 5;
      y += 5;

      if ( x > 640 ) {
        x = 0;
      }
      if ( y > 480 ) {
        y = 0;
      }
    }
  }