Feature: Josef form

  Scenario Outline: Test case for Josef form
    Given I go to the form URL
    When I fill all the fields '<Name>','<Email>','<Age>','<Phone>'
    When I click on the submit button
    Then I should be able to submit the form successfully '<Name>','<Email>','<Age>','<Phone>'
    Examples:
      |Name|Email|Age|Phone|
      |Alfred|Afred.dyas@gmail.com|76|8765456784|
      |Alfred|Afred.dyas@gmail.com|76|+61431987010|
      |Alfred|Afred.dyas@gmail.com|76|9987678986|
      |Afred Dyas Don Bosco|Afred.dyas@gmail.com|55|8888|

  Scenario Outline: Test case for Josef form for incorrect values
    Given I go to the form URL
    When I fill the fields incorrectly with these values  '<Name>','<Email>','<Age>','<Phone>'
    When I click on the submit button
    Then I should not be able to submit the form successfully
    Examples:
      |Name|Email|Age|Phone|
      |    |     |   |     |
      ||Afred.dyas@gmail.com|55|8888|
      |A|Afred.dyas@gmail.com|55|8888|
      |9999|Afred.dyas@gmail.com|55|8888|
      |*|Afred.dyas@gmail.com|55|8888|

      |Alfred||88|8765456784|
      |Alfred|aaa|88|8765456784|
      |Alfred|99999|88|8765456784|
      |Alfred|a@:.com|88|8765456784|
      |Alfred|a@a|88|8765456784|
      |Alfred|aaaaaaaaaa@tetwetfgdf^&*^&^&(.com|88|8765456784|
      |Alfred|+++^^^|88|8765456784|

      |Alfred|Afred.dyas@gmail.com||8765456784|
      |Alfred|Afred.dyas@gmail.com|0|8765456784|
      |Alfred|Afred.dyas@gmail.com|hghg|8765456784|
      |Alfred|Afred.dyas@gmail.com|-7|8765456784|
      |Alfred|Afred.dyas@gmail.com|88888888888888|8765456784|
      |Alfred|Afred.dyas@gmail.com|;;|8765456784|

      |Alfred|Afred.dyas@gmail.com|76||
      |Alfred|Afred.dyas@gmail.com|76|aaa|
      |Alfred|Afred.dyas@gmail.com|76|:::|
      |Alfred|Afred.dyas@gmail.com|76|99999999999999999999999|