package shippingTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import shipping.DeliveryOption;
import shipping.ShippingCostCalculator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ShippingCostCalculatorTestBVA {
    private final double purchaseAmount;
    private final int numItems;
    private final DeliveryOption deliveryOption;
    private final double expectedCost;

    private final ShippingCostCalculator calculator = new ShippingCostCalculator();

    // Constructor for parameterized test
    public ShippingCostCalculatorTestBVA(double purchaseAmount, int numItems, DeliveryOption deliveryOption, double expectedCost) {
        this.purchaseAmount = purchaseAmount;
        this.numItems = numItems;
        this.deliveryOption = deliveryOption;
        this.expectedCost = expectedCost;
    }



    // Method to supply test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            // Boundary Test Cases for Purchase Amount and Number of Items
        	{50, -1, DeliveryOption.WEEK, Double.NaN},        // Invalid numItems
            {50, 0, DeliveryOption.WEEK, Double.NaN},         // Invalid numItems
            {50, 1, DeliveryOption.WEEK, 1.5},       // Boundary numItems
            {50, 2, DeliveryOption.WEEK, 3.0},       // Nominal numItems
            {50, 3, DeliveryOption.WEEK, 4.5},       // Boundary numItems
            {50, 4, DeliveryOption.WEEK, 0.0},       // Above boundary
            {50, 10, DeliveryOption.WEEK, 0.0},      // Larger numItems

            // purchaseAmount = 50, SECOND_DAY
            {50, -1, DeliveryOption.SECOND_DAY, Double.NaN},  // Invalid numItems
            {50, 0, DeliveryOption.SECOND_DAY, Double.NaN},   // Invalid numItems
            {50, 1, DeliveryOption.SECOND_DAY, 10},  // Boundary numItems
            {50, 2, DeliveryOption.SECOND_DAY, 10},  // Nominal numItems
            {50, 3, DeliveryOption.SECOND_DAY, 10},  // Boundary numItems
            {50, 4, DeliveryOption.SECOND_DAY, 10},  // Above boundary
            {50, 10, DeliveryOption.SECOND_DAY, 25}, // Larger numItems
         // purchaseAmount = 50, SECOND_DAY, varying numItems
            {50, -1, DeliveryOption.NEXT_DAY, Double.NaN},   // Invalid numItems
            {50, 0, DeliveryOption.NEXT_DAY, Double.NaN},    // Invalid numItems
            {50, 1, DeliveryOption.NEXT_DAY, 25},   // Boundary numItems
            {50, 2, DeliveryOption.NEXT_DAY, 25},   // Nominal numItems
            {50, 3, DeliveryOption.NEXT_DAY, 25},   // Boundary numItems
            {50, 4, DeliveryOption.NEXT_DAY, 24},   // Above boundary
            {50, 10, DeliveryOption.NEXT_DAY, 60},  // Larger numItems

            //  purchaseAmount = 150, NEXT_DAY, varying numItems
            {150, -1, DeliveryOption.NEXT_DAY, Double.NaN},    // Invalid numItems
            {150, 0, DeliveryOption.NEXT_DAY, Double.NaN},     // Invalid numItems
            {150, 1, DeliveryOption.NEXT_DAY, 35},    // Boundary numItems
            {150, 2, DeliveryOption.NEXT_DAY, 35},    // Nominal numItems
            {150, 3, DeliveryOption.NEXT_DAY, 35},    // Boundary numItems
            {150, 4, DeliveryOption.NEXT_DAY, 30},    // Above boundary
            {150, 10, DeliveryOption.NEXT_DAY, 75}   , // Larger numItems
       
            // purchaseAmount = 150, WEEK
            {150, -1, DeliveryOption.WEEK, Double.NaN},       // Invalid numItems
            {150, 0, DeliveryOption.WEEK, Double.NaN},        // Invalid numItems
            {150, 1, DeliveryOption.WEEK, 10},      // Boundary numItems
            {150, 2, DeliveryOption.WEEK, 10},      // Nominal numItems
            {150, 3, DeliveryOption.WEEK, 10},      // Boundary numItems
            {150, 4, DeliveryOption.WEEK, 10.0},     // Above boundary
            {150, 10, DeliveryOption.WEEK, 25.0},    // Larger numItems

            // purchaseAmount = 150, SECOND DAy
            {150, -1, DeliveryOption.SECOND_DAY, Double.NaN},   // Invalid numItems
            {150, 0, DeliveryOption.SECOND_DAY, Double.NaN},    // Invalid numItems
            {150, 1, DeliveryOption.SECOND_DAY, 15},   // Boundary numItems
            {150, 2, DeliveryOption.SECOND_DAY, 15},   // Nominal numItems
            {150, 3, DeliveryOption.SECOND_DAY, 15},   // Boundary numItems
            {150, 4, DeliveryOption.SECOND_DAY, 3.5*4},   // Above boundary
            {150, 10, DeliveryOption.SECOND_DAY, 3.5*10},   // Larger numItems
            
            {-0.01, 2, DeliveryOption.WEEK, Double.NaN},
            {0, 2, DeliveryOption.WEEK, Double.NaN},
            {0.01, 2, DeliveryOption.WEEK, 3.0},
         
            {99.99, 2, DeliveryOption.WEEK, 3.0},
            {100, 2, DeliveryOption.WEEK, 3},
            {100.01, 2, DeliveryOption.WEEK, 10.0},


            {-0.01, 2, DeliveryOption.SECOND_DAY, Double.NaN},
            {0, 2, DeliveryOption.SECOND_DAY, Double.NaN},
            {0.01, 2, DeliveryOption.SECOND_DAY, 10.0},
            
            {99.99, 2, DeliveryOption.SECOND_DAY, 10.0},
            {100, 2, DeliveryOption.SECOND_DAY, 10},
            {100.01, 2, DeliveryOption.SECOND_DAY, 15.0},
  

            {-0.01, 2, DeliveryOption.NEXT_DAY, Double.NaN},
            {0, 2, DeliveryOption.NEXT_DAY, Double.NaN},
            {0.01, 2, DeliveryOption.NEXT_DAY, 25.0},
         
            {99.99, 2, DeliveryOption.NEXT_DAY, 25.0},
            {100, 2, DeliveryOption.NEXT_DAY, 25},
            {100.01, 2, DeliveryOption.NEXT_DAY, 35.0},


            // numItems = 10 (Nominal), varying purchaseAmount for all delivery options
            {-0.01, 10, DeliveryOption.WEEK, Double.NaN},
            {0, 10, DeliveryOption.WEEK, Double.NaN},
            {0.01, 10, DeliveryOption.WEEK, 0},
          
            {99.99, 10, DeliveryOption.WEEK, 0},
            {100, 10, DeliveryOption.WEEK, 0},
            {100.01, 10, DeliveryOption.WEEK, 25.0},


            {-0.01, 10, DeliveryOption.SECOND_DAY, Double.NaN},
            {0, 10, DeliveryOption.SECOND_DAY, Double.NaN},
            {0.01, 10, DeliveryOption.SECOND_DAY, 25.0},
       
            {99.99, 10, DeliveryOption.SECOND_DAY, 25.0},
            {100, 10, DeliveryOption.SECOND_DAY, 25.0},
            {100.01, 10, DeliveryOption.SECOND_DAY, 35.0},


            {-0.01, 10, DeliveryOption.NEXT_DAY, Double.NaN},
            {0, 10, DeliveryOption.NEXT_DAY, Double.NaN},
            {0.01, 10, DeliveryOption.NEXT_DAY, 60.0},
        
            {99.99, 10, DeliveryOption.NEXT_DAY, 60.0},
            {100, 10, DeliveryOption.NEXT_DAY, 60},
            {100.01, 10, DeliveryOption.NEXT_DAY, 75.0},

            
        });
        
        
        
    }

    // Test method
    @Test
    public void testCalculateShippingCost_BVA() {
        try {
            double actualCost = calculator.calculateShippingCost(purchaseAmount, numItems, deliveryOption);
            assertEquals(expectedCost, actualCost, 0.01);
        } catch (AssertionError e) {
            System.err.println("Assertion Failed:");
            System.err.println("Input: purchaseAmount = " + purchaseAmount + ", numItems = " + numItems + ", deliveryOption = " + deliveryOption);
            System.err.println("Expected: " + expectedCost + ", but got: " + calculator.calculateShippingCost(purchaseAmount, numItems, deliveryOption));
            throw e; 
        } catch (IllegalArgumentException e) {
 
        }
    }
    
    
}
