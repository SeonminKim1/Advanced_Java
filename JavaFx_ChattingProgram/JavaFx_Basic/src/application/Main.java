package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// stage(가장 큼) > scene > container > node
			// stage는 기본으로 만들어져 있음. primaryStage
			
			// Container 종류중 pane이 있음. / StackPane() / GridPane()
			// 1. 원하는 좌표에 노드를 배치하기. - Pane();
			/*
			//Pane pane = new Pane(); // Pane()에 넣으면 왼쪽맨위부터 좌표가 잡힘, setAlignment도 없음.
			Rectangle rec1 = new Rectangle(100,100,Color.RED);
			Rectangle rec2 = new Rectangle(100,100,Color.BLUE);
			pane.getChildren().addAll(rec1,rec2);
			//pane.setLayoutX(300); pane.setLayoutY(400); // x좌표 , y좌표
			rec1.setLayoutX(0); rec1.setLayoutY(0); // x좌표 , y좌표 특정좌표에 위치시킴.
			rec2.setTranslateX(200); rec2.setTranslateY(200); // x좌표는 setTranslate에 의해 이동됨.. y좌표는 setTranslate에 의해 이동됨.
			
			Scene scene = new Scene(pane,800,800);
			scene.setOnMouseMoved(e->{
				rec2.setTranslateX(e.getSceneX());
				rec2.setTranslateY(e.getSceneY());
			});
			
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
			// 2. StackPane 써보기 - StackPane은 가운데로 위치하게 됨.
			/*
			StackPane pane = new StackPane(); 
			Scene scene = new Scene(pane,800,500);

			// Label에 대한 설정.
			Label label = new Label();
			label.setText(Integer.toString(num));
			label.setAlignment(Pos.BOTTOM_LEFT); // 글씨정렬위치
			label.setStyle("-fx-font-size: 30; -fx-text-fill: red; -fx-border-color:green;");
			// css파일 만들어서 적용하기.
			
			Button button = new Button("Add");
			button.setOnAction(e->{ // 람다식 . 람다식 안에서 사용되는 변수는 무조건 fianl이여야 됨. 무조건 클래스내 변수 급으로 설정.
				num++;
				label.setText(Integer.toString(num));
			}); // 람다식.
				
			pane.getChildren().addAll(label, button);
			pane.setAlignment(button,Pos.BOTTOM_CENTER);
			primaryStage.setTitle("자바 Fx 연습");
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
			
			
			// 3. gridPane 써보기.
			/* 
			GridPane grid = new GridPane();
			Scene scene = new Scene(grid, 800,800);
			for(int y=0; y<10; y++) {
				for(int x=0; x<10; x++) {
					Label label = new Label();
					label.setStyle("-fx-border-color:black; -fx-font-size:15;");
					label.setText( " (" + x + "," +y+") ");
					grid.addRow(y,label);
				}
			}
			//grid.addRow(rowIndex, children); // 가로로 한번에 넣기.
			//grid.addColumn(rowIndex,children); // 세로로 한번에 넣기.
			
			grid.setHgap(10); // 가로 사이의 공간. 
			grid.setVgap(10); // grid.setVgap(10) : 세로 사이의 공간 만들기. (vertical)
			
			// grid.add(label1, 0, 0,1,1); // 0,0에 가로로 1칸 세로로 1칸 짜리 집어넣기)
			
			
			primaryStage.setTitle("자바 Fx 연습");
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
			
			// 4. 크기 자동 조절하기
			// container는 마우스로 크기를 줄였다 놨다 해도 그 거 따라서 조절됨.
			// button1.prefWidthProperty().bind(pane.widthProperty()); // button의 가로 정보를 pane()의 가로 정보와 일치시킨다. 마우스로 조절해도 크기 맞춰지게.
			// button1.perfHeightProperty().bind(pane.heightProperty()); // button의 세로 정보를 pane()의 세로 정보와 일치시킨다.
			// button2.setMinWidth(); button2.setMinHeight(); // 최소 사이즈를 정해놓으면 크기를 키워도 그크기에 고정됨.
			// button2.setMaxHeight(); button2.setMaxWidth(); // 쭉 늘리다가 어느정도 크기 이상 커지면 안늘어남.
			
			// 5. 이미지 사용하기, 이미지 앨범 만들기.
			/*
			StackPane stackpane = new StackPane();
			Scene scene = new Scene(stackpane, 800, 800);
			Image image1 = new Image("File:images/image.PNG"); // File도 붙여 줘야함.
			Image image2 = new Image("File:images/back.PNG"); // File도 붙여 줘야함.
			Image image3 = new Image("File:images/water.PNG"); // File도 붙여 줘야함.
			ImageView iv = new ImageView();
			//iv.setImage(image1);
			//iv.setFitHeight(500); iv.setFitWidth(500); // 가로, 세로 겅제 조정하기
			iv.setPreserveRatio(true); // 원래 비율 유지하기 1
			iv.setFitWidth(300); // 원래 비율 유지하기 2
			//iv.setRotate(180); // 180도 돌리기.
			
			Label label1 = new Label("  1  ");
			Label label2 = new Label("  2  ");
			Label label3 = new Label("  3  ");
			
			GridPane grid = new GridPane();
			grid.addRow(0, label1,label2,label3);
			grid.setAlignment(Pos.BOTTOM_CENTER);
			
			Map <Label, Image> map = new LinkedHashMap<Label,Image>();
			map.put(label1, image1);
			map.put(label2, image2);
			map.put(label3, image3);
			
			for(Label label : map.keySet()) {
				label.setStyle("-fx-border-color:black; -fx-font-size:20;");
				label.setOnMouseEntered(e->{
					iv.setImage(map.get(label));
				});
			}
			stackpane.getChildren().addAll(iv,grid);
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
			
			// 6. 로그인 화면 만들기.
			/*
			GridPane grid = new GridPane();

			Scene scene = new Scene(grid, 500, 500);
			
			Label lName = new Label("User name: ");
			Label lPassword = new Label("Password: ");
			Label lMessage = new Label("");
			TextField tfName = new TextField();
			PasswordField tfPassword = new PasswordField();
			
			Button button = new Button("Login");
			button.prefHeightProperty().bind(tfName.heightProperty().add(tfPassword.heightProperty())); // 버튼의 높이가 name 높이와 + password 높이가 됨.
			button.setOnAction(e->{
				lMessage.setStyle("-fx-text-fill: red;");
				String name = tfName.getText();
				String password = tfPassword.getText();
				if(name.equals("")) {
					lMessage.setText("Please Enter your name");
				}
				else if (password.equals("")) {
					lMessage.setText("Please Enter your password");
				}
				else if ((!name.equals("Seon")) || (!password.equals("min"))) {
					lMessage.setText("Invalid name or password");
				}
				else {
					lMessage.setStyle("-fx-text-fill:green;");
					lMessage.setText("Success Login in > < ");
				}
			});
			
			grid.addColumn(0, lName,lPassword);
			grid.addColumn(1, tfName, tfPassword);
			grid.add(button, 2, 0, 1, 2); // 2열 0행에 열1개크기 행2개크기
			grid.setAlignment(Pos.CENTER);
			grid.add(lMessage, 0,2,3,1);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		*/
			// 7. 메뉴바만들기.
			StackPane pane = new StackPane();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setTitle("MenuBar");
			primaryStage.setWidth(600);
			primaryStage.setHeight(400);
			primaryStage.show();
			
			MenuBar menubar = new MenuBar();
			pane.getChildren().add(menubar);
			
			Menu file = new Menu("파일");
			Menu Edit = new Menu("편집");
			Menu Source = new Menu("소스");
			menubar.getMenus().addAll(file,Edit,Source);
			pane.setAlignment(menubar,Pos.TOP_CENTER); // 메뉴바를 위쪽 가운데로 정렬.
			
			MenuItem item1 = new MenuItem("New");
			MenuItem item2 = new MenuItem("Open");
			file.getItems().addAll(item1,item2);
			
			item1.setOnAction(e->{
				System.out.println("'New' Button clicked");
			});
			item1.setAccelerator(KeyCombination.keyCombination("Ctrl+G")); // 단축키 설정하기. 컨트롤 G를 누르면은 이벤트가 실행됨.

			CheckMenuItem checkitem = new CheckMenuItem("Always On Top");
			file.getItems().add(checkitem);
			checkitem.setOnAction(e->{
				if(checkitem.isSelected()) {
					System.out.println("Checkitem UnChecked");
				}else {
					System.out.println("Checkitem Checked");
				}
			});
			// 메뉴안에 메뉴 넣기는 그냥 Menu 클래스 만들어서 add () 메뉴하면 됨.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	int num=0;
	
	public static void main(String[] args) {
		launch(args);
	}
}
