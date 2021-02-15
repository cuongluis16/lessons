import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;

public class BallTestFX extends Application {
  private BreakoutThread breakoutthread;
  public static void main ( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage stage ) {
    stage.setTitle( "Ball Test" );

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

class Ball {

  private int x;
  private int y;
  private int x_speed;
  private int y_speed;

  public Ball() {
    this.x = 20;
    this.y = 20;
    this.x_speed = 5;
    this.y_speed = 5;
  }

  public void draw( GraphicsContext gc ) {
    gc.setFill( Color.BLUE );
    gc.fillOval( x, y, 20, 20 );
  }
  public void move(){
    this.x += this.x_speed;
    this.y += this.y_speed;
  }
}