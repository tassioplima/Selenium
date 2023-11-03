# Automation Project Selenium

Automation project with Java + Gradle and GitHub Action (CI) doing the remote web test, GithubPages to deploy Allure
Serve to see test results, PageObject and PageFactory structure.

![GitHub Workflow Status (with event)](https://img.shields.io/github/actions/workflow/status/tassioplima/Selenium/gradle.yml)(https://github.com/tassioplima/Selenium/actions)
[![Allure Report](https://img.shields.io/badge/Allure%20Report-deployed-yellowgreen)](https://tassioplima.github.io/Selenium/)

Configuration:

- Java JDK +11

Running test:

``` bash
./gradlew test --tests "MercedesTest"
```

Running with different web drivers:

``` bash
./gradlew test --tests "MercedesTest" -DBROWSER=chrome
```

``` bash
./gradlew test --tests "MercedesTest" -DBROWSER=firefox
```

Running headless:

``` bash
./gradlew test --tests "MercedesTest" -DBROWSER=headless
```

### Building Allure report

To build a report, and browse it use the following command:

``` bash

./gradlew allureServe
```

