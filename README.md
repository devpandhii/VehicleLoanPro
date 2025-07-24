# VehicleLoan Pro

VehicleLoan Pro is a comprehensive web application designed to streamline the process of vehicle loan management. It provides users with an intuitive dashboard to manage loan applications, calculate EMI, make payments, and track their loan status efficiently.

## 📖 Project Overview

This project enables customers to apply for vehicle loans, view and manage their loan applications, make monthly EMI payments, and track their payment history. It incorporates robust authentication, two-factor authentication via email OTP, real-time application status updates, and detailed loan statements.

---

## 🚀 Features

### User Features (Frontend)
- **User Authentication & 2FA:** Secure login with email and password, enhanced with email-based OTP for two-factor authentication.
- **User Profile Management:** View detailed profile information including PAN, Aadhar, bank account, and more.
- **Loan Application Management:**
  - View the status of multiple loan applications.
  - Apply for new vehicle loans.
  - See detailed application information including vehicle type, loan amount, tenure, and interest rate.
- **Dashboard & Statistics:**
  - Overview of active loans, total loan amount, monthly EMI, and remaining tenure.
  - Recent activity feed including loan approvals and payments.
- **EMI Management:**
  - View monthly EMI amount and payment status.
  - Make EMI payments securely.
  - Download or email loan statement PDFs summarizing all loans and payments.
- **Calculators:**
  - EMI Calculator
  - Eligibility Calculator
  - Loan Amount Calculator
- **Additional Utilities:**
  - Customer support access.
  - Downloadable statements.
  - Logout functionality.

### Administrator & Backend Features
- **Loan Application Processing:** Admin approval or rejection of loan applications.
- **Customer Management:** Handle customer records securely with authentication and password hashing.
- **EMI Payment Tracking:** Detailed tracking of EMI payments per application.
- **Email Services:**
  - Welcome emails upon user registration.
  - OTP emails for login authentication.
  - Emailing PDF statements.
- **Microservices Architecture:** Separately maintained modules with distinct responsibilities including:
  - Loan Customer Service
  - Application Status Service
  - Loan Payment Service
  - API Gateway and Bank Gateway integrations
- **Service Discovery:** Using Eureka for dynamic service registration and discovery.

---

## 🌐 Backend Branch



This branch includes all API endpoints, service logic, database schemas, and email server integration required for the application features described above.

---

## 🛠️ Tech Stack

- **Frontend:**
  - HTML5, CSS3 (with modern gradients and animations)
  - Bootstrap 5 for responsive layout and components
  - FontAwesome for icons
  - Vanilla JavaScript for interactivity and API integration
  - jsPDF library for generating PDF loan statements

- **Backend:**
  - Spring Boot (Java) — Microservices for:
    - Loan Customer Management
    - Loan Application Status Tracking
    - Loan Payment / EMI Management
  - REST APIs with Spring MVC
  - JPA/Hibernate for ORM
  - Oracle Database for persistent storage
  - Node.js with Nodemailer for Email Services (OTP & Welcome Emails)
  - Eureka for Service Discovery
  - API Gateway for routing across multiple backend services

- **Tools & Environment:**
  - Git & GitHub for version control
  - VS Code for frontend and Node.js backend development
  - Postman for API testing
  - Maven for Java project management and dependencies

---

## 📁 Repository Structure

- **`main` branch:** Frontend source code — HTML, CSS, JavaScript files
- **`VehicleLoanPro-Backend` branch:** Backend microservices source code with Java and Node.js codebases

---

## 🎯 Future Enhancements

- Integration with Payment Gateways for real-time EMI transactions
- Enhanced PDF statements with customized branding and downloadable invoices
- Mobile app development for on-the-go loan management
- Notifications via SMS and push for reminders and loan updates
- Advanced analytics and loan forecasting

---

## 📞 Contact

For questions, feature requests or support feel free to reach out!

---

Thank you for checking out VehicleLoan Pro — your trusted partner in vehicle finance!
