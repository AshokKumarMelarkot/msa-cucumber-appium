Feature: Sample test for Appium


  @tagThis
  Scenario Outline: Filling the registration form and submitting

    Given  Login to application
    When   Fill the registration form with details name <name>, email <email>, password <password>, userID <userID>, language <preferedProgrammingLanguage> and <acceptAdds>
    Examples:
      | name  | email | password | userID  |preferedProgrammingLanguage|acceptAdds|
      | Ashok | MS    | H@lo2017 | Mr. Ashok |Java                     |true      |

  @ignore
  Scenario Outline: Asserting the registration form with given values

    Given  Login to application
    When   Fill the registration form with details name <name>, email <email>, password <password>, userID <userID>, language <preferedProgrammingLanguage> and <acceptAdds>
    Examples:
      | name  | email | password | userID  |preferedProgrammingLanguage|acceptAdds|
      | Ashok | MS    | H@lo2017 | Mr. Ashok |Java                     |true      |
