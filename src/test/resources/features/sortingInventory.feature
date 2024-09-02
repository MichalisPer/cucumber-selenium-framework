Feature: Sorting Inventory
  Validating the different sorting options

  Scenario Outline: Sort products by price
    Given "standard_user" is on the home page
    When they select to sort products by price in <order> order
    Then the products are sorted by price in <order> order
    Examples:
      | order      |  |
      | descending |  |
      | ascending  |  |
