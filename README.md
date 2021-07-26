# Test Task(Java)
Requirements:
Java, TestNG automation framework. Chrome Driver (put it in the project + all other files). Do not use any absolute path. Use Page Object pattern. Maven.
Archive the result or post to GitHub and send the link to the contact person.
## Task 1:
URL: https://www.redmine.org/account/register
Validate all links on the page.
One @Test method for each link.
Test method steps: click on the link, check the result, go back.
## Task 2:
URL: https://www.redmine.org/account/register
Independent simple check of all input fields.
One @Test method for each input.
Test method steps: enter the value, check error message, save screenshot.
Optional: Extract input fields values from one excel file and save results to another excel file/sheet
(input name=result(pass/fail))
## Task 3:
URL: https://www.redmine.org/account/register
Validate all inputs at once
Expected behavior: You have one @Test method. In this method you need to set all input fields one by one. One input value should be invalid. Click submit, check error message and save screenshot
Use @DataProvider annotation to share data into that method. Try to register at least three people.
Optional: Create/Use existing excel file with some rows (Example: row1:name1, email1…; row2:name 2, email2…). One value in the row should be invalid. Extract this data from excel to @DataProvider.
