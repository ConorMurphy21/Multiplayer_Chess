package main;

import board.graphics.BoardGroup;
import highlighters.graphics.HighlightGroup;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import networking.Client;
import pieces.graphics.PieceGroup;
import utils.SizeUtil;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    private static BooleanProperty thisTurn = new SimpleBooleanProperty(false);

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) {

        stage = primaryStage;
        stage.setTitle("Chess");

        Client client =  Client.getInstance();
        client.start();

        stage.setOnCloseRequest(e->client.sendQuit());


    }

    public static void ini(boolean isWhite){
                     //ini simple borderpane as root
        BorderPane root = new BorderPane();


                            //starting size of 600 x 600
        Scene scene = new Scene(root);
                            //create size util because it is necessary for the group initializers

        StackPane stack = new StackPane();
        stack.setPrefSize(600,600);
        stack.setMinSize(0,0);
        root.setCenter(stack);
        SizeUtil.createInstance(stack.widthProperty(),stack.heightProperty(), isWhite);


        Text text = new Text();
        text.setFont(new Font(14));


        thisTurn.setValue(isWhite);

        thisTurn.addListener((obs, old, nw)->{
            if(nw){
                text.setText("Opponent has Played, It is your turn!");
            }else{
                text.setText("Waiting for opponent to play...");
            }
        });
        if(isWhite){
            text.setText("It's your turn!");
        }else{
            text.setText("Waiting for opponent to play...");
        }

        Region region = new Region();
        region.setPrefWidth(10);

        HBox hbox = new HBox(region,text);
        hbox.setStyle("-fx-background-color: #F0E68C");

        root.setTop(hbox);

        //initialize the 3 layers of the scene
        Group boardGroup = BoardGroup.getInstance();
        Group highlightGroup = HighlightGroup.getInstance();
        PieceGroup pieceGroup = PieceGroup.getInstance();

        pieceGroup.initializeGame();


        stack.getChildren().add(boardGroup);
        stack.getChildren().add(highlightGroup);
        stack.getChildren().add(pieceGroup);

        stage.setScene(scene);
        stage.show();

    }

    public static BooleanProperty getThisTurn(){
        return thisTurn;
    }

}