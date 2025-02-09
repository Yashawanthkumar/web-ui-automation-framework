# 🚀 Selenium Test Automation Framework

This is a robust **Selenium Web Automation Framework** built using **Java, TestNG, and WebDriver**. It follows the **Page Object Model (POM)** and supports **data-driven testing, parallel execution, logging, and environment-based execution**.

---
## 🎯 Features

✅ Page Object Model (POM)
Organized and reusable Page Classes.
✅ Data-Driven Testing
Fetches test data from JSON, Excel, SQL Database.
✅ Parallel Execution
Supports parallel execution via TestNG & Maven.
✅ Docker Support
Runs tests in Selenium Grid.
✅ Logging & Reports
Integrated Log4j & Allure for reporting.

## 🔧 **Installation & Setup**

### 1️⃣ Clone the Repository
```git clone https://github.com/YOUR_GITHUB_USERNAME/selenium-framework.git```
```cd selenium-framework```

### 2️⃣ Build the Project
Run the following command to build the project:
```mvn clean install```
This will download dependencies and compile the framework.

## 🚀 Executing Test Cases

You can execute test cases in different environments.

✅ Run Tests Locally
```mvn test -Denv=local```

✅ Run Tests in Docker (Selenium Grid)
```mvn test -Denv=docker```

✅ Run a Specific Test Suite
```mvn test -DsuiteXmlFile=testng.xml```

✅ Run Parallel Execution
Modify testng.xml to enable parallel execution:
```<suite name="Selenium Tests" parallel="methods" thread-count="3">
    <test name="Login Tests">
        <classes>
            <class name="com.automation.tests.LoginTest"/>
        </classes>
    </test>
</suite>```

📌 Logging & Reporting

✅ Log4j Logging
-All test actions are logged using Log4j.
-Log levels: INFO, DEBUG, ERROR.
-Log files are stored in logs/automation.log.

📸 Screenshots on Failure

ScreenshotUtil.java captures failures automatically.
Screenshots are stored in screenshots/ directory.

👥 Contributors
Yashawanthkumar : https://www.linkedin.com/in/yashawanthkumar-hodlur/
