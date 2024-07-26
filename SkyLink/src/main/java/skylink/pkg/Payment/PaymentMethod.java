package skylink.pkg.Payment;

public interface PaymentMethod {
    double calculateTotalPriceWithFees(double subTotal);
    String getPaymentMethodName();
}
