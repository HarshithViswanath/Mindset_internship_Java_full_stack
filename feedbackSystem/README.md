# Feedback Analysis Portal (MVC)

Java web app: Servlets + JSP + JDBC + MySQL. Build with **Maven Wrapper** (no NetBeans required).

## Prerequisites

- **JDK 11+** (project targets Java 11; newer JDKs work)
- **MySQL Server**
- **Apache Tomcat 9.x** (`javax.servlet`; do not use Tomcat 10+ without migrating to Jakarta EE)

## Database

1. Start MySQL and run `sql/schema.sql` (creates `feedback_portal` and tables).
2. Edit `src/main/webapp/WEB-INF/web.xml` — set `jdbc.url`, `jdbc.user`, and `jdbc.password` for your MySQL instance.

Default admin account (change in production): `admin@portal.local` / `admin123`.

## Build (Windows)

From this folder:

```bat
mvnw.cmd -DskipTests package
```

Output: `target/feedback-portal.war`

On Linux/macOS with Git Bash, you can run the same Java line as in `mvnw.cmd` or install a Unix `mvnw` script from the [Maven Wrapper](https://maven.apache.org/wrapper/) documentation.

## Deploy

Copy `target/feedback-portal.war` into Tomcat’s `webapps/` folder, start Tomcat, then open:

`http://localhost:8080/feedback-portal/`

## Eclipse / VS Code

- **Eclipse:** File → Import → Maven → Existing Maven Projects → select this directory.
- **VS Code:** “Extension Pack for Java”, open this folder, run the Maven lifecycle `package` from the sidebar or terminal.
