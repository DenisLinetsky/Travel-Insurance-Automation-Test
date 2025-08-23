Travel Insurance Automation Test

This project automates the flow for purchasing travel insurance abroad on Harel Group's website, using Java, Selenium WebDriver, TestNG, and Gradle.

Tech Stack

Java 17

Selenium WebDriver 4.20.0

TestNG 7.9.0

Gradle 9.0.0

WebDriverManager 5.6.3

The automated test covers the following steps:

1. Open the URL in the Chrome browser

2. Click the "First time purchase" button

3. Choose one of the continents

4. Click the "Continue to select travel dates" button.

5. Select a departure date within seven days of today (selection varies depending on the current date)

Return date 30 days from departure date (use datePicker)

6. Make sure total days are displayed correctly

7. Click the "Proceed to passenger details" button.

8. Make sure the page opens.

Run Tests via Gradle

./gradlew test

View Test Report

build/reports/tests/test/index.html
