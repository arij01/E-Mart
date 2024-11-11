# E-commerce Application

This project is a scalable e-commerce platform built using a microservices architecture, designed to handle product listings, orders, customer accounts, payments, and more. It leverages robust backend frameworks, modern frontend technologies, and a secure user authentication system.

## 📖 Overview

The application provides a comprehensive platform for users to browse products, add them to their cart, and place orders. It includes distinct microservices for managing customers, orders, products, payments, notifications, and analytics.

## 🧩 Architecture

The application is structured with the following technologies:

- **Backend:** Spring Boot for core microservices
- **Frontend:** Angular
- **Microservices Management:** Spring Cloud
- **User Authentication:** Keycloak
- **Analytics & Reporting:** Django for enhanced data visualization

## 🗃️ Domain Modules

1. **Customer Domain**
   - Manages customer information and associated addresses.
   - **Tables:** 
     - Customer: `id`, `firstname`, `lastname`, `email`
     - Address: `id`, `street`, `houseNumber`, `zipCode`

2. **Order Domain**
   - Manages customer orders and the ordered products.
   - **Tables:** 
     - Order: `id`, `orderDate`, `reference`
     - OrderLine: `id`, `quantity`

3. **Product Domain**
   - Manages products and their categories.
   - **Tables:** 
     - Product: `id`, `name`, `description`, `availableQuantity`, `price`
     - Category: `id`, `name`, `description`

4. **Payment Domain**
   - Handles payments related to orders.
   - **Tables:** 
     - Payment: `id`, `reference`, `amount`, `status`

5. **Notification Domain**
   - Sends notifications related to orders and other events.
   - **Tables:** 
     - Notification: `id`, `sender`, `recipient`, `content`, `date`

6. **Analytics & Reporting Domain**
   - Tracks sales, customer behavior, and business performance. Admins can view dashboards and reports using Django.
   - **Why Django:**
     - Built-in admin interface and powerful data visualization libraries (e.g., Pandas, Matplotlib).
     - Compatibility with SQL and NoSQL databases for data extraction.
     - Django ORM for easier database interactions.

7. **User Domain**
   - Manages user authentication and roles with Keycloak.
   - **Tables:** 
     - User: `id`, `username`, `password`, `email`, `roles`
     - Role: `id`, `roleName`
     - Permission: `id`, `permissionName`

## 🔄 Domain Relationships

- **Customer - Address:** A customer has an associated address.
- **Order - Customer:** Each order is linked to a customer.
- **OrderLine - Product:** Each order line is associated with a product.
- **Order - Payment:** Each order can be linked to a payment.
- **Notification - Order:** Notifications are sent about orders.
- **User - Role/Permission:** Each user is associated with roles that determine their permissions.
- **User - Customer:** A user can also be a customer.

## 🚀 Features

- Manage customers and their addresses.
- Manage products and categories.
- Handle orders and track order items.
- Process payments and track their status.
- Send notifications related to orders.
- User authentication and management with Keycloak.

## 📊 Analytics and Reporting

The application’s analytics are powered by Django, enabling advanced data processing and visualization with tools like Pandas and Matplotlib. This module provides administrators with insights into sales performance and customer behavior through comprehensive dashboards.
