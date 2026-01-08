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
   cd personal-budget-tracker/budgettracker
   ```
2. **Configure PostgreSQL:**
   - Edit `src/main/resources/application.properties` with your DB credentials.
3. **Build and run:**
   ```bash
   mvn spring-boot:run
   ```
4. **Access the app:**
   - Open [http://localhost:8080](http://localhost:8080) in your browser.

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
