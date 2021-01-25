import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Test extends Application {
   public static void main( String[] args ) {
     launch( args );
   }
   @Override
   public void start( Stage stage ) throws Exception {
     View v = new View();
     Scene scene = new Scene( v, 500, 400 );
     stage.setScene( scene );
     stage.show();
   }
 }

 class View extends Group {
   public View() {
     Circle circle = new Circle( 200, 200, 30 );
     circle.setFill( Color.BLUE );

     TranslateTransition animation = new TranslateTransition( Duration.seconds(2), circle );

     animation.setFromX(500);
     animation.setFromY(200);
     animation.setToX(0);
     animation.setToY(200);
     animation.setCycleCount( Animation.INDEFINITE );

     animation.play();
     getChildren().add( circle );
   }
 }