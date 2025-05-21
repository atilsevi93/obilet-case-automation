Feature: Search Flight Test


  Scenario: Searching flight tickets, verify flight list and price page
    Given navigate to homepage
    When click flight button
    Then verify the flight ticket search page is opened
    And select "İstanbul" departure and "Antalya" destination
    And select departure and return dates
    And click search button
    Then check flight results are displayed
    And select random departure flight
    Then check other classes for departure flight
    And select random return flight
    Then check other classes for return flight
    And check the payment page is opened
    And check departure and destination flights on the payment page