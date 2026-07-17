# 🚀 ParaBank Automation Framework

> A robust Selenium UI Automation Framework built using Java, Selenium WebDriver, TestNG, and Maven following the Page Object Model (POM) design pattern.

<!-- Replace the badge below with your own GitHub Actions badge -->
<!-- [![Selenium Test Automation](https://github.com/<your-github-username>/<repo-name>/actions/workflows/selenium.yml/badge.svg)](https://github.com/<your-github-username>/<repo-name>/actions/workflows/selenium.yml) -->

---

## 📖 Overview

This project is an end-to-end UI automation framework developed for the **ParaBank Demo Banking Application**.

The framework is designed with scalability, maintainability, and reusability in mind by implementing industry-standard automation practices such as:

- Page Object Model (POM)
- Thread-safe WebDriver management
- TestNG Listeners
- Extent Reporting
- Log4j2 Logging
- GitHub Actions CI/CD
- Parallel Test Execution

---

# 🏦 Automated Banking Features

The following banking workflows have been automated:

- ✅ User Registration
- ✅ User Login
- ✅ Account Overview
- ✅ Open Savings Account
- ✅ Open Checking Account
- ✅ Transfer Funds Between Accounts

---

# 🛠️ Tech Stack

- Java 17
- Selenium WebDriver 4
- TestNG
- Maven
- Log4j2
- Extent Reports
- WebDriverManager
- Git
- GitHub
- GitHub Actions

---

# ✨ Framework Features

- ✅ Page Object Model (POM)
- ✅ ThreadLocal WebDriver Management
- ✅ Browser Factory Design Pattern
- ✅ Parallel Test Execution
- ✅ TestNG DataProvider Support
- ✅ Explicit Wait Utilities
- ✅ TestNG Listeners
- ✅ Automatic Screenshot Capture on Failure
- ✅ Extent HTML Reports
- ✅ Centralized Log4j2 Logging
- ✅ Headless Chrome Execution
- ✅ GitHub Actions CI/CD Integration
- ✅ Maven Dependency Caching
- ✅ Upload Reports as GitHub Artifacts

---

# 📐 Design Patterns Used

- Page Object Model (POM)
- Factory Pattern
- Singleton Pattern (Configuration Reader)
- ThreadLocal WebDriver Pattern

---

# 🏗️ Framework Architecture

```
Tests
   │
   ▼
Page Objects
   │
   ▼
Base Page
   │
   ▼
Utility Classes
   │
   ▼
Driver Manager
   │
   ▼
WebDriver
```

---

# 📂 Project Structure

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
├── screenshots
├── logs
│
├── src
│   ├── main
│   │   ├── base
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

# 📌 Test Modules

| Module | Status |
|---------|:------:|
| User Registration | ✅ |
| Login | ✅ |
| Account Overview | ✅ |
| Open Account | ✅ |
| Transfer Funds | ✅ |

---

# ⚙️ Configuration

Update the configuration in:

```
resources/config.properties
```

Example:

```properties
browser=chrome
baseUrl=https://parabank.parasoft.com/parabank
implicitWait=10
explicitWait=20
headless=false
```

---

# ▶️ Running the Tests

### Clone Repository

```bash
git clone https://github.com/<your-github-username>/ParaBank-Automation.git
```

### Navigate

```bash
cd ParaBank-Automation
```

### Execute

```bash
mvn clean test
```

Or execute:

```
testng.xml
```

---

# 📊 Reports

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

### Screenshots

```
screenshots/
```

---

# ⚙️ GitHub Actions CI

The project is integrated with GitHub Actions.

On every push, the pipeline:

- Checks out the repository
- Sets up Java 17
- Restores Maven Cache
- Builds the project
- Executes Selenium Tests
- Runs Chrome in Headless Mode
- Generates Extent Reports
- Uploads Reports, Logs, and Screenshots as Artifacts

---

# 🌐 Supported Browser

- Google Chrome

*(Firefox and Edge support can be added easily using the Browser Factory.)*

---

# 💡 Skills Demonstrated

- Selenium WebDriver
- Java
- TestNG
- Maven
- Page Object Model
- Explicit Waits
- Parallel Execution
- Git
- GitHub
- GitHub Actions
- CI/CD
- Log4j2
- Extent Reports
- Test Automation Framework Design

---

# 🚀 Future Enhancements

- Bill Pay Automation
- Request Loan Automation
- Find Transactions Automation
- Cross Browser Execution
- Selenium Grid
- Docker Support
- API Automation using Rest Assured
- Allure Reports

---

# 📦 Current Version

**v1.0.0**

Includes:

- Registration
- Login
- Open Account
- Transfer Funds
- Reporting
- Logging
- GitHub Actions

---

# 👨‍💻 Author

**Gautam**

Automation Test Engineer | Java | Selenium | TestNG | CI/CD

GitHub: https://github.com/gautam2021

---

# ⭐ Support

If you found this project useful, consider giving the repository a ⭐ on GitHub.