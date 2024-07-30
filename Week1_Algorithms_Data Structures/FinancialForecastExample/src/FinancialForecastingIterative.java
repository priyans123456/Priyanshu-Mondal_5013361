public class FinancialForecastingIterative {
    public static double futureValueIterative(double PV, double r, int n) {
        double FV = PV;  
        for (int i = 0; i < n; i++) {
            FV *= (1 + r);  
        }
        return FV;  
    }

    public static void main(String[] args) {
        double PV = 1000;  // Present Value
        double r = 0.05;   // Growth rate (5%)
        int n = 10;        // Number of periods

        double forecastedValueIterative = futureValueIterative(PV, r, n);
        System.out.println("The forecasted value after " + n + " periods is: " + forecastedValueIterative);
    }
}
