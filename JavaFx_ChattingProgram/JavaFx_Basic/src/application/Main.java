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
			// stage(���� ŭ) > scene > container > node
			// stage�� �⺻���� ������� ����. primaryStage
			
			// Container ������ pane�� ����. / StackPane() / GridPane()
			// 1. ���ϴ� ��ǥ�� ��带 ��ġ�ϱ�. - Pane();
			/*
			//Pane pane = new Pane(); // Pane()�� ������ ���ʸ������� ��ǥ�� ����, setAlignment�� ����.
			Rectangle rec1 = new Rectangle(100,100,Color.RED);
			Rectangle rec2 = new Rectangle(100,100,Color.BLUE);
			pane.getChildren().addAll(rec1,rec2);
			//pane.setLayoutX(300); pane.setLayoutY(400); // x��ǥ , y��ǥ
			rec1.setLayoutX(0); rec1.setLayoutY(0); // x��ǥ , y��ǥ Ư����ǥ�� ��ġ��Ŵ.
			rec2.setTranslateX(200); rec2.setTranslateY(200); // x��ǥ�� setTranslate�� ���� �̵���.. y��ǥ�� setTranslate�� ���� �̵���.
			
			Scene scene = new Scene(pane,800,800);
			scene.setOnMouseMoved(e->{
				rec2.setTranslateX(e.getSceneX());
				rec2.setTranslateY(e.getSceneY());
			});
			
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
			// 2. StackPane �Ẹ�� - StackPane�� ����� ��ġ�ϰ� ��.
			/*
			StackPane pane = new StackPane(); 
			Scene scene = new Scene(pane,800,500);

			// Label�� ���� ����.
			Label label = new Label();
			label.setText(Integer.toString(num));
			label.setAlignment(Pos.BOTTOM_LEFT); // �۾�������ġ
			label.setStyle("-fx-font-size: 30; -fx-text-fill: red; -fx-border-color:green;");
			// css���� ���� �����ϱ�.
			
			Button button = new Button("Add");
			button.setOnAction(e->{ // ���ٽ� . ���ٽ� �ȿ��� ���Ǵ� ������ ������ fianl�̿��� ��. ������ Ŭ������ ���� ������ ����.
				num++;
				label.setText(Integer.toString(num));
			}); // ���ٽ�.
				
			pane.getChildren().addAll(label, button);
			pane.setAlignment(button,Pos.BOTTOM_CENTER);
			primaryStage.setTitle("�ڹ� Fx ����");
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
			
			
			// 3. gridPane �Ẹ��.
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
			//grid.addRow(rowIndex, children); // ���η� �ѹ��� �ֱ�.
			//grid.addColumn(rowIndex,children); // ���η� �ѹ��� �ֱ�.
			
			grid.setHgap(10); // ���� ������ ����. 
			grid.setVgap(10); // grid.setVgap(10) : ���� ������ ���� �����. (vertical)
			
			// grid.add(label1, 0, 0,1,1); // 0,0�� ���η� 1ĭ ���η� 1ĭ ¥�� ����ֱ�)
			
			
			primaryStage.setTitle("�ڹ� Fx ����");
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
			
			// 4. ũ�� �ڵ� �����ϱ�
			// container�� ���콺�� ũ�⸦ �ٿ��� ���� �ص� �� �� ���� ������.
			// button1.prefWidthProperty().bind(pane.widthProperty()); // button�� ���� ������ pane()�� ���� ������ ��ġ��Ų��. ���콺�� �����ص� ũ�� ��������.
			// button1.perfHeightProperty().bind(pane.heightProperty()); // button�� ���� ������ pane()�� ���� ������ ��ġ��Ų��.
			// button2.setMinWidth(); button2.setMinHeight(); // �ּ� ����� ���س����� ũ�⸦ Ű���� ��ũ�⿡ ������.
			// button2.setMaxHeight(); button2.setMaxWidth(); // �� �ø��ٰ� ������� ũ�� �̻� Ŀ���� �ȴþ.
			
			// 5. �̹��� ����ϱ�, �̹��� �ٹ� �����.
			/*
			StackPane stackpane = new StackPane();
			Scene scene = new Scene(stackpane, 800, 800);
			Image image1 = new Image("File:images/image.PNG"); // File�� �ٿ� �����.
			Image image2 = new Image("File:images/back.PNG"); // File�� �ٿ� �����.
			Image image3 = new Image("File:images/water.PNG"); // File�� �ٿ� �����.
			ImageView iv = new ImageView();
			//iv.setImage(image1);
			//iv.setFitHeight(500); iv.setFitWidth(500); // ����, ���� ���� �����ϱ�
			iv.setPreserveRatio(true); // ���� ���� �����ϱ� 1
			iv.setFitWidth(300); // ���� ���� �����ϱ� 2
			//iv.setRotate(180); // 180�� ������.
			
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
			
			// 6. �α��� ȭ�� �����.
			/*
			GridPane grid = new GridPane();

			Scene scene = new Scene(grid, 500, 500);
			
			Label lName = new Label("User name: ");
			Label lPassword = new Label("Password: ");
			Label lMessage = new Label("");
			TextField tfName = new TextField();
			PasswordField tfPassword = new PasswordField();
			
			Button button = new Button("Login");
			button.prefHeightProperty().bind(tfName.heightProperty().add(tfPassword.heightProperty())); // ��ư�� ���̰� name ���̿� + password ���̰� ��.
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
			grid.add(button, 2, 0, 1, 2); // 2�� 0�࿡ ��1��ũ�� ��2��ũ��
			grid.setAlignment(Pos.CENTER);
			grid.add(lMessage, 0,2,3,1);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		*/
			// 7. �޴��ٸ����.
			StackPane pane = new StackPane();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setTitle("MenuBar");
			primaryStage.setWidth(600);
			primaryStage.setHeight(400);
			primaryStage.show();
			
			MenuBar menubar = new MenuBar();
			pane.getChildren().add(menubar);
			
			Menu file = new Menu("����");
			Menu Edit = new Menu("����");
			Menu Source = new Menu("�ҽ�");
			menubar.getMenus().addAll(file,Edit,Source);
			pane.setAlignment(menubar,Pos.TOP_CENTER); // �޴��ٸ� ���� ����� ����.
			
			MenuItem item1 = new MenuItem("New");
			MenuItem item2 = new MenuItem("Open");
			file.getItems().addAll(item1,item2);
			
			item1.setOnAction(e->{
				System.out.println("'New' Button clicked");
			});
			item1.setAccelerator(KeyCombination.keyCombination("Ctrl+G")); // ����Ű �����ϱ�. ��Ʈ�� G�� �������� �̺�Ʈ�� �����.

			CheckMenuItem checkitem = new CheckMenuItem("Always On Top");
			file.getItems().add(checkitem);
			checkitem.setOnAction(e->{
				if(checkitem.isSelected()) {
					System.out.println("Checkitem UnChecked");
				}else {
					System.out.println("Checkitem Checked");
				}
			});
			// �޴��ȿ� �޴� �ֱ�� �׳� Menu Ŭ���� ���� add () �޴��ϸ� ��.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	int num=0;
	
	public static void main(String[] args) {
		launch(args);
	}
}
