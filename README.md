# Personal Budget Tracker

<!-- Badges (add actual badge URLs as needed) -->
![Java](https://img.shields.io/badge/Java-21%2B-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15%2B-blue)

A modern, mobile-friendly Spring Boot application for tracking personal finances with a beautiful dark UI and PostgreSQL persistence.

---

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Screenshots](#screenshots)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Setup](#setup)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Credits](#credits)

---

## Features
- Add, view, edit, and delete expenses and income
- Edit and delete via modern modal popups for both transactions and income
- Dashboard with summary cards, analytics, and charts
- Category-wise spending breakdown with colorful gradients
- Income table with full CRUD support
- Responsive, dark-themed UI (Tailwind CSS)
- Export transactions to CSV
- Persistent storage with PostgreSQL

## Tech Stack
- **Backend:** Java 21, Spring Boot 3
- **Frontend:** Thymeleaf, Tailwind CSS, Chart.js, JavaScript
- **Database:** PostgreSQL

## Screenshots
![screencapture-localhost-8080-2025-07-02-03_46_52](https://github.com/user-attachments/assets/adbe388a-37ba-451e-b11a-192bcd2a4c97)

## Getting Started

### Prerequisites
- Java 21+
- Maven
- PostgreSQL (running and accessible)

### Setup
1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/personal-budget-tracker.git
   cd personal-budget-tracker
   ```
2. **Run the application:**
   The project includes a helper script that sets up the environment and starts the server using the default H2 database (no external DB setup required).
   ```bash
   ./start.sh
   ```
   Alternatively, you can manually run:
   ```bash
   cd budgettracker
   mvn spring-boot:run
   ```

3. **Running Tests:**
   Use the provided test script to run the full suite:
   ```bash
   ./test.sh
   ```

4. **Access the app:**
   - Open [http://localhost:8080](http://localhost:8080) in your browser.

## Reference Tests (CSCI 630)
This project includes example implementations for the four required test types found in `com.sarasitha.budgettracker.examples`:

1. **MVC Test (Controller Slice)**
   - **File:** `ExampleTransactionControllerMvcTest.java`
   - **Annotations:** `@WebMvcTest`
   - **Description:** Tests the controller layer in isolation with mocked services and security.

2. **Service Unit Test**
   - **File:** `ExampleUserServiceTest.java`
   - **Annotations:** `@ExtendWith(MockitoExtension.class)`
   - **Description:** Fast unit tests using Mockito without loading the Spring context.

3. **Repository Test (JPA Slice)**
   - **File:** `ExampleTransactionRepositoryTest.java`
   - **Annotations:** `@DataJpaTest`
   - **Description:** Tests database interactions using an in-memory H2 database.

4. **Integration Test**
   - **File:** `ExampleHomeFlowIntegrationTest.java`
   - **Annotations:** `@SpringBootTest`, `@AutoConfigureMockMvc`
   - **Description:** Full stack integration test ensuring components work together.

## Usage
- Add transactions and income via the dashboard forms.
- View analytics, category breakdowns, and net cashflow.
- Export your data as CSV for backup or analysis.

### Test Account
The application automatically seeds a test user with sample data for quick evaluation:
- **Username:** `test`
- **Password:** `test`

## Contributing
Contributions are welcome! Please open issues or submit pull requests for improvements and bug fixes.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Credits
- UI powered by [Tailwind CSS](https://tailwindcss.com/) and [Chart.js](https://www.chartjs.org/)
- Built with [Spring Boot](https://spring.io/projects/spring-boot)

---

**Note:** HTML, CSS, and JavaScript are present in this project for the UI, but are hidden from GitHub language statistics using `.gitattributes` to highlight Java and Spring Boot as the main technologies.

_Enjoy tracking your budget with style!_
