Feature: Search

  Scenario: Search only by Title
    Given I set title=Titanic
    When Send GET http request for movie
    Then I receive valid response with movie id=tt0120338

  Scenario: Search only by Title and set response type xml
    Given I set title=Titanic and format=xml
    When Send GET http request for movie
    Then I receive valid response with movie id=tt0120338

  Scenario: Search only by Title with error
    Given I set title=Titanicdfgfgfghfdh
    When Send GET http request for movie
    Then I receive error response

  Scenario: Search only by Title and year
    Given I set title=Titanic and year=2000
    When Send GET http request for movie
    Then I receive valid response with movie id=tt0330994

  Scenario: Search only by Title and year with error
    Given I set title=Titanic and year=0000
    When Send GET http request for movie
    Then  I receive error response

  Scenario: Search only by Title and set response type xml with error
    Given I set title=Titanicdfgfgfghfdh and format=xml
    When Send GET http request for movie
    Then I receive error response

  Scenario: Search only by Title and plot
    Given I set title=Avatar and plot=full
    When Send GET http request for movie
    Then I receive valid response with movie id=tt0499549 and plot type=full

  Scenario: Search only by Title, plot and year
    Given I set title=Titanic and plot=short and year=1997
    When Send GET http request for movie
    Then I receive valid response with movie id=tt0120338 and plot type=short

  Scenario: Search only by Title and plot type and year and response format json
    Given I set title=Titanic and plot=full and year=1997 and format=json
    When Send GET http request for movie
    Then I receive valid response with movie id=tt0120338 and plot type=full

  Scenario: Search only by Title with error and plot type and year and response format json
    Given I set title=Titanic12346546 and plot=full and year=1997 and format=json
    When Send GET http request for movie
    Then I receive error response

  Scenario: Search only by Title and plot type and response format xml
    Given I set title=Avatar and plot=short and format=xml
    When Send GET http request for movie
    Then I receive valid response with movie id=tt0499549 and plot type=short


  Scenario: Search only by Title with error and plot type and response format xml
    Given I set title=Avatarrrrrrrrrrrrrrrr and plot=full and format=xml
    When Send GET http request for movie
    Then I receive error response

  Scenario: Search only by Title and year type and response format json
    Given I set title=Titanic and year=1997 and format=json
    When Send GET http request for movie
    Then I receive valid response with movie id=tt0120338

