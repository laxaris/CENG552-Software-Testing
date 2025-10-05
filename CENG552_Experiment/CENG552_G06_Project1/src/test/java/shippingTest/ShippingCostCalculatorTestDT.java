package shippingTest;

import org.junit.*;

import shipping.DeliveryOption;
import shipping.ShippingCostCalculator;

import static org.junit.Assert.*;

public class ShippingCostCalculatorTestDT {
    private ShippingCostCalculator calculator;

    @Before
    public void setUp() {
        calculator = new ShippingCostCalculator();
    }

    // Valid Test Cases (Rules 1-12)
    @Test
    public void rule1_givenLowPurchaseLowItemsNextDay_thenReturns25() {
        double result = calculator.calculateShippingCost(50.0, 3, DeliveryOption.NEXT_DAY);
        assertEquals(25.0, result, 0.01);
    }

    @Test
    public void rule2_givenLowPurchaseLowItemsSecondDay_thenReturns10() {
        double result = calculator.calculateShippingCost(80.0, 2, DeliveryOption.SECOND_DAY);
        assertEquals(10.0, result, 0.01);
    }

    @Test
    public void rule3_givenLowPurchaseLowItemsWeek_thenReturnsItemsTimes1Point5() {
        double result = calculator.calculateShippingCost(90.0, 2, DeliveryOption.WEEK);
        assertEquals(3.0, result, 0.01);
    }

    @Test
    public void rule4_givenLowPurchaseHighItemsNextDay_thenReturnsItemsTimes6() {
        double result = calculator.calculateShippingCost(75.0, 4, DeliveryOption.NEXT_DAY);
        assertEquals(24.0, result, 0.01);
    }

    @Test
    public void rule5_givenLowPurchaseHighItemsSecondDay_thenReturnsItemsTimes2Point5() {
        double result = calculator.calculateShippingCost(60.0, 5, DeliveryOption.SECOND_DAY);
        assertEquals(12.5, result, 0.01);
    }

    @Test
    public void rule6_givenLowPurchaseHighItemsWeek_thenReturnsZero() {
        double result = calculator.calculateShippingCost(50.0, 7, DeliveryOption.WEEK);
        assertEquals(0.0, result, 0.01);
    }

    @Test
    public void rule7_givenHighPurchaseLowItemsNextDay_thenReturns35() {
        double result = calculator.calculateShippingCost(150.0, 2, DeliveryOption.NEXT_DAY);
        assertEquals(35.0, result, 0.01);
    }

    @Test
    public void rule8_givenHighPurchaseLowItemsSecondDay_thenReturns15() {
        double result = calculator.calculateShippingCost(120.0, 3, DeliveryOption.SECOND_DAY);
        assertEquals(15.0, result, 0.01);
    }

    @Test
    public void rule9_givenHighPurchaseLowItemsWeek_thenReturns10() {
        double result = calculator.calculateShippingCost(200.0, 1, DeliveryOption.WEEK);
        assertEquals(10.0, result, 0.01);
    }

    @Test
    public void rule10_givenHighPurchaseHighItemsNextDay_thenReturnsItemsTimes7Point5() {
        double result = calculator.calculateShippingCost(150.0, 5, DeliveryOption.NEXT_DAY);
        assertEquals(37.5, result, 0.01);
    }

    @Test
    public void rule11_givenHighPurchaseHighItemsSecondDay_thenReturnsItemsTimes3Point5() {
        double result = calculator.calculateShippingCost(200.0, 6, DeliveryOption.SECOND_DAY);
        assertEquals(21.0, result, 0.01);
    }

    @Test
    public void rule12_givenHighPurchaseHighItemsWeek_thenReturnsItemsTimes2Point5() {
        double result = calculator.calculateShippingCost(110.0, 8, DeliveryOption.WEEK);
        assertEquals(20.0, result, 0.01);
    }



    // Invalid Test Cases (Rules 13-15)
    @Test(expected = IllegalArgumentException.class)
    public void rule13_givenNegativePurchaseAmount_thenThrowsException() {
        calculator.calculateShippingCost(-50.0, 2, DeliveryOption.NEXT_DAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rule14_givenZeroNumItems_thenThrowsException() {
        calculator.calculateShippingCost(100.0, 0, DeliveryOption.SECOND_DAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rule15_givenNullDeliveryOption_thenThrowsException() {
        calculator.calculateShippingCost(150.0, 1, null);
    }
}
