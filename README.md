Abyssinian Coffee Shop - Final Project
This is the final project developed to fulfill a partial requirement for graduation from a bootcamp program. The project is a backend application for managing coffee inventory and related operations

Features
1. Coffee Management
   •	Add New Coffee: Allows the addition of new coffee types, specifying details like name, quality, cultivation area (highland/lowland), price, and available stock quantity.
   •	View All Coffees: Retrieves a list of all coffees available in the system.
   •	View Coffee by ID: Retrieve specific coffee details using a unique coffee ID.
   •	Update Coffee Information: Update coffee details (name, quality, price, etc.) by specifying the coffee ID.
   •	Delete Coffee: Deletes a specific coffee entry by its unique ID.
2. Stock Management
   •	Update Coffee Quantity: Modify the quantity of a specific coffee in stock (add or subtract stock), ensuring that stock cannot go below zero.
   •	Track Available Stock: Easily check the quantity available for any coffee in stock.
3. Quality and Cultivation Area
   •	Quality Levels: Coffee quality can be assigned a level (from 1 to 3, with 1 being the highest quality, labeled "Premium").
   •	Cultivation Area: Coffee is categorized based on the cultivation area (highland or lowland), providing insight into where the coffee was grown.
4. User Authentication and Authorization
   •	Basic Authentication: Basic username and password authentication to access the backend API (you can extend this with more robust authentication mechanisms like JWT or OAuth2).
5. API Endpoints
   The following API endpoints are available to interact with the coffee shop data:
   •	GET /api/coffees – Retrieve all coffee entries.
   •	GET /api/coffees/{id} – Retrieve a specific coffee entry by its ID.
   •	POST /api/coffees – Create a new coffee entry.
   •	PUT /api/coffees/{id} – Update an existing coffee entry by its ID.
   •	PATCH /api/coffees/{id} – Update the quantity of a coffee entry.
   •	DELETE /api/coffees/{id} – Delete a coffee entry by its ID.
6. Database Integration

•	JPA and Hibernate: Integrated with MySQL (or another relational database) to persist coffee details.
•	Dynamic Schema Updates: Database schema updates automatically handled by Hibernate.

7. Error Handling and Validation
   •	Input Validation: Basic validation for coffee-related fields like name, price, and quantity.
   •	Error Handling: Returns appropriate error messages for invalid operations (e.g., trying to subtract more stock than available).
8. Logging and Monitoring
   •	Logging: Logs relevant actions and events, including CRUD operations, for monitoring purposes.
   •	Error Logging: Captures errors and exceptions in a structured format for debugging and troubleshooting.
9. Technologies Used
   •	Spring Boot: Backend framework for creating the REST API.
   •	Spring Data JPA: For database interaction and CRUD operations.
   •	MySQL: Database for storing coffee data (can be replaced with any other relational database).
   •	Java: The main programming language for the backend.
   •	Spring Security: Basic security setup for user authentication.
   •	Lombok: For reducing boilerplate code (e.g., getters, setters, constructors)