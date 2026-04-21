# Login Form (Java AWT)

This mini-project is a simple **login interface** built using **Java AWT** components:

- `Label`
- `TextField`
- `Button`

It demonstrates **input validation** and **event handling**.

## Features

- Username and password input fields
- Basic validation:
  - Both fields must be filled in
  - Hardcoded credentials: `admin` / `password`
- Message label shows success or failure

## Project Structure

- `src/LoginForm.java` – main AWT UI and logic

## How to Compile and Run

Make sure you have **JDK (Java Development Kit)** installed and `javac` / `java` available in your PATH.

From the project root (`miniproject2.5`), run:

```bash
mkdir -p out
javac -d out src/LoginForm.java
java -cp out LoginForm
```

On Windows PowerShell (without `mkdir -p` support), you can do:

```powershell
mkdir out -Force
javac -d out src\LoginForm.java
java -cp out LoginForm
```

After running the `java` command, a window titled **"Login Form"** will appear.  
Enter a username and password, then click **Login** to see the validation result.

