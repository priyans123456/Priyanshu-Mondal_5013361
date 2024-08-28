public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double futureValue(double PV, double r, int n) {
        if (n == 0) {
            return PV;  
        } else {
            return futureValue(PV, r, n - 1) * (1 + r);  // Recursive case: call method for n-1 periods
        }
    }

    public static void main(String[] args) {
        double PV = 1000;  // Present Value
        double r = 0.05;   // Growth rate (5%)
        int n = 10;        // Number of periods

        double forecastedValue = futureValue(PV, r, n);
        System.out.println("The forecasted value after " + n + " periods is: " + forecastedValue);
    }
}
