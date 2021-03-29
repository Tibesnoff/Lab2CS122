import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Beach extends Application {

public void start (Stage primaryStage) {
	//sand
	Color sandC=Color.rgb(194,178,128);
	Rectangle sand=new Rectangle(0,400,1600,600);
	sand.setStroke(sandC);
	sand.setFill(sandC);
	
	//water
	Stop[] stops = new Stop[] {new Stop(0, Color.rgb(0,130,170)), new Stop(1, Color.rgb(0,0,190))};
	LinearGradient waterG = new LinearGradient(0, 700, 0, 1000, false, CycleMethod.NO_CYCLE, stops);
	Rectangle water=new Rectangle(0,700,1600,300);
	water.setStroke(waterG);
	water.setFill(waterG);
	
	Group background=new Group(sand,water);
	
	//beachball
	//test
	
	//umbrella
	Rectangle pole=new Rectangle(300,400,5,100);
	pole.setStroke(Color.rgb(0, 0, 0));
	Arc top=new Arc(302,445,70,70,40,100);
	top.setFill(Color.rgb(250, 0, 0));
	ArrayList<Group> temp=new ArrayList<Group>();
	for(int i=0; i<10; i++){
		Group umbrella=new Group(pole,top);
		int maxx=1560,maxy=160,mind=-30,maxd=30;
		Random rand=new Random();
		umbrella.relocate(rand.nextInt(maxx)+20, rand.nextInt(maxy)+420);
		if(rand.nextInt(100)>50)
			umbrella.setRotate(rand.nextInt(25));
		else
			umbrella.setRotate(-(rand.nextInt(25)));
		temp.add(umbrella);
	}
	
	Group umbrellas=new Group();
	umbrellas.getChildren().addAll(temp);
	
	//sun
	
	


    Circle circle = new Circle(100, 65, 20);
   
    circle.setFill(Color.BLUE);
    Color periwinkle = Color.rgb(180, 160, 244);
    circle.setStroke(periwinkle);
    circle.setStrokeWidth(10);
   
    Rectangle rect = new Rectangle(60, 70, 250, 60);
    rect.setStroke(Color.RED);
    rect.setStrokeWidth(2);
    rect.setFill(null);        
    Ellipse ellipse = new Ellipse(200, 100, 150, 50);
    ellipse.setFill(Color.PALEGREEN);
   
    Text quote = new Text(120, 100, "Out of clutter, find " +
            "simplicity.\n-- Albert Einstein");
    
    Group image=new Group(background, umbrellas);
   
    Scene scene = new Scene(image, 1600, 1000);
    scene.setFill(Color.rgb(135,206,235));
   
    primaryStage.setTitle("Einstein");
    primaryStage.setScene(scene);
    primaryStage.show();
 
}


public static void main(String[] args)
    {
        launch(args);
    }
}

