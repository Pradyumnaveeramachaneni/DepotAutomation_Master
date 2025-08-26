# DepotAutomation_Master
Project Overview

This is a data-driven automation testing framework built using Java, Selenium WebDriver, TestNG, and Maven. It follows the Page Object Model (POM) design pattern to make the framework modular, maintainable, and scalable.
The framework supports multiple environments (QA, DEV, PROD) using properties files and provides detailed test execution reports using Extent Reports.

🛠 Features

✔ Page Object Model (POM) for better maintainability
✔ Environment-Specific Configurations (QA, DEV, PROD)
✔ Maven for build management and dependency handling
✔ TestNG for test execution and parallel execution support
✔ Extent Reports for detailed HTML reports with screenshots on failure
✔ Screenshot Utility for capturing failures
✔ Config Reader Utility for fetching test data and configurations
✔ Reusable Base Classes for WebDriver initialization and teardown
✔ Listener Implementation for reporting and logging
✔ Supports Cross-Browser Testing (Chrome, Firefox, Edge)
✔ Easy to integrate with CI/CD pipelines (Jenkins, GitHub Actions)

🏗 Framework Architecture
SeleniumAutomation_POM_with_env_and_maven/
│
├── src/main/java/
│   ├── base/
│   │   ├── BasePage.java        # Common methods for all pages
│   │   ├── DriverFactory.java   # WebDriver initialization logic
│   │
│   ├── listeners/
│   │   ├── ExtentListener.java  # TestNG Listener for reporting
│   │
│   ├── pages/
│   │   ├── LoginPage.java       # Page Object for Login Page
│   │
│   ├── utils/
│       ├── ConfigReader.java    # Reads environment-specific properties
│       ├── ExtentManager.java   # Creates Extent report instance
│       ├── ScreenshotUtil.java  # Captures screenshots on failure
│
├── src/main/resources/
│   ├── config.properties        # Default environment config
│
├── src/test/java/
│   ├── base/
│   │   ├── BaseTest.java        # Common setup & teardown for tests
│   │
│   ├── tests/
│       ├── LoginTest.java       # Test case for login functionality
│
├── src/test/resources/
│   ├── config-qa.properties     # QA environment config
│   ├── config-dev.properties    # DEV environment config
│   ├── config-prod.properties   # PROD environment config
│
├── pom.xml                      # Maven dependencies and plugins
└── testng.xml                   # TestNG suite configuration

⚙ Tools & Technologies

Programming Language: Java

Automation Tool: Selenium WebDriver

Test Framework: TestNG

Build Tool: Maven

Reporting: Extent Reports

Design Pattern: Page Object Model (POM)

Property Management: Java Properties files

Version Control: GitHub

CI/CD: Jenkins / GitHub Actions (optional)

▶ How to Run the Tests

Clone the Repository

git clone https://github.com/your-username/SeleniumAutomation_POM.git


Navigate to Project Directory

cd SeleniumAutomation_POM


Run Tests Using Maven

mvn clean test


View Test Reports

Navigate to test-output/ folder → Open ExtentReports.html in browser

🖼 Reports & Screenshots

Extent HTML Reports generated after every execution

Screenshots captured automatically for failed test cases

✅ Future Enhancements

Add Docker + Selenium Grid for parallel execution

Implement Cucumber (BDD) for Gherkin-based test scenarios

Integrate with Jenkins CI/CD pipeline

Add API Testing (RestAssured)
