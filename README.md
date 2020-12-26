# Social media application for travel agency aimed at fulfilling the following requirements.
1. User can register
2. User can login
3. User can post a status by checking in a location (from a drop down box)
4. User can change the privacy of the post to public, private. If he chooses public any users (including
    anonymous user) can see the post in home page of the web application. If he chooses private only that
    user can see the post from his personal profile page.
5. User can pin his status top of his/her profile

## Setup Process:
1. The application is a Maven project. Therefore, Maven must have to present in the dev environment.
2. The application is developed with Intellij Idea. Therefore, it is preferred to use intellij for importing easily.
3. The development environment JDK version is JDK 11
4. User must create database called tam-dev for development server user can create tam-prod for production server using configure profile application.properties
5. Database is PostgreSQL. DB username is postgres and password is asifRcode. If the connection is properly configured, database will be created and initialized with seed data automatically.
6. The port user this project is 8090

## url and template view
1. login, url: http://localhost:8090/login
![Login](https://github.com/nazfisa/TravelAgency/blob/master/screenshot/login.PNG)

2. Registration, url: http://localhost:8090/registration
![Login](https://github.com/nazfisa/TravelAgency/blob/master/screenshot/register.PNG)

3. Hompage , url:http://localhost:8090/
![Homepage](https://github.com/nazfisa/TravelAgency/blob/master/screenshot/homePage.PNG)

4. Profiles , url: http://localhost:8090/profiles/status
![profile Header] (https://github.com/nazfisa/TravelAgency/blob/master/screenshot/userProfileHead.PNG
![Profile Footer] (https://github.com/nazfisa/TravelAgency/blob/master/screenshot/userProfileFooter.PNG)
