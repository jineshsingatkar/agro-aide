# Agro-Aide - Farmer's Crop Selling Platform

A full-stack application that connects farmers directly with buyers, enabling them to sell their crops online.

## Live Demo
Visit our live application at: [https://agro-aide.vercel.app](https://agro-aide.vercel.app)

## Tech Stack
- Backend: Spring Boot 2.5.6
- Frontend: React.js
- Database: PostgreSQL
- Authentication: JWT
- Payment Gateway: Razorpay
- Weather API: OpenWeather API
- Deployment: Vercel (Frontend), Railway (Backend)

## Prerequisites
- Java 11 or higher
- Node.js 14 or higher
- PostgreSQL 12 or higher
- Maven 3.6 or higher
- npm or yarn

## Project Structure
```
agro-aide/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── agroaide/
│   │   │           ├── config/
│   │   │           ├── controller/
│   │   │           ├── dto/
│   │   │           ├── entity/
│   │   │           ├── repository/
│   │   │           ├── service/
│   │   │           └── AgroAideApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── frontend/
│   ├── public/
│   └── src/
├── pom.xml
└── README.md
```

## Setup Instructions

### 1. Database Setup
1. Install PostgreSQL from [https://www.postgresql.org/download/](https://www.postgresql.org/download/)
2. Create a new database:
```sql
CREATE DATABASE agroaide;
```
3. Configure database connection in `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/agroaide
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 2. Backend Setup
1. Clone the repository:
```bash
git clone https://github.com/yourusername/agro-aide.git
cd agro-aide
```

2. Configure environment variables:
- Create `application.properties` in `src/main/resources/`:
```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/agroaide
spring.datasource.username=your_username
spring.datasource.password=your_password

# JWT Configuration
jwt.secret=your_jwt_secret
jwt.expiration=86400000

# Razorpay Configuration
razorpay.key.id=your_razorpay_key_id
razorpay.key.secret=your_razorpay_key_secret

# OpenWeather API Configuration
openweather.api.key=your_openweather_api_key
```

3. Build and run the backend:
```bash
mvn clean install
mvn spring-boot:run
```

### 3. Frontend Setup
1. Navigate to frontend directory:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install
```

3. Create `.env` file:
```env
REACT_APP_API_URL=http://localhost:8080
REACT_APP_RAZORPAY_KEY_ID=your_razorpay_key_id
```

4. Start the development server:
```bash
npm start
```

## API Documentation
The API documentation is available at: `http://localhost:8080/swagger-ui.html` when running the backend server.

## Required API Keys and Services

### 1. Razorpay
- Sign up at [https://razorpay.com](https://razorpay.com)
- Get your API keys from the dashboard
- Add them to `application.properties`

### 2. OpenWeather API
- Sign up at [https://openweathermap.org/api](https://openweathermap.org/api)
- Get your API key
- Add it to `application.properties`

## Deployment

### Backend Deployment (Railway)
1. Create an account on [Railway](https://railway.app)
2. Connect your GitHub repository
3. Configure environment variables
4. Deploy the application

### Frontend Deployment (Vercel)
1. Create an account on [Vercel](https://vercel.com)
2. Import your repository
3. Configure environment variables
4. Deploy the application

## Contributing
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Support
For support, email support@agroaide.com or create an issue in the repository. 

## changes lines 
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
