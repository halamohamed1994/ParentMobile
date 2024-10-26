Feature: CreateEvent

  Scenario: Create new event
    Given ParentAps app is launched successfully
    And login with user credentials username "democompany@parent.eu" and password "P@rent12345678"
    When Select event from list of events
    And Click on calendar icon and click on create event
    Then Fill all required fields
