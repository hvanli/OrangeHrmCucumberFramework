@login
Feature: Login

  @smoke
  Scenario: Valid login validation
    Given I enter valid username
    And I enter valid password
    When I click login button
    Then I succussfully login Orange HRM

  @regression
  Scenario Outline: Invalid login error message validation
    Given I enter username "<username>" and password "<password>"
    When I click login button
    Then I see "<errorMsg>"

    Examples: 
      | username | password  | errorMsg                 |
      | Admin    | Qwerty123 | Invalid credentials      |
      | Admin    |           | Password cannot be empty |
      | Admin123 | QWer123   | Invalid credentials      |
      |          | admin123  | Username cannot be empty |
      |          |           | Username cannot be empty |
      
      
#Scenario: Negative Login Error Message Validation
#When I enter username and password I see error message
      #| username | password  | errorMsg                 |
      #| Admin    | Qwerty123 | Invalid credentials      |
      #| Admin    |           | Password cannot be empty |
      #| Admin123 | QWer123   | Invalid credentials      |
      #|          | admin123  | Username cannot be empty |
      #|          |           | Username cannot be empty |
      
      # List<Map<String, String>> maps=dataTable.asMaps();
      
      #| username | password  | errorMsg                 |
      #| Admin    | Qwerty123 | Invalid credentials      |
      
      # Map<String, String> map=dataTable.asMap();
      
      
      
       #| Admin    | Qwerty123 | Invalid credentials      |
       
      # List<String> list=dataTable.asList();
      
      
      #Scenario: Negative Login Error Message Validation without header
#When I enter username and password I see error message without header
      #| Admin    | Qwerty123 | Invalid credentials      |
      #| Admin    |           | Password cannot be empty |
      #| Admin123 | QWer123   | Invalid credentials      |
      #|          | admin123  | Username cannot be empty |
      #|          |           | Username cannot be empty |
      #
      # List<List<String>> lists=dataTable.asLists();
      
      