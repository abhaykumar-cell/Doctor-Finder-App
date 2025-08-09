🩺 Doctor Finder
Doctor Finder is a simple full-stack application that helps users search for doctors based on location and specialization.
The backend is built using Spring Boot, and the frontend is developed in Next.js with TypeScript.
I have also integrated Swagger to make API testing and documentation easy.

✨ What the Project Does
Add Doctor – Add new doctor details with an image. (Currently available only via API, not from the frontend)

Search Doctors – Filter and view doctors by their location and specialization.

Interactive API Docs – Explore and test APIs using Swagger UI.

Responsive UI – Frontend adjusts nicely for both desktop and mobile screens.

🛠 Tech Stack
Backend:

Spring Boot (Java)

Spring Data JPA

MySQL

Swagger for API documentation

Frontend:

Next.js (TypeScript)

React Hooks

Axios for API calls

📌 API Overview
1. Add Doctor
Method: POST
Endpoint: /docfinder/add
Description: Adds a doctor’s details to the system. This is currently supported only through API calls.

Example using curl:

bash
Copy
Edit
curl -X POST "http://localhost:8081/docfinder/add" \
-H "Content-Type: multipart/form-data" \
-F "name=Dr. John Doe" \
-F "specialization=Cardiologist" \
-F "location=Mumbai" \
-F "experience=10" \
-F "rating=4.8" \
-F "email=john@example.com" \
-F "phone=9876543210" \
-F "file=@profile.jpg"
2. Show Doctors (By Location & Specialization)
Method: POST
Endpoint: /docfinder/show
Description: Returns a filtered list of doctors based on the location and specialization provided.

Request example:

json
Copy
Edit
{
  "location": "Mumbai",
  "specialization": "Cardiologist"
}
Response example:

json
Copy
Edit
[
  {
    "id": 1,
    "name": "Dr. John Doe",
    "specialization": "Cardiologist",
    "location": "Mumbai",
    "experience": 10,
    "rating": 4.8,
    "email": "john@example.com",
    "phone": "9876543210",
    "profile_image": "/uploads/doctor1.jpg",
    "available": true
  }
]
📜 Swagger Documentation
Once the backend is running, you can access the Swagger UI here:

bash
Copy
Edit
http://localhost:8081/swagger-ui/index.html
🚀 Running the Project
Backend (Spring Boot)

bash
Copy
Edit
cd backend
mvn spring-boot:run
Frontend (Next.js + TypeScript)

bash
Copy
Edit
cd frontend
npm install
npm run dev
Frontend will be available at:

arduino
Copy
Edit
http://localhost:3000
⚠ Current Limitation
At the moment, adding a doctor can only be done through the API (via Swagger or API client).
The frontend is focused on search and display functionality.

📂 Folder Structure
bash
Copy
Edit
Doctor-Finder/
│
├── backend/                # Spring Boot backend
│   ├── src/main/java/...    # API code
│   ├── src/main/resources/  # Config files
│   └── pom.xml              # Maven dependencies
│
├── frontend/               # Next.js + TypeScript frontend
│   ├── pages/               # Application pages
│   ├── components/          # UI components
│   └── package.json         # Dependencies
👤 Developer
Name: Abhay Bhujwa
GitHub: abhaykumar-cell
Email: abhaygupta8103@gmail.com
