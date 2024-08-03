# FitPeo Automation

## Overview

This project automates the navigation and interaction with the FitPeo website's Revenue Calculator page using Selenium WebDriver and Java.

## Prerequisites

- Java Development Kit (JDK)
- Maven
- Chrome Browser
- ChromeDriver

## Setup

1. **Clone the repository**:
    ```bash
    git clone <repository-url>
    cd FitPeoAutomation
    ```

2. **Install dependencies**:
    ```bash
    mvn clean install
    ```

3. **Update the ChromeDriver path**:
    - Ensure `chromedriver` executable is in your system path or update the path in the code.

## Running the Automation Script

1. **Compile the script**:
    ```bash
    mvn compile
    ```

2. **Execute the script**:
    ```bash
    mvn exec:java -Dexec.mainClass="FitPeoAutomation"
    ```

## Project Structure

- `src/main/java/FitPeoAutomation.java`: Main automation script.
- `pom.xml`: Maven configuration file.
- `README.md`: Project documentation.
- `.gitignore`: Git ignore file.

## Author

[Srinidhi k]