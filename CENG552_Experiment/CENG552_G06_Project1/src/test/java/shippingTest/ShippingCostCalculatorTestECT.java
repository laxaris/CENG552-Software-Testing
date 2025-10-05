package shippingTest;

import org.junit.*;

import shipping.DeliveryOption;
import shipping.ShippingCostCalculator;

import static org.junit.Assert.*;

public class ShippingCostCalculatorTestECT {
    private ShippingCostCalculator calculator;

    @Before
    public void setUp() {
        calculator = new ShippingCostCalculator();
    }
 // Test 1: Purchase Amount = -1, Number of Items = -1, Delivery Option = NEXT_DAY
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_InvalidPurchaseAmountAndItems_NextDay_ThrowsException() {
        calculator.calculateShippingCost(-1, -1, DeliveryOption.NEXT_DAY);
    }

    // Test 2: Purchase Amount = -1, Number of Items = -1, Delivery Option = SECOND_DAY
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_InvalidPurchaseAmountAndItems_SecondDay_ThrowsException() {
        calculator.calculateShippingCost(-1, -1, DeliveryOption.SECOND_DAY);
    }

    // Test 3: Purchase Amount = -1, Number of Items = -1, Delivery Option = WEEK
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_InvalidPurchaseAmountAndItems_Week_ThrowsException() {
        calculator.calculateShippingCost(-1, -1, DeliveryOption.WEEK);
    }

    // Test 4: Purchase Amount = -1, Number of Items = 2, Delivery Option = NEXT_DAY
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_InvalidPurchaseAmountWithValidItems_NextDay_ThrowsException() {
        calculator.calculateShippingCost(-1, 2, DeliveryOption.NEXT_DAY);
    }

    // Test 5: Purchase Amount = -1, Number of Items = 2, Delivery Option = SECOND_DAY
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_InvalidPurchaseAmountWithValidItems_SecondDay_ThrowsException() {
        calculator.calculateShippingCost(-1, 2, DeliveryOption.SECOND_DAY);
    }

    // Test 6: Purchase Amount = -1, Number of Items = 2, Delivery Option = WEEK
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_InvalidPurchaseAmountWithValidItems_Week_ThrowsException() {
        calculator.calculateShippingCost(-1, 2, DeliveryOption.WEEK);
    }

    // Test 7: Purchase Amount = -1, Number of Items = 5, Delivery Option = NEXT_DAY
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_InvalidPurchaseAmountWithManyItems_NextDay_ThrowsException() {
        calculator.calculateShippingCost(-1, 5, DeliveryOption.NEXT_DAY);
    }

    // Test 8: Purchase Amount = -1, Number of Items = 5, Delivery Option = SECOND_DAY
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_InvalidPurchaseAmountWithManyItems_SecondDay_ThrowsException() {
        calculator.calculateShippingCost(-1, 5, DeliveryOption.SECOND_DAY);
    }

    // Test 9: Purchase Amount = -1, Number of Items = 5, Delivery Option = WEEK
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_InvalidPurchaseAmountWithManyItems_Week_ThrowsException() {
        calculator.calculateShippingCost(-1, 5, DeliveryOption.WEEK);
    }

    // Test 10: Purchase Amount = 50, Number of Items = -1, Delivery Option = NEXT_DAY
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_ValidPurchaseAmountWithInvalidItems_NextDay_ThrowsException() {
        calculator.calculateShippingCost(50, -1, DeliveryOption.NEXT_DAY);
    }

    // Test 11: Purchase Amount = 50, Number of Items = -1, Delivery Option = SECOND_DAY
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_ValidPurchaseAmountWithInvalidItems_SecondDay_ThrowsException() {
        calculator.calculateShippingCost(50, -1, DeliveryOption.SECOND_DAY);
    }

    // Test 12: Purchase Amount = 50, Number of Items = -1, Delivery Option = WEEK
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_ValidPurchaseAmountWithInvalidItems_Week_ThrowsException() {
        calculator.calculateShippingCost(50, -1, DeliveryOption.WEEK);
    }

    // Test 13: Purchase Amount = 50, Number of Items = 2, Delivery Option = NEXT_DAY
    @Test
    public void calculateShippingCost_ValidPurchaseAmountWithFewItems_NextDay_Returns25() {
        double cost = calculator.calculateShippingCost(50, 2, DeliveryOption.NEXT_DAY);
        assertEquals(25.0, cost, 0.01);
    }

    // Test 14: Purchase Amount = 50, Number of Items = 2, Delivery Option = SECOND_DAY
    @Test
    public void calculateShippingCost_ValidPurchaseAmountWithFewItems_SecondDay_Returns10() {
        double cost = calculator.calculateShippingCost(50, 2, DeliveryOption.SECOND_DAY);
        assertEquals(10.0, cost, 0.01);
    }

