@All @AddToCart_ProductDetails
Feature: Add product to cart from the Product Details Page

  Scenario Outline: Customer can add any quantity of the product to cart
    Given the customer is on the Store page
    And the customer navigates to <product> details page
    When customer adds <qty> <product> to cart
    Then customer should see <qty> <product> to cart
    Examples:
      | product            | qty |
      | "Anchor Bracelet"  | 1   |
      | "Basic Blue Jeans" | 4   |

