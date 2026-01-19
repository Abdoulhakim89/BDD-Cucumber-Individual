Feature: Add product to cart from the Product Details Page

  Scenario: Customer adds one quantity of the product to cart
    Given customer is on the "Anchor Bracelet" details page
    When customer adds 1 "Anchor Bracelet" to cart
    Then customer should see 1 "Anchor Bracelet" to cart

