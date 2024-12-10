# UserProfileApp App

This project is to verify concepts about Kotlin, teached by IronHack and Breogán Amoedo

## Run Locally

Clone the project

```bash
  git clone https://github.com/ludicavale/UserProfileApp2/tree/main/Android/UserProfileApp2
```

Go to the project directory

```bash
  cd UserProfileApp2
```

## Project Description:

This app is to run into an User List and show the values according the Id

## Architecture Overview:

In this project, I am using Clean architecture, an architectural paradigm that emphasizes separation of concerns, scalability, and maintainability in software development.
I am using the three primary layers of Clean Architecture: Presentation, Domain, and Data. Each layer has distinct responsibilities:

### Presentation
#### Responsibilities:

Display data to the user.
Capture user input and delegate actions to the Domain layer.
Observe data from ViewModels to update the UI accordingly.

### Domain
#### Responsibilities:

Define business rules and operations independent of UI and data sources.
Coordinate data flow between the Presentation and Data layers.

### Domain
#### Responsibilities:

Manage data fetching, caching, and storage.
Implement the repository interfaces defined in the Domain layer.

## Dependency Injection Setup:

In This project, I am using Hilt modules, Hilt modules are responsible for providing dependencies. I used Hilt’s @HiltViewModel annotation to annotate my ViewModel and inject dependencies via constructor injection or in my composable functions

## Usage Instructions:

- Enter a valid User ID (e.g., 1, 2, or 3) and click “Load User”.
- Observe the loading indicator and the displayed user information upon successful data retrieval.
- Enter an invalid User ID (e.g., 999) to test error handling and ensure that appropriate feedback is provided to the user.
  
### Expected Outcomes:

Valid User ID: The app should display the corresponding user’s name and email after showing the loading indicator briefly.
Invalid User ID: The app should display an error message indicating that the user was not found.

## Features Implemented:

- Clean Architecture
- Hilt Module
- Materials3
- Kotlin
- 
## Lessons Learned

In this project, I need to verify a lot of documentation to recreate the best way to show and include Coroutines.

In this, I try to apply Clean Architecture into the codification.

I needed verify example project to know how access values into variables and how verify the different kinds of states into the coroutines using Dagger and Hilt.

NOTE:In the future, I will try to include a webservice to save the information sent and recovery it.


## Demo

![image](https://github.com/user-attachments/assets/e339ed16-0986-4a15-a12d-3785dd2039b9)


![image](https://github.com/user-attachments/assets/c113cbcd-5d25-4776-8511-9dc28f687b82)
