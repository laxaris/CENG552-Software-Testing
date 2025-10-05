package shipping;

public class ShippingCostCalculator {

    public double calculateShippingCost(double purchaseAmount, int numItems, DeliveryOption deliveryOption) {
    	
    	double cost = 0; 

        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("Purchase amount must be greater than zero!");
        }
        if (numItems <= 0) {
            throw new IllegalArgumentException("Number of items must be greater than zero!");
        }
        if (deliveryOption == null) {
            throw new IllegalArgumentException("Delivery option cannot be null!");
        }


        if (purchaseAmount <= 100) {
            if (numItems <= 3) {
                switch (deliveryOption) {
                    case NEXT_DAY:
                        cost = 25;
                        break;
                    case SECOND_DAY:
                        cost = 10;
                        break;
                    case WEEK:
                        cost = numItems * 1.50;
                        break;
                }
            } else {
                switch (deliveryOption) {
                    case NEXT_DAY:
                        cost = numItems * 6.00;
                        break;
                    case SECOND_DAY:
                        cost = numItems * 2.50;
                        break;
                    case WEEK:
                        cost = 0;
                        break;
                }
            }
        } else { // purchaseAmount > 100
            if (numItems <= 3) {
                switch (deliveryOption) {
                    case NEXT_DAY:
                        cost = 35;
                        break;
                    case SECOND_DAY:
                        cost = 15;
                        break;
                    case WEEK:
                        cost = 10;
                        break;
                }
            } else {
                switch (deliveryOption) {
                    case NEXT_DAY:
                        cost = numItems * 7.50; 
                        break;
                    case SECOND_DAY:
                        cost = numItems * 3.50;
                        break;
                    case WEEK:
                        cost = numItems * 2.50;
                        break;
                }
            }
        }
        
        return cost;

    }
}