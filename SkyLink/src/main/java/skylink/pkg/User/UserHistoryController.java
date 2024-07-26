package skylink.pkg.User;

import java.net.URL;
import java.util.ResourceBundle;

import ADT.Array;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import skylink.pkg.Booking.BookingConfirmation;
import skylink.pkg.Flight.Flight;
import skylink.pkg.Miscellaneous.SceneSwitcher;
import skylink.pkg.Passenger.Passenger;
import skylink.pkg.Passenger.PassengersController;
import skylink.pkg.Seat.Seat;
import skylink.pkg.Seat.SeatType;

public class UserHistoryController implements Initializable {

    @FXML
    VBox bookingsVbox;
    @FXML
    Label youHaveXFlights;
    @FXML
    Button backButton;

    private int userBookingsCount = 0;
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        for(BookingConfirmation booking : BookingConfirmation.bookingRecords){
//            //System.out.println(booking.getUserName() + " " + User.currentUser.name + " " + booking.getPaymentStatus());
//            if(booking.getUserName().equals(User.currentUser.getUserName()) && booking.payment.getPaymentStatus().equals("Payed")) {
//                userBookingsCount++;
//                HBox bookingHbox = new HBox(5);
//                bookingHbox.setAlignment(Pos.CENTER);
//                bookingHbox.setPrefHeight(60);
//                bookingHbox.setStyle("-fx-background-color: white;" +
//                        " -fx-border-width: 0.4;" +
//                        " -fx-border-color: grey;");
//
//                Label airline = new Label(booking.getAirLineName());
//                airline.setStyle(" -fx-font-size: 18;" +
//                        "-fx-text-fill: black;" +
//                        "-fx-padding: 15;" +
//                        "-fx-font-weight: bold;" +
//                        " -fx-border-width: 5");
//
//                Label flightTimeSchedule = new Label(booking.getDepartureTime() + " - " + booking.getArrivalTime());
//
//                flightTimeSchedule.setStyle(" -fx-font-size: 18;" +
//                        "-fx-text-fill: black;" +
//                        "-fx-padding: 15;" +
//                        "-fx-font-weight: bold;" +
//                        " -fx-border-width: 5");
//
//                Label arrivalDate = new Label(booking.getArrivalDate());
//                arrivalDate.setStyle(" -fx-font-size: 18;" +
//                        "-fx-text-fill: black;" +
//                        "-fx-padding: 15;" +
//                        "-fx-font-weight: bold;" +
//                        " -fx-border-width: 5");
//
//                Label arrivalDayText = new Label("Arrival Day");
//                arrivalDayText.setStyle(" -fx-font-size: 18;" +
//                        "-fx-text-fill: black;" +
//                        "-fx-padding: 15;" +
//                        "-fx-font-weight: bold;" +
//                        " -fx-border-width: 5");
//
//                Image bookingCancelImage = new Image("BookingCancelIcon.png");
//                ImageView bookingCancelIcon = new ImageView(bookingCancelImage);
//                bookingCancelIcon.setStyle("-fx-padding: 30;");
//
//                bookingCancelIcon.setOnMousePressed(event -> {
//                    booking.payment.setPaymentStatus("Refunded");
//                    bookingsVbox.getChildren().remove(bookingHbox);
//                    youHaveXFlights.setText("You have " + --userBookingsCount + " Flights");
//                });
//
//                bookingHbox.getChildren().add(airline);
//                bookingHbox.getChildren().add(flightTimeSchedule);
//                bookingHbox.getChildren().add(arrivalDayText);
//                bookingHbox.getChildren().add(arrivalDate);
//                bookingHbox.getChildren().add(bookingCancelIcon);
//
//                bookingsVbox.getChildren().add(bookingHbox);
//            }
//            youHaveXFlights.setText("You have " + userBookingsCount + " Flights");
//        }
//    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	Array<BookingConfirmation> bookingsToRemove = new Array<>();
        for(BookingConfirmation booking : BookingConfirmation.bookingRecords){
            //System.out.println(booking.getUserName() + " " + User.currentUser.name + " " + booking.getPaymentStatus());
            if(booking.getUserName().equals(User.currentUser.getUserName()) && booking.payment.getPaymentStatus().equals("Payed")) {
                userBookingsCount++;
                HBox bookingHbox = new HBox(5);
                bookingHbox.setAlignment(Pos.CENTER);
                bookingHbox.setPrefHeight(60);
                bookingHbox.setStyle("-fx-background-color: white;" +
                        " -fx-border-width: 0.4;" +
                        " -fx-border-color: grey;");

                Label airline = new Label(booking.getAirLineName());
                airline.setStyle(" -fx-font-size: 18;" +
                        "-fx-text-fill: black;" +
                        "-fx-padding: 15;" +
                        "-fx-font-weight: bold;" +
                        " -fx-border-width: 5");

                Label flightTimeSchedule = new Label(booking.getDepartureTime() + " - " + booking.getArrivalTime());

                flightTimeSchedule.setStyle(" -fx-font-size: 18;" +
                        "-fx-text-fill: black;" +
                        "-fx-padding: 15;" +
                        "-fx-font-weight: bold;" +
                        " -fx-border-width: 5");

                Label arrivalDate = new Label(booking.getArrivalDate());
                arrivalDate.setStyle(" -fx-font-size: 18;" +
                        "-fx-text-fill: black;" +
                        "-fx-padding: 15;" +
                        "-fx-font-weight: bold;" +
                        " -fx-border-width: 5");

                Label arrivalDayText = new Label("Arrival Day");
                arrivalDayText.setStyle(" -fx-font-size: 18;" +
                        "-fx-text-fill: black;" +
                        "-fx-padding: 15;" +
                        "-fx-font-weight: bold;" +
                        " -fx-border-width: 5");

                Image bookingCancelImage = new Image("BookingCancelIcon.png");
                ImageView bookingCancelIcon = new ImageView(bookingCancelImage);
                bookingCancelIcon.setStyle("-fx-padding: 30;");

                bookingCancelIcon.setOnMousePressed(event -> {
                    // Iterate through each passenger in the booking
                    for (Passenger passenger : booking.getBookingPassengers()) {
                        Seat seat = passenger.getSeat();
                        if (seat != null) {
                            // Set the color of the seat back to its original color
                            SeatType seatType = seat.getType();
                            if (seatType != null) {
                                Paint originalColor = seatType.getColor();
                                seat.getRec().setFill(originalColor);
                            }
                        }
                    }

                    // Increase the available seats count in the flight
                    Flight flight = findFlightByBooking(booking);
                    if (flight != null) {
                        // Assuming the number of passengers in the booking indicates the number of reserved seats
                        flight.setAvailableSeats(flight.getAvailableSeats() + booking.getBookingPassengers().size());
                        // Mark seats as available
                        boolean[][] seatsAvailability = flight.getSeatsAvailability();
                        for (Passenger passenger : booking.getBookingPassengers()) {
                            Seat seat = passenger.getSeat();
                            if (seat != null) {
                                int row = seat.getRow();
                                int col = seat.getCol();
                                if (row >= 0 && row < seatsAvailability.length && col >= 0 && col < seatsAvailability[0].length) {
                                    seatsAvailability[row][col] = true;
                                }
                            }
                        }
                    }
                    bookingsToRemove.add(booking);
                    // Remove booking from UI
                    bookingsVbox.getChildren().remove(bookingHbox);

                    // Update the displayed number of flights
                    youHaveXFlights.setText("You have " + --userBookingsCount + " Flights");
                });


                bookingHbox.getChildren().add(airline);
                bookingHbox.getChildren().add(flightTimeSchedule);
                bookingHbox.getChildren().add(arrivalDayText);
                bookingHbox.getChildren().add(arrivalDate);
                bookingHbox.getChildren().add(bookingCancelIcon);

                bookingsVbox.getChildren().add(bookingHbox);
            }
//            for (BookingConfirmation booking1 : bookingsToRemove) {
//                BookingConfirmation.bookingRecords.remove(booking1);
//            }
            youHaveXFlights.setText("You have " + userBookingsCount + " Flights");
        }
        
    }
    
    private Flight findFlightByBooking(BookingConfirmation booking) {
        int bookingFlightNumber = Integer.parseInt(booking.getFlightID());

        // Search for the flight associated with the booking
        for (Flight flight : Flight.flights) {
            // Compare the flight number as integers
            if (flight.getFlightNumber() == bookingFlightNumber) {
                return flight;
            }
        }
        return null;
    }

    public void onBackButtonPressed(MouseEvent event){
        // Reset passengers data
        Passenger.passengers.clear();
        PassengersController.curPassenger = 0;

        SceneSwitcher.switchScene(event, "SearchFlightPage", null);
    }

    public void onLogoutButtonPressed(MouseEvent event){
        // Reset passengers data
        Passenger.passengers.clear();
        PassengersController.curPassenger = 0;

        SceneSwitcher.switchScene(event, "HomePage/HomePage", null);
    }
    
}
