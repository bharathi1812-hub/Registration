# Full Stack User Registration Application

This project is a **simple Full Stack application** built using **Spring Boot (Backend)** and **HTML + JavaScript (Frontend)**. It allows users to **register**, prevents **duplicate usernames**, and exposes REST APIs for user management.

---

## 📁 Project Structure

```
demo/
│
├── src/                     # Spring Boot backend source code
│   └── main/java/com/gprec/demo
│       ├── controller/      # REST controllers
│       ├── service/         # Business logic
│       ├── repository/      # JPA repositories
│       └── model/           # Entity classes
│
├── frontend/                # Frontend (HTML + JS)
│   ├── index.html
│   └── script.js
│
├── pom.xml                  # Maven configuration
├── .gitignore               # Ignored files (DB, target, etc.)
└── README.md                # Project documentation
```

---

## 🛠 Technologies Used

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* H2 / MySQL Database

### Frontend

* HTML
* CSS
* JavaScript (Fetch API)

---

## ⚙️ Backend Setup & Run

### Prerequisites

* Java JDK 17+
* Maven
* IDE (VS Code / IntelliJ)

### Steps

1. Open terminal in project root (`demo` folder)

2. Run Spring Boot application:

```bash
mvn spring-boot:run
```

3. Backend will start at:

```
http://localhost:8080
```

---

## 🌐 Frontend Setup & Run

### Steps

1. Open the `frontend` folder

2. Open `index.html` in a browser

   OR

3. Use VS Code Live Server (recommended):

   * Right click `index.html`
   * Select **Open with Live Server**

Frontend runs at:

```
http://127.0.0.1:5500/frontend/
```

---

## 🔗 API Endpoints

### 1️⃣ Register User

**POST** `/register`

**Request Body (JSON):**

```json
{
  "username": "test",
  "password": "123"
}
```

**Responses:**

* ✅ Success → User object
* ❌ Duplicate username →

```
This username is already registered. Try another.
```

---

### 2️⃣ Get All Users

**GET** `/users`

**Response:**

```json
[
  {
    "id": 1,
    "username": "test",
    "password": "123"
  }
]
```

---

## 🧠 Application Flow

1. User enters username & password in frontend
2. Frontend sends POST request using Fetch API
3. Backend controller receives request
4. Service layer checks for duplicate username
5. User saved in database if valid
6. Response sent back to frontend
7. Frontend shows success or error message

---

## 🛡 Validations Implemented

### Frontend

* Empty username/password check

### Backend

* Duplicate username prevention
* Unique constraint on username column

---

## 🚫 Git Ignore Rules

The following files are ignored:

* Database files (`*.db`, `*.mv.db`)
* Build folders (`target/`)
* Node modules (`node_modules/`)

---
