module flyxpert.flyxpert {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.xml;
	requires javafx.graphics;
	requires javafx.base;

	opens skylink.pkg to javafx.fxml;

	exports skylink.pkg;
	exports skylink.pkg.Admin;

	opens skylink.pkg.Admin to javafx.fxml;

	exports skylink.pkg.Flight;

	opens skylink.pkg.Flight to javafx.fxml;

	exports skylink.pkg.User;

	opens skylink.pkg.User to javafx.fxml;

	exports skylink.pkg.Payment;

	opens skylink.pkg.Payment to javafx.fxml;

	exports skylink.pkg.Seat;

	opens skylink.pkg.Seat to javafx.fxml;

	exports skylink.pkg.Passenger;

	opens skylink.pkg.Passenger to javafx.fxml;

	exports skylink.pkg.File;

	opens skylink.pkg.File to javafx.fxml;

	exports skylink.pkg.Booking;

	opens skylink.pkg.Booking to javafx.fxml;

	exports skylink.pkg.Miscellaneous;

	opens skylink.pkg.Miscellaneous to javafx.fxml;
}