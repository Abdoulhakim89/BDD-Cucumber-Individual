@All @AddToCart
Feature: Add to cart
  As a customer
  I want to add a product to the cart from the store page
  So that I can shop different items of different quantities

Background:
  Given the customer is on the Store page

  @AddFromStorePage
  Rule: Add from Store Page

  @AddOne
  Scenario:Customer adds one quantity from the store page
    When the customer adds "Basic Blue Jeans" to the cart
    Then the customer should see 1 "Basic Blue Jeans" in the cart

#  @AddOneMoreTimes
#  Scenario: Customer adds 3 quantity of the same product
#    When the customer adds 3 "Dark Brown Jeans" to the cart
#    Then the customer should see 3 "Dark Brown Jeans" in the cart

  @AddMoreThanOneProduct
  Scenario Outline: Customer adds 4 different products to the cart
    When the customer adds <product> to the cart
    Then the customer should see 1 <product> in the cart

    Examples:
      | product            |
      | "Anchor Bracelet"  |
      | "Blue Shoes"       |
      | "Blue Tshirt"      |
      | "Basic Blue Jeans" |

