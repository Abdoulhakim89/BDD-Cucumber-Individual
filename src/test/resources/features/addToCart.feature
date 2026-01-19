Feature: Add to cart
@AddToCart
#  Background: Customer is on the store page

  Scenario:Customer adds one quantity from the store page
    Given the customer is on the Store page
    When the customer adds "Basic Blue Jeans"
    Then the customer should see 1 "Basic Blue Jeans" in the cart
