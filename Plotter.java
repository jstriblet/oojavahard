import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Plotter extends Application {
	private double x, y;
	private boolean up, down, left, right;

	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root);

		Canvas canvas = new Canvas(900,700);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		x = 450;
		y = 350;

		int speed = 7;
		scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent t) {
				if ( t.getCode() == keyCode.UP || t.getCode() == KeyCode.W )
					up = true;
				if ( t.getCode() == keyCode.DOWN || t.getCode() == KeyCode.S )
					down = true;
				if ( t.getCode() == keyCode.LEFT || t.getCode() == KeyCode.A )
					left = true;
				if ( t.getCode() == keyCode.RIGHT || t.getCode() == KeyCode.D )
					right = true;

				if ( t.getCode()  == KeyCode.DIGIT1 )
					gc.setFill(Color.RED);
				if ( t.getCode()  == KeyCode.DIGIT2 )
					gc.setFill(Color.BLACK);
				if ( t.getCode()  == KeyCode.DIGIT3 )
					gc.setFill(Color.GREEN);
				if ( t.getCode()  == KeyCode.DIGIT4 )
					gc.setFill(Color.BLUE);
			}
		});

		scene.addEventHandler(KeyEvent.KEY_RELEASED,
				new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent t) {
					if ( t.getCode() == KeyCode.UP || t.getCode() == KeyCode.W )
						up = false;
					if ( t.getCode() == KeyCode.DOWN || t.getCode() == KeyCode.S )
						down = false;
					if ( t.getCode() == KeyCode.LEFT || t.getCode() == KeyCode.A )
						left = false;
					if ( t.getCode() == KeyCode.RIGHT || t.getCode() == KeyCode.D )
						right = false;
					}
				});

		root.getChildren().add(canvas);
		stage.setTitle("Plotter");
		stage.show();

		new AnimationTimer() { @Override
			public void handle(long now) { 
				if ( up )
				y -= speed; 
				else if ( down )
					y += speed; 
				if ( left )
					x -= speed; 
				else if ( right )
					x += speed; gc.fillRect(x, y, 20, 20);
			} }.start();
	}
	public static void main( String[] args ) { launch(args); } }
