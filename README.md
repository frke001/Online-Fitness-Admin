# OnlineFitness - Administrator Application (Dynamic Web Project with JSP M2)

## Description

The Administrative application enables management of the online fitness system through a dynamic web application. It adheres to the JSP M2 principle, where all pages are located within the `WEB-INF` directory and are not publicly accessible. Other resources, such as CSS, JavaScript, and images, reside in the `WebContent` directory.

## Features

- **Login**: The application provides a login form on the home page. Users can log in with their credentials to access the administrative dashboard.

- **Categories Management**: Administrators can manage fitness program categories, including CRUD operations for both general categories and specific subcategories.

- **User Management**: Administrators have the ability to manage user data, including CRUD operations for users of the fitness online application.

- **Statistics**: The application offers a feature to view statistics and logs related to the fitness backend system.

## Implementation Details

The Administrative application follows the JSP M2 approach, ensuring that all pages are located within the `WEB-INF` directory to restrict public access. Additionally, the application may utilize third-party libraries for designing the user interface.

## Running the Application

To run the application, you can deploy it on a servlet container such as Apache Tomcat or run it within your IDE. Ensure that you have configured the appropriate database connection properties.

## Database Configuration

Ensure that MySQL is installed and running on your system. Update the database connection properties in the util/ConnectionPool.properties file to match your MySQL configuration.

## GUI Development

The GUI for this application is developed using JSP (JavaServer Pages), and Bootstrap framework is utilized for styling. JSP files can be found in the `WebContent` directory, where you can customize these files to modify the user interface according to your requirements. Bootstrap CSS and JavaScript files are located in the `bootstrap` directory within `WebContent`, providing a responsive and visually appealing design for the application.

## Project Structure

The project structure includes the following packages:

- **beans**: Contains Java beans representing entities or data objects used in the application.
- **controllers**: Contains controllers for handling requests and managing application flow.
- **dao**: Contains Data Access Objects (DAOs) responsible for interacting with the database.
- **mysql**: Includes implementations of DAO interfaces specific to MySQL database interaction.
- **util**: Contains utility classes, including database connection utilities.
- **dto**: Contains Data Transfer Objects (DTOs) used for communication between different layers of the application.

## Application Screenshots

![image](https://github.com/frke001/Task-scheduler-and-parallel-processing-of-multimedia-data/assets/93668747/c262f1f4-5cdc-4ea4-aba3-1a77e9830cbe)
![image](https://github.com/frke001/Task-scheduler-and-parallel-processing-of-multimedia-data/assets/93668747/bc9005e7-9317-4007-bc5e-e68d765992fd)
![image](https://github.com/frke001/Task-scheduler-and-parallel-processing-of-multimedia-data/assets/93668747/dfb1eccb-38ac-4f5a-9f62-9fddc19aa4ff)

