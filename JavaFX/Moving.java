import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Moving extends Application {
  public static void main( String[] args ) {
    launch( args );
  }
  @Override
  public void start( Stage stage ) throws Exception {
    View v = new View();
    Scene scene = new Scene( v, 400, 300 );
    stage.setScene( scene );
    stage.show();
  }
}


class View extends Group {
  public View() {
    Rectangle rect = new Rectangle( 0, 0, 60, 70 );
    rect.setFill( Color.BLUE );

    TranslateTransition animation = new TranslateTransition( Duration.seconds( 2 ),  rect );

    animation.setFromX( -50 );
    animation.setFromY( 50 );

    animation.setToX( 300 );
    animation.setToY( 290 );

    animation.setCycleCount( Animation.INDEFINITE );

    animation.play();
    getChildren().add( rect );
  }
}
