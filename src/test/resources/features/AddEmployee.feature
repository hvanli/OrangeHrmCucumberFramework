@addAmployee
Feature: Add Employee

  @smoke
  Scenario: Add Multiple Employee with Excel file
    Given I logged in Orange HRM
    When I navigated to Add Employee page
    Then I enter employee information from excel file and save employee successfully
