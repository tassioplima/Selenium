# Automation Project Selenium

Automation project with Java + Gradle and GitHub Action (CI) doing the remote web test, GithubPages to deploy Allure Serve to see test results, PageObject and PageFactory structure.

[![Web Execution](https://github.com/tassioplima/Selenium/workflows/CI/badge.svg)](https://github.com/tassioplima/Selenium/actions)
[![Allure Report](https://img.shields.io/badge/Allure%20Report-deployed-yellowgreen)](https://tassioplima.github.io/Selenium/)

Configuration:

- Java JDK 11

Running test:

``` sh
./gradlew test --tests "mercedesTest"
```

Running woth diffent web drivers:

``` sh
./gradlew test --tests "mercedesTest" -Dbrowser=chrome
```

### Building Allure report

To build a report, and browse it use the following command:

``` sh
./gradlew allureServe
```

Github Pages with Allure report results: [ALLURE](https://tassioplima.github.io/Selenium/)

