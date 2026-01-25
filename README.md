# Buggy Cars Rating - Selenium Automation Testing Framework

A comprehensive Java-based Selenium automation testing framework for the Buggy Cars Rating application using TestNG and Maven.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [Project Features](#project-features)

## Prerequisites

Before you begin, ensure you have the following installed on your system:

- **Java Development Kit (JDK)**: Version 8 or higher

  - Download from: https://www.oracle.com/java/technologies/downloads/
  - Set `JAVA_HOME` environment variable
  - Verify: `java -version`
- **Maven**: Version 3.6.0 or higher

  - Download from: https://maven.apache.org/download.cgi
  - Set `MAVEN_HOME` environment variable
  - Verify: `mvn -version`
- **Git** (optional, for cloning the repository)

  - Download from: https://git-scm.com/

## Project Structure

```
buggy_cars_rating/
├── src/
│   ├── main/
│   │   └── java/          # Main application code
│   └── test/
│       ├── java/          # Test classes
│       │   ├── PageObject/        # Page Object Model classes
│       │   ├── TestBase/          # Base test classes and utilities
│       │   ├── TestCase/          # Test case implementations
│       │   └── Utilities/         # Utility classes
│       └── resources/
│           ├── config.properties  # Configuration file
│           └── log4j2.xml        # Logging configuration
├── pom.xml                # Maven configuration
├── master.xml             # TestNG suite configuration
├── run.bat                # Batch script to run tests
├── docker-compose.yaml    # Docker configuration (optional)
├── reports/               # Generated test reports
├── screenshots/           # Screenshot artifacts
├── logs/                  # Application logs
└── testData/              # Test data files
```

## Installation

### 1. Clone the Repository

```bash
git clone <repository-url>
cd buggy_cars_rating
```

### 2. Install Dependencies

Maven will automatically download all required dependencies from `pom.xml`:

```bash
mvn clean install
```

This will download and install:

- **Selenium WebDriver** (v4.39.0) - Web automation library
- **TestNG** (v7.11.0) - Testing framework
- **WebDriverManager** (v5.9.1) - Automatic driver management
- **Apache POI** (v5.5.0) - Excel file handling
- **Log4j2** - Logging framework
- **ExtentReports** (v5.1.2) - Test reporting
- **Apache Commons** - Utility libraries

## Configuration

### 1. Update Configuration File

Edit `src/test/resources/config.properties`:

```properties
# Execution environment: 'local' or 'remote'
execution_env=local

# Application URL
baseURL=https://buggy.justtestit.org/

# Test credentials
username=testuser01@mail.com
password=Testuser@123
```

**Key configuration parameters:**

- `execution_env`: Set to `local` for local testing or `remote` for remote Selenium grid
- `baseURL`: The URL of the application to test
- `username`: Valid test user email
- `password`: Corresponding password

### 2. Update TestNG Suite Configuration (Optional)

Edit `master.xml` to customize which tests to run:

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="Your Suite Name">
    <test name="Your Test">
        <classes>
            <class name="TestCase.TC001_AccountRegistrationTest"/>
            <class name="TestCase.TC002_LoginTest"/>
            <!-- Add your test classes here -->
        </classes>
    </test>
</suite>
```

## Running Tests

### Option 1: Run via Maven Command Line

**Run all tests:**

```bash
mvn test
```

**Run a specific test class:**

```bash
mvn test -Dtest=TC001_AccountRegistrationTest
```

**Run with specific suite:**

```bash
mvn test -Dsuites=master.xml
```

### Option 2: Run via Batch Script (Windows)

```bash
run.bat
```

The batch script automatically navigates to the project directory and executes `mvn test`.

### Option 3: Run from IDE

- **IntelliJ IDEA**: Right-click on the test class or suite → Run
- **Eclipse**: Right-click on the test class → Run As → TestNG Test
- **VS Code**: Use TestNG Runner extension

## Test Reports

### Test Report Locations

- **HTML Reports**: `/reports/Test_Report_<timestamp>.html`
- **TestNG Reports**: `/test-output/`
- **Extent Reports**: Available in the report files

### View Latest Report

Navigate to the `reports/` directory and open the most recent HTML report in your web browser.

### Sample Report Files:

- `reports/Test_Report_2026.01.25.20.56.56.html` (Latest)

## Project Features

### Page Object Model (POM)

- Well-organized page classes in `src/test/java/PageObject/`
- Separation of locators and actions
- Improved maintainability and reusability

### Test Data Driven

- Excel file support via Apache POI
- Test data stored in `testData/` directory
- Dynamic test execution with multiple data sets

### Logging

- Log4j2 configuration in `src/test/resources/log4j2.xml`
- Comprehensive logging for debugging
- Log files stored in `logs/` directory

### Screenshots & Artifacts

- Automatic screenshot capture on test failures
- Screenshots stored in `screenshots/` directory
- Included in test reports

### Docker Support

- Optional Docker containerization via `docker-compose.yaml`
- Useful for running in CI/CD pipelines
- Supports Selenium Grid setup via `grid_docker.xml`

## Supported Test Classes

The project includes the following test cases (in `src/test/java/TestCase/`):

- `TC001_AccountRegistrationTest` - User registration tests
- `TC002_LoginTest` - Login functionality tests
- `TC003_LoginTestDDT` - Data-driven login tests
- Additional test cases as per `master.xml` configuration

## Troubleshooting

### Common Issues

**1. Build fails with "Maven not found"**

- Ensure Maven is installed and added to PATH
- Verify with: `mvn -version`

**2. Tests fail with "Chrome driver not found"**

- WebDriverManager handles this automatically
- Ensure internet connection for driver download
- Or manually place ChromeDriver in system PATH

**3. Connection timeout to application**

- Verify `baseURL` in `config.properties` is correct
- Check internet connection
- Ensure the application is accessible

**4. Tests fail with authentication errors**

- Verify username and password in `config.properties`
- Check if test account is still active
- Check application credentials validity

### Clean Build

If you encounter issues, perform a clean build:

```bash
mvn clean install
mvn test
```

## Integration with CI/CD

This project can be integrated into CI/CD pipelines (Jenkins, GitHub Actions, Azure DevOps):

```bash
# Standard Maven command for CI/CD
mvn clean test
```

For Docker-based execution:

```bash
docker-compose -f docker-compose.yaml up
```

## Dependencies

| Dependency         | Version | Purpose            |
| ------------------ | ------- | ------------------ |
| Selenium WebDriver | 4.39.0  | Browser automation |
| TestNG             | 7.11.0  | Test framework     |
| WebDriverManager   | 5.9.1   | Driver management  |
| Apache POI         | 5.5.0   | Excel handling     |
| Log4j2             | 2.25.2  | Logging            |
| ExtentReports      | 5.1.2   | Test reporting     |
| Commons IO         | 2.21.0  | File utilities     |
| Commons Lang3      | 3.20.0  | String utilities   |

## Best Practices

1. **Always use Page Object Model** - Keep locators and actions in page classes
2. **Use proper waits** - Avoid Thread.sleep() in favor of explicit waits
3. **Take screenshots** - Capture on failures for debugging
4. **Use descriptive names** - Make test cases self-documenting
5. **Maintain test data** - Keep test data in separate files
6. **Run in headless mode** - For faster CI/CD pipeline execution (if supported)
7. **Review logs** - Check application logs for detailed error information

## Contact & Support

For issues or questions regarding this automation framework, please refer to the test reports and logs in:

- Reports: `/reports/`
- Logs: `/logs/`
- Test Output: `/test-output/`

---

**Last Updated**: January 2026
**Framework Version**: 0.0.1-SNAPSHOT
**Tested On**: Windows OS
