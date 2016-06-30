package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.titanpay.accounting.SalariedEmployee;
import com.titanpay.accounting.HourlyEmployee;

public class Main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	private Stage theStage;

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("TitanPay");

		theStage = primaryStage;

		FlowPane vb = new FlowPane();
		vb.setPadding(new Insets(35, 12, 15, 12));
		vb.setVgap(15);
		vb.setHgap(15);

		Button createEmployeeButton = new Button();
		createEmployeeButton.setText("Create New Employee");
		vb.getChildren().add(createEmployeeButton);

		Button timeCardButton = new Button();
		timeCardButton.setText("Time Cards");
		vb.getChildren().add(timeCardButton);

		Button payButton = new Button();
		payButton.setText("Pay");
		vb.getChildren().add(payButton);

		Button salesButton = new Button();
		salesButton.setText("Sales");
		vb.getChildren().add(salesButton);

		Button paymentMethodButton = new Button();
		paymentMethodButton.setText("Payment Methods");
		vb.getChildren().add(paymentMethodButton);

		Button payrollButton = new Button();
		payrollButton.setText("Payroll");
		vb.getChildren().add(payrollButton);

		Button exitButton = new Button();
		exitButton.setText("Exit");
		vb.getChildren().add(exitButton);

		FlowPane vb2 = new FlowPane();
		vb2.setPadding(new Insets(35, 12, 15, 12));
		vb2.setVgap(15);
		vb2.setHgap(15);

		Label employeeIdLabel = new Label("Enter Employee ID:");
		vb2.getChildren().add(employeeIdLabel);

		TextField employeeIdTextField = new TextField();
		vb2.getChildren().add(employeeIdTextField);
		
		Label startDateLabel = new Label("Enter Start Date:");
		vb2.getChildren().add(startDateLabel);
		
		TextField startDateTextField = new TextField();
		vb2.getChildren().add(startDateTextField);
		
		Label endDateLabel = new Label("Enter End Date:");
		vb2.getChildren().add(endDateLabel);
		
		TextField endDateTextField = new TextField();
		vb2.getChildren().add(endDateTextField);

		Button processPayrollButton = new Button();
		processPayrollButton.setText("Process Payroll");
		vb2.getChildren().add(processPayrollButton);

		Scene scene1 = new Scene(vb, 350, 150);
		Scene scene2 = new Scene(vb2, 900, 400);
		primaryStage.setTitle("TitanPay App");
		primaryStage.setScene(scene1);
		primaryStage.show();

		payrollButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (e.getSource() == payrollButton) {
					theStage.setScene(scene2);
				} else {
					theStage.setScene(scene1);
				}
			}
		});

		processPayrollButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				int employeeId = Integer.parseInt(employeeIdTextField.getText());
				String startDateInput = startDateTextField.getText();
				String endDateInput = endDateTextField.getText();

				try {
					DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	    			Date startDate = format.parse(startDateInput);
	    			Date endDate = format.parse(endDateInput);
					
					application.MainController.processPayroll(employeeId, startDate, endDate);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

	}
}