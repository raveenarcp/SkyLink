package skylink.pkg.Flight;

import ADT.Array;
import ADT.HashMap;
import ADT.Trie;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import skylink.pkg.Miscellaneous.SceneSwitcher;
import skylink.pkg.User.User;


public class FlightInformationController {

	/**
     * @param url
     * @param resourceBundle
     */
	
	private Trie trie; 

    @FXML
    private TextField searchTextField;
    
    @FXML
    private VBox vbox;
    @FXML
    private ScrollPane scrollPane;
    public boolean programStarted = false;
    
    
    public void fillDataOfFlights() {
        setScrollPane(scrollPane);
        if (!programStarted) {
            programStarted = true;
            showAllFlights();
        }
        else {
            clearOldData();
        }
        vboxStyling(vbox);
    }
    private void showAllFlights() {
        fillVbox();
    }

    private void clearOldData() {
        vbox.getChildren().clear();
    }
    private void fillVbox() {
        try {
            for(Flight flight : Flight.flights) {
                vbox.getChildren().add(createFlight(flight));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void vboxStyling(VBox vbox) {
        vbox.setSpacing(20);
        vbox.setStyle("-fx-background-color: white;");
    }
    public static void setScrollPane(ScrollPane scrollPane) {
        scrollPane.setPannable(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

    }
    private HBox createFlight(Flight flight){
        HBox hbox = new HBox();
        setHboxLabels(hbox, flight);
        hboxStyling(hbox);
        setHboxOnAction(hbox, flight);
        return hbox;
    }
    public static void hboxStyling(HBox hbox) {
        hboxStyle(hbox);
        hboxHover(hbox);
        hboxClicked(hbox);
    }
    public static void hboxStyle(HBox hbox) {
        hbox.setStyle("-fx-background-color: white;" +
                " -fx-border-width: 1;" +
                " -fx-border-color: black;");
    }
    public static void hboxHover(HBox hbox) {
        hbox.setOnMouseEntered(event ->{
            hbox.setStyle("-fx-background-color: #605DEC; -fx-border-color: black;");
            hbox.getChildren().forEach(node -> {
                if (node instanceof Label) {
                    setLabelStyle((Label) node, "white");
                }
            });
        });

        hbox.setOnMouseExited(event ->{
            hbox.setStyle("-fx-background-color: white; -fx-border-color: black;");
            hbox.getChildren().forEach(node -> {
                if (node instanceof Label) {
                    setLabelStyle((Label) node, "black");
                }
            });
        });
    }
    public static void hboxClicked(HBox hbox) {
        hbox.setOnMousePressed(event ->{
            hbox.setStyle("-fx-background-color: #4422ac; -fx-border-color: white;");
            hbox.getChildren().forEach(node -> {
                if (node instanceof Label) {
                    setLabelStyle((Label) node, "white");
                }
            });
        });
        hbox.setOnMouseReleased(event ->{
            hbox.setStyle("-fx-background-color: #605DEC; -fx-border-color: black;");
            hbox.getChildren().forEach(node -> {
                if (node instanceof Label) {
                    setLabelStyle((Label) node, "white");
                }
            });
        });
    }
    public static Label setLabelStyle(Label label, String color)  {
        if(color.equals("white")) {
            label.setStyle("-fx-pref-width: 250;" +
                    "-fx-padding: 25;" +
                    " -fx-border-width: 5;" +
                    " -fx-alignment: center;" +
                    " -fx-font-size: 14; " +
                    "-fx-text-fill: white");
            return label;
        }
        label.setStyle("-fx-pref-width: 250;" +
                "-fx-padding: 25;" +
                " -fx-border-width: 5;" +
                " -fx-alignment: center;" +
                " -fx-font-size: 14;" +
                "-fx-text-fill: black");
        return label;
    }
    private void setHboxLabels(HBox hbox, Flight flight) {
        setArrivalLabel(hbox, flight);
        setDepartureLabel(hbox, flight);
        setAirlineLabel(hbox, flight);
        setTimeLabel(hbox, flight);
        setDateLabel(hbox, flight);
        setPriceLabel(hbox, flight);
    }
    
    public static void setArrivalLabel(HBox hbox, Flight flight) {
    	Label arrivalLabel = createArrivalLabel(flight);
        FlightInformationController.setLabelStyle(arrivalLabel,"black");
        hbox.getChildren().add(arrivalLabel);
    }
    
    public static void setDepartureLabel(HBox hbox, Flight flight) {
    	Label departureLabel = createDepartureLabel(flight);
        FlightInformationController.setLabelStyle(departureLabel,"black");
        hbox.getChildren().add(departureLabel);
    }
    
    public static void setAirlineLabel(HBox hbox, Flight flight) {
        Label airLineLabel = createAirlineLabel(flight);
        FlightInformationController.setLabelStyle(airLineLabel,"black");
        hbox.getChildren().add(airLineLabel);
    }
    public static void setTimeLabel(HBox hbox, Flight flight) {
        Label timeLabel = createTimeLabel(flight);
        FlightInformationController.setLabelStyle(timeLabel,"black");
        hbox.getChildren().add(timeLabel);
    }
    public static void setDateLabel(HBox hbox, Flight flight) {
        Label dateLabel = createDateLabel(flight);
        FlightInformationController.setLabelStyle(dateLabel,"black");
        hbox.getChildren().add(dateLabel);
    }
    private void setPriceLabel(HBox hbox, Flight flight) {
        Label priceLabel = createPriceLabel(flight);
        FlightInformationController.setLabelStyle(priceLabel,"black");
        hbox.getChildren().add(priceLabel);
    }
    public static Label createAirlineLabel(Flight flight) {
        return new Label(flight.getAirlineName() + " Airlines");
    }
    
    public static Label createArrivalLabel(Flight flight) {
        return new Label(flight.getArrivalAirport().getCode());
    }
    
    public static Label createDepartureLabel(Flight flight) {
        return new Label(flight.getDepartureAirport().getCode());
    }
    
    public static Label createTimeLabel(Flight flight) {
        return new Label(flight.getDepartureTime().getHour() + ":" + flight.getDepartureTime().getMinutes()
                + " " + flight.getDepartureTime().getPeriod()
                + " - " + flight.getArrivalTime().getHour() + ":" + flight.getArrivalTime().getMinutes()
                + " " + flight.getArrivalTime().getPeriod());
    }
    public static Label createDateLabel(Flight flight) {
        return new Label(flight.getDepartureDate().getDay()
                + "-" + flight.getDepartureDate().getMonth()
                + "-" + flight.getDepartureDate().getYear());
    }
    private Label createPriceLabel(Flight flight) {
        return new Label(Integer.toString(flight.getEconomyPrice()));
    }
//    private void setHboxOnAction(HBox hbox, Flight flight) {
//        hbox.setOnMouseClicked(event -> {
//            try {
//                invalidInputOfPassengersMsg.setVisible(!validNum(numOfPassengers));
//                if(validNum(numOfPassengers)) {
//                    FlightDetailsConfirmationController.handleHBoxClick(flight, getNumberOfPassengers());
//                }
//
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//    }
    
    private void setHboxOnAction(HBox hbox, Flight flight) {
        hbox.setOnMouseClicked(event -> {
            try {
                invalidInputOfPassengersMsg.setVisible(!validNum(numOfPassengers));
                
                setCurrentFlight(flight);
                if (validNum(numOfPassengers)) {
                    User currentUser = User.currentUser;
                    Alert seatsAvailableAlert = new Alert(AlertType.INFORMATION);
                    seatsAvailableAlert.setTitle("Available Seats");
                    seatsAvailableAlert.setHeaderText(null);

                    // Display available seats information
                    seatsAvailableAlert.setContentText("Available seats: " + flight.getAvailableSeats());
                    seatsAvailableAlert.showAndWait();

                    if (validNumOfPassengers(flight)) 
                    {
                        // If there are available seats, proceed with the booking
                    	if (!flight.getWaitlist().isEmpty() && flight.getAvailableSeats() > 0) 
                    	{
                            // If queue is not empty and available seats are greater than zero, allow the user at the front of the queue
                            User firstUserInQueue = flight.getWaitlist().getFront();
                            System.out.println(firstUserInQueue.getUserName());
                            if (firstUserInQueue.getUserName().equals(currentUser.getUserName())) {
                                // If the current user is at the front of the waitlist, allow them to proceed
                                FlightDetailsConfirmationController.handleHBoxClick(flight, getNumberOfPassengers());
                            } else {
                                // If the current user is not at the front of the waitlist, inform them
                                Alert waitlistAlert = new Alert(AlertType.INFORMATION);
                                waitlistAlert.setTitle("Waitlist");
                                waitlistAlert.setHeaderText(null);
                                waitlistAlert.setContentText("You are not at the front of the waitlist. Please wait for your turn.");
                                waitlistAlert.showAndWait();
                            }
                    	}
                    	else
                    	{
                    		FlightDetailsConfirmationController.handleHBoxClick(flight, getNumberOfPassengers());
                    	}
                        
                    } 
                    else 
                    {
                        // If the number of passengers requested exceeds available seats, check waitlist
                        if (!flight.getWaitlist().isEmpty() && flight.getAvailableSeats() > 0) {
                            // If queue is not empty and available seats are greater than zero, allow the user at the front of the queue
                            User firstUserInQueue = flight.getWaitlist().getFront();
                            System.out.println(firstUserInQueue.getUserName());
                            if (firstUserInQueue.getUserName().equals(currentUser.getUserName())) {
                                // If the current user is at the front of the waitlist, allow them to proceed
                                FlightDetailsConfirmationController.handleHBoxClick(flight, getNumberOfPassengers());
                            } else {
                                // If the current user is not at the front of the waitlist, inform them
                                Alert waitlistAlert = new Alert(AlertType.INFORMATION);
                                waitlistAlert.setTitle("Waitlist");
                                waitlistAlert.setHeaderText(null);
                                waitlistAlert.setContentText("You are not at the front of the waitlist. Please wait for your turn.");
                                waitlistAlert.showAndWait();
                            }
                        } else {
                            // If queue is empty or available seats are not greater than zero, add the user to the waitlist
                            if (!flight.getWaitlist().contains(currentUser)) {
                                // If user is not already in the waitlist, add them
                                flight.addToWaitlist(currentUser);
                                Alert waitlistAlert = new Alert(AlertType.INFORMATION);
                                waitlistAlert.setTitle("Waitlist");
                                waitlistAlert.setHeaderText(null);
                                waitlistAlert.setContentText("Sorry, no more seats available. You have been added to the waitlist.");
                                waitlistAlert.showAndWait();
                            } else {
                                // If user is already in the waitlist, inform them
                                Alert waitlistAlert = new Alert(AlertType.INFORMATION);
                                waitlistAlert.setTitle("Waitlist");
                                waitlistAlert.setHeaderText(null);
                                waitlistAlert.setContentText("You are already in the waitlist. Please wait for your turn.");
                                waitlistAlert.showAndWait();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    private TextField numOfPassengers;
    @FXML
    private Label invalidInputOfPassengersMsg;

    public static HashMap<String, Boolean> departureAirports = new HashMap<String, Boolean>();
    public static HashMap<String, Boolean> arrivalAirports = new HashMap<String, Boolean>();
    public static HashMap<String, Boolean> airlines = new HashMap<String, Boolean>();
//
    private void fillMaps() {
        for (Flight flight : Flight.flights) {
            fillDepartureAirportsMap(flight);
            fillArrivalAirportsMap(flight);
            fillAirlinesMap(flight);
        }
    }
    private void fillDepartureAirportsMap(Flight flight) {
        if(departureAirports.get(flight.getDepartureAirport().getCode()) == null) {
            MenuItem departureAirportCode = new MenuItem(flight.getDepartureAirport().getCode());
            departureAirports.put(flight.getDepartureAirport().getCode() , true);
        }
    }
    private void fillArrivalAirportsMap(Flight flight) {
        if(arrivalAirports.get(flight.getArrivalAirport().getCode()) == null) {
            MenuItem arrivalAirportCode = new MenuItem(flight.getArrivalAirport().getCode());
            arrivalAirports.put(flight.getArrivalAirport().getCode() , true);
        }
    }
    private void fillAirlinesMap(Flight flight) {
        if(airlines.get(flight.getAirlineName()) == null){
            MenuItem airlines = new MenuItem(flight.getAirlineName());
            this.airlines.put(flight.getAirlineName(), true);
        }
    }

    private boolean validNumOfPassengers(Flight flight) {
        return getNumberOfPassengers() <= flight.getAvailableSeats();
    }
    private boolean validNum(String text) {
        try {
            int value = Integer.parseInt(text);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }
    private boolean validNum(TextField numOfPassengers) {
        String text = numOfPassengers.getText().trim();
        if (!text.isEmpty()) {
            return validNum(text);
        }
        return false;
    }

    private int getNumberOfPassengers() {
        return Integer.parseInt(numOfPassengers.getText());
    }

    @FXML
    private Label logOutLabel;

    @FXML
    private void onLogoutButtonPressed(MouseEvent e)
    {
        User.currentUser = null;
        SceneSwitcher.switchScene(e, "/skylink/pkg/HomePage/HomePage", null);
    }
//
    public void onProfileLogoClicked(MouseEvent event){
        SceneSwitcher.switchScene(event, "UserHistory", null);
    }
//
    public void onFlightsButtonClicked(MouseEvent event){
        SceneSwitcher.switchScene(event, "SearchFlightPage", null);
    }
    public FlightInformationController() {
        trie = new Trie();
        fillTrieWithData(); // Add your data to Trie
    }
    
    @FXML
    public void initialize() {
        // Check if searchTextField is properly initialized
        if (searchTextField != null) {
            searchTextField.setOnKeyReleased(this::handleAutoComplete);
        } else {
            System.out.println("searchTextField is null. Make sure it's properly initialized.");
        }
    }
    
    
 
    private void fillTrieWithData() {
    	for (Flight flight : Flight.flights) {
            trie.insert(flight.getAirlineName()); // Example: Insert airline names into Trie
        }
    }
    
    
    public Array<String> autoComplete(String prefix) {
        Array<String> suggestions = new Array<>();
        Trie.TrieNode lastNode = trie.root;

        // Traverse the trie to the last node of the prefix
        for (char ch : prefix.toCharArray()) {
            if (!lastNode.children.containsKey(ch)) {
                return suggestions; // Prefix not found, return empty list
            }
            lastNode = lastNode.children.get(ch);
        }

        // Collect all words starting with the prefix
        collectSuggestions(lastNode, prefix, suggestions);
        return suggestions;
    }

    private void collectSuggestions(Trie.TrieNode node, String prefix, Array<String> suggestions) {
        if (node.isEndOfWord) {
            suggestions.add(prefix);
        }

        for (char ch : node.children.keySet()) {
            collectSuggestions(node.children.get(ch), prefix + ch, suggestions);
        }
    }
    
    public void handleAutoComplete(KeyEvent event) {
        String input = searchTextField.getText(); 
        if (trie == null) {
            System.err.println("Trie is not initialized.");
            return;
        }
        

        Array<String> suggestions = autoComplete(input);
        if (!suggestions.isEmpty()) {
            // Clear previous suggestions
            vbox.getChildren().clear();

            for (String suggestion : suggestions) {
                Array<Flight> suggestedFlights = findFlightsByAirlineName(suggestion); // Use the updated method that returns a list of flights
                for (Flight flight : suggestedFlights) {
                    if (flight != null) {
                        HBox hbox = createFlight(flight);  
                        vbox.getChildren().add(hbox);
                    }
                }
            }
        } else {
            vbox.getChildren().clear();
        }
    }

    private Array<Flight> findFlightsByAirlineName(String airlineName) {
        Array<Flight> matchingFlights = new Array<>();
        for (Flight flight : Flight.flights) {
            if (flight.getAirlineName().equalsIgnoreCase(airlineName)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }
    public void sortByName() {
        Array<Flight> flightsArray = Flight.flights; 
        mergeSortByName(flightsArray, 0, flightsArray.size() - 1);
        updateUIWithSortedFlights(flightsArray);
    }

    private void mergeSortByName(Array<Flight> flights, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortByName(flights, left, mid);
            mergeSortByName(flights, mid + 1, right);
            mergeByName(flights, left, mid, right);
        }
    }

    private void mergeByName(Array<Flight> flights, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Array<Flight> leftArray = new Array<>(n1);
        Array<Flight> rightArray = new Array<>(n2);

        for (int i = 0; i < n1; ++i) {
            leftArray.add(flights.get(left + i));
        }
        for (int j = 0; j < n2; ++j) {
            rightArray.add(flights.get(mid + 1 + j));
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray.get(i).getAirlineName().compareToIgnoreCase(rightArray.get(j).getAirlineName()) <= 0) {
                flights.set(k, leftArray.get(i));
                i++;
            } else {
                flights.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            flights.set(k, leftArray.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            flights.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }

    private void updateUIWithSortedFlights(Array<Flight> sortedFlights) {
        vbox.getChildren().clear(); // Clear existing flights in UI

        for (Flight flight : sortedFlights) {
            vbox.getChildren().add(createFlight(flight));
        }
    }
   

    
    public void sortByPrice() {
    	Array<Flight> flightsArray = Flight.flights; 
        insertionSortByPrice(flightsArray);
        updateUIWithSortedFlights(flightsArray);
    }
    
    private void insertionSortByPrice(Array<Flight> flights) {
        int n = flights.size();
        for (int i = 1; i < n; i++) {
            Flight key = flights.get(i);
            int j = i - 1;

            while (j >= 0 && flights.get(j).getEconomyPrice() > key.getEconomyPrice()) {
                flights.set(j + 1, flights.get(j));
                j = j - 1;
            }
            flights.set(j + 1, key);
        }
    }
    
    public void sortByArrivalAirport() {
        Array<Flight> flightsArray = Flight.flights; 
        quickSortByArrivalAirport(flightsArray, 0, flightsArray.size() - 1);
        updateUIWithSortedFlights(flightsArray);
    }

    private void quickSortByArrivalAirport(Array<Flight> flights, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionByArrivalAirport(flights, low, high);
            quickSortByArrivalAirport(flights, low, partitionIndex - 1);
            quickSortByArrivalAirport(flights, partitionIndex + 1, high);
        }
    }

    private int partitionByArrivalAirport(Array<Flight> flights, int low, int high) {
        Flight pivot = flights.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (flights.get(j).getArrivalAirport().getCode().compareToIgnoreCase(pivot.getArrivalAirport().getCode()) <= 0) {
                i++;
                Flight temp = flights.get(i);
                flights.set(i, flights.get(j));
                flights.set(j, temp);
            }
        }
        Flight temp = flights.get(i + 1);
        flights.set(i + 1, flights.get(high));
        flights.set(high, temp);
        return i + 1;
    }
    
    Flight currentFlight = new Flight();
    public Flight getCurrentFlight() {
		return currentFlight;
	}
	public void setCurrentFlight(Flight currentFlight) {
		this.currentFlight = currentFlight;
	}

    
    
}
