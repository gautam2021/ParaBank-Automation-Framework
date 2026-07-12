# 🚀 ParaBank Automation Framework

<!-- Replace the badge below with your own GitHub Actions badge -->
<!-- [![Selenium Test Automation](https://github.com/gautam2021/ParaBank-Automation-Framework/actions/workflows/selenium.yml/badge.svg)](https://github.com/gautam2021/ParaBank-Automation-Framework/actions/workflows/selenium.yml) -->

## 📖 Overview

This project is a robust Selenium Test Automation Framework developed using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**. The framework follows the **Page Object Model (POM)** design pattern and is built with scalability, maintainability, and CI/CD integration in mind.

The framework supports parallel execution, centralized logging, automatic screenshot capture on failures, Extent Reports, and GitHub Actions for Continuous Integration.

---

## 🛠️ Tech Stack

- Java 17
- Selenium WebDriver 4
- TestNG
- Maven
- Log4j2
- Extent Reports
- Git
- GitHub
- GitHub Actions
- WebDriverManager

---

## ✨ Features

- ✅ Page Object Model (POM)
- ✅ ThreadLocal WebDriver Management
- ✅ Browser Factory Design Pattern
- ✅ Parallel Test Execution
- ✅ TestNG DataProvider Support
- ✅ Centralized Logging using Log4j2
- ✅ TestNG Listeners
- ✅ Automatic Screenshot Capture on Test Failure
- ✅ Extent Report Generation
- ✅ Headless Chrome Execution for CI
- ✅ GitHub Actions CI/CD Integration
- ✅ Maven Dependency Caching
- ✅ Upload Test Reports as GitHub Artifacts

---

## 📂 Project Structure

```
ParaBank-Automation
│
├── .github
│   └── workflows
│       └── selenium.yml
│
├── resources
│   ├── config.properties
│   └── log4j2.xml
│
├── report
│
├── screenshots
│
├── logs
│
├── src
│   ├── main
│   │   ├── factory
│   │   ├── listeners
│   │   ├── pages
│   │   └── utility
│   │
│   └── test
│       └── tests
│
├── testng.xml
├── pom.xml
└── README.md
```

---

## ▶️ Running the Tests

### Clone the Repository

```bash
git clone https://github.com/gautam2021/ParaBank-Automation-Framework.git
```

### Navigate to the Project

```bash
cd ParaBank-Automation-Framework
```

### Run the Tests

```bash
mvn clean test
```

---

## 📊 Reports

After execution, the framework automatically generates:

### Extent Report

```
report/
    extentReport.html
```

### Logs

```
logs/
    ParaBank.log
```

### Screenshots (On Failure)

```
screenshots/
```

---

## ⚙️ GitHub Actions CI

This project is integrated with **GitHub Actions**.

Every push to the configured branches automatically:

- Checks out the repository
- Sets up Java 17
- Restores Maven Cache
- Builds the project
- Executes Selenium Tests
- Runs Chrome in Headless Mode
- Generates Extent Reports
- Uploads Reports, Logs and Screenshots as Artifacts

---

## 🌐 Supported Browser

- Google Chrome

*(Firefox and Edge support can be added easily using the Browser Factory.)*

---

## 📸 Framework Highlights

- Thread-safe WebDriver implementation
- Reusable Page Object Model
- Clean utility classes
- Centralized browser management
- Centralized logging
- Automatic screenshot capture
- Professional HTML reporting
- CI/CD Ready

---

## 🚀 Future Enhancements

- Jenkins Pipeline
- Docker Support
- Selenium Grid
- Cross Browser Matrix Execution
- Allure Reports
- Email Notifications
- Slack Notifications
- Azure DevOps Pipeline
- API Automation Integration
- Performance Testing Integration

---

## 👨‍💻 Author

**Gautam**

GitHub: https://github.com/gautam2021

---

## ⭐ If you like this project

If you found this framework useful, consider giving the repository a ⭐ on GitHub.