    // Test 15: Purchase Amount = 50, Number of Items = 2, Delivery Option = WEEK
    @Test
    public void calculateShippingCost_ValidPurchaseAmountWithFewItems_Week_Returns3() {
        double cost = calculator.calculateShippingCost(50, 2, DeliveryOption.WEEK);
        assertEquals(3.0, cost, 0.01);
    }

    // Test 16: Purchase Amount = 50, Number of Items = 5, Delivery Option = NEXT_DAY
    @Test
    public void calculateShippingCost_ValidPurchaseAmountWithManyItems_NextDay_Returns30() {
        double cost = calculator.calculateShippingCost(50, 5, DeliveryOption.NEXT_DAY);
        assertEquals(30.0, cost, 0.01);
    }

    // Test 17: Purchase Amount = 50, Number of Items = 5, Delivery Option = SECOND_DAY
    @Test
    public void calculateShippingCost_ValidPurchaseAmountWithManyItems_SecondDay_Returns12_5() {
        double cost = calculator.calculateShippingCost(50, 5, DeliveryOption.SECOND_DAY);
        assertEquals(12.5, cost, 0.01);
    }

    // Test 18: Purchase Amount = 50, Number of Items = 5, Delivery Option = WEEK
    @Test
    public void calculateShippingCost_ValidPurchaseAmountWithManyItems_Week_Returns0() {
        double cost = calculator.calculateShippingCost(50, 5, DeliveryOption.WEEK);
        assertEquals(0.0, cost, 0.01);
    }

    // Test 19: Purchase Amount = 150, Number of Items = -1, Delivery Option = NEXT_DAY
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_HighPurchaseAmountWithInvalidItems_NextDay_ThrowsException() {
        calculator.calculateShippingCost(150, -1, DeliveryOption.NEXT_DAY);
    }
    // Test 20: Purchase Amount = 150, Number of Items = -1, Delivery Option = SECOND_DAY
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_HighPurchaseAmountWithInvalidItems_SecondDay_ThrowsException() {
        calculator.calculateShippingCost(150, -1, DeliveryOption.SECOND_DAY);
    }

    // Test 21: Purchase Amount = 150, Number of Items = -1, Delivery Option = WEEK
    @Test(expected = IllegalArgumentException.class)
    public void calculateShippingCost_HighPurchaseAmountWithInvalidItems_Week_ThrowsException() {
        calculator.calculateShippingCost(150, -1, DeliveryOption.WEEK);
    }

    // Test 22: Purchase Amount = 150, Number of Items = 2, Delivery Option = NEXT_DAY
    @Test
    public void calculateShippingCost_HighPurchaseAmountWithFewItems_NextDay_Returns35() {
        double cost = calculator.calculateShippingCost(150, 2, DeliveryOption.NEXT_DAY);
        assertEquals(35.0, cost, 0.01);
    }

    // Test 23: Purchase Amount = 150, Number of Items = 2, Delivery Option = SECOND_DAY
    @Test
    public void calculateShippingCost_HighPurchaseAmountWithFewItems_SecondDay_Returns15() {
        double cost = calculator.calculateShippingCost(150, 2, DeliveryOption.SECOND_DAY);
        assertEquals(15.0, cost, 0.01);
    }

    // Test 24: Purchase Amount = 150, Number of Items = 2, Delivery Option = WEEK
    @Test
    public void calculateShippingCost_HighPurchaseAmountWithFewItems_Week_Returns10() {
        double cost = calculator.calculateShippingCost(150, 2, DeliveryOption.WEEK);
        assertEquals(10.0, cost, 0.01);
    }

    // Test 25: Purchase Amount = 150, Number of Items = 5, Delivery Option = NEXT_DAY
    @Test
    public void calculateShippingCost_HighPurchaseAmountWithManyItems_NextDay_Returns37_5() {
        double cost = calculator.calculateShippingCost(150, 5, DeliveryOption.NEXT_DAY);
        assertEquals(37.5, cost, 0.01);
    }

    // Test 26: Purchase Amount = 150, Number of Items = 5, Delivery Option = SECOND_DAY
    @Test
    public void calculateShippingCost_HighPurchaseAmountWithManyItems_SecondDay_Returns17_5() {
        double cost = calculator.calculateShippingCost(150, 5, DeliveryOption.SECOND_DAY);
        assertEquals(17.5, cost, 0.01);
    }

    // Test 27: Purchase Amount = 150, Number of Items = 5, Delivery Option = WEEK
    @Test
    public void calculateShippingCost_HighPurchaseAmountWithManyItems_Week_Returns12_5() {
        double cost = calculator.calculateShippingCost(150, 5, DeliveryOption.WEEK);
        assertEquals(12.5, cost, 0.01);
    }

}
