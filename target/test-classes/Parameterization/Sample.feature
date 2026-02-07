Feature: This feature explains cucumber parameterization

  Scenario:
Passing simple paramter to a step

    Given I have 15 and 16
    When I add them
    Then print the result

  Scenario:
Passing string as argument

    Given I have "apple and banana"
    Then print the fruit name

  Scenario:
	Passing list of fruits as arguments

    Given I have following fruits:
      | apple      |
      | banana     |
      | guava      |
      | kiwi       |
      | strawberry |
      | mango      |
      | orange     |
    Then display the list

  Scenario:
Passing table to the step

    Given I have following fruit data:
      | apple      | 10 | green  |
      | banana     | 6  | red    |
      | strawberry | 20 | red    |
      | pineapple  | 1  | yellow |
      | mango      | 12 | yellow |
    Then print the fruit data

  Scenario:
Passing data table from excel

    Given I have following fruite data from excel
    Then print the fruit data

  Scenario Outline:
    Given I have "<fruit>" and its <quantity>
    Then print single fruit info

    Examples:
      | fruit      | quantity |
      | apple      | 10       |
      | banana     | 20       |
      | strawberry | 12       |

  Scenario Outline:
Accept data from excel sheet

    Given Read data from row <rownum> from excel
    Then print single fruit info

    Examples:
      | rownum |
      | 1      |
      | 2      |
      | 3      |
      | 4      |
      | 5      |
      | 6	   |
