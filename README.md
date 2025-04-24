# Agro-Aide: Farmer's Crop Selling Platform

A comprehensive platform for farmers to sell their crops with features like weather forecasting, payment integration, and admin management.

## Key Technical Achievements

- Implemented secure JWT-based authentication system with role-based access control, ensuring secure user management and data protection
- Developed real-time weather forecasting integration using OpenWeather API with GPS-based location detection and caching mechanism
- Integrated Razorpay payment gateway with comprehensive order management system, handling payment verification and transaction security
- Built scalable RESTful APIs with Spring Boot, implementing efficient database operations using PostgreSQL and JPA for optimal performance

## Features

- User Authentication (Signup/Login)
- Crop Management (Add, Update, Delete, Search)
- Weather Forecasting (by city/state or GPS coordinates)
- Payment Integration (Razorpay)
- Admin Dashboard
- Image Upload for Crops
- PostgreSQL Database Integration

## Prerequisites

- Java 11 or higher
- Maven
- PostgreSQL (NEON)
- OpenWeather API Key
- Razorpay Account

## Setup

1. Clone the repository:
```bash
git clone https://github.com/yourusername/agro-aide.git
cd agro-aide
```

2. Configure the database:
- Create a PostgreSQL database on NEON
- Update the database credentials in `src/main/resources/application.properties`

3. Configure API Keys:
- Get an OpenWeather API key from https://openweathermap.org/api
- Get Razorpay API keys from your Razorpay dashboard
- Update the API keys in `src/main/resources/application.properties`

4. Build the project:
```bash
mvn clean install
```

5. Run the application:
```bash
mvn spring-boot:run
```

## API Endpoints

### User Management
- POST `/api/users/register` - Register a new user
- GET `/api/users/{username}` - Get user details
- PUT `/api/users/{id}` - Update user details
- DELETE `/api/users/{id}` - Delete user

### Crop Management
- POST `/api/crops` - Add a new crop
- GET `/api/crops` - Get all crops
- GET `/api/crops/category/{category}` - Get crops by category
- GET `/api/crops/seller/{sellerId}` - Get crops by seller
- GET `/api/crops/available` - Get available crops
- GET `/api/crops/search/location` - Search crops by location
- GET `/api/crops/search/price` - Search crops by price range
- GET `/api/crops/{id}` - Get crop details
- PUT `/api/crops/{id}` - Update crop details
- DELETE `/api/crops/{id}` - Delete crop

### Order Management
- POST `/api/orders` - Create a new order
- POST `/api/orders/{orderId}/razorpay` - Create Razorpay order
- POST `/api/orders/{orderId}/verify` - Verify payment
- GET `/api/orders/buyer/{buyerId}` - Get orders by buyer
- GET `/api/orders/seller/{sellerId}` - Get orders by seller
- GET `/api/orders/status/{status}` - Get orders by status
- GET `/api/orders/{id}` - Get order details
- PUT `/api/orders/{id}/status` - Update order status

### Weather Information
- GET `/api/weather/location` - Get weather by city and state
- GET `/api/weather/coordinates` - Get weather by GPS coordinates

## Admin Access

Default admin credentials:
- Username: jineshsingatkar
- Password: (set during first run)

## Security

- JWT-based authentication
- Password encryption using BCrypt
- Role-based access control

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details. 