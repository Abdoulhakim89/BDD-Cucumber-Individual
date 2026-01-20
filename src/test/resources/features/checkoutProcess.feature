@All @CheckoutProcess
Feature: Place order
  As a guest customer,
  I want to place an order
  So that I can finish the shopping process

  @checkoutProcess
  Scenario: Guest user places order using valid billing details
    Given the customer has more than one product in the cart
    And the guest customer is on the checkout page
    And the customer's billing details are
      | firstname | lastname | country | street_address | town    | state  | zip   | email                |
      | John      | Doe      | Rwanda  | KK 509 st      | Kigali  | Rwanda | 00000 | john.doe@gmail.com   |
    When the customer completes the billing details stage
    Then the order should be placed successfully
