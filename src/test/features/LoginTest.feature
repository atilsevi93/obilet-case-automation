Feature: Login Test

  Scenario: Creating and verifying the account creation a new user account on obilet.com
    Given navigate to homepage
    Then control "Ucuz Otobüs Bileti Fiyatları, Otobüs Bileti Al - obilet.com" home page title
    When click on the login button
    Then verify registration pop-up is displayed
    And click the sign-up button
    And fill in random email and random password fields and click the sign-up button
    Then verify new user successfully created