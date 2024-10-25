Feature: View event details

  Scenario: Open event details
    Given ParentAps app is launched
    And login with user credentials username "democompany@parent.eu" , password "P@rent12345678"
    When Open event from list of events
    Then Check the details of event is returned successfully