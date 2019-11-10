# Vo Kim Nguyen Assignment

## Assumptions Made

* System had three main views, **Employee View**, **Admin Employee** and **Admin Performance Review**
* There are no authenticate system
* Therefore, if uses on the page **Employee View**, mean they are employee. If on page **Admin Employee** and **Admin Performance Review**, mean they are admin
* Admin is only able to view a performance review, not able to delete or update or add
* All validation also made on Frontend, so if you manual send API with another Tool like Postman to hack backend, it's easy.

## Technical stack

* #### Backend
  * Java 8 is primary language
  * Recommend use IntelliJ as mainly IDE fro project
  * Use SpringBoots, Gradle, JPA and Lombok
* #### Frontend
  * Use VueJs Framework, Vuex
  * Use node >= 10.x.x

## How To run

* Create new Mysql database, and import **assignment.sql** for latest database structure
* Update file **application-local.properties** with your Mysql server information
* Enable Annotation Processors, for IntelliJ IDEA, use dialog *Preferences > Project Settings > Compiler > Annotation Processors.*
* Build Frontend, **cd frontend** and **npm install** and **npm run build** (Make sure node > 10.x.x)
* Application listen on port 9992


# Full Stack Developer Challenge
This is an interview challengs. Please feel free to fork. Pull Requests will be ignored.

## Requirements
Design a web application that allows employees to submit feedback toward each other's performance review.

*Partial solutions are acceptable.*  It is not necessary to submit a complete solution that implements every requirement.

### Admin view
* Add/remove/update/view employees
* Add/update/view performance reviews
* Assign employees to participate in another employee's performance review

### Employee view
* List of performance reviews requiring feedback
* Submit feedback

## Challenge Scope
* High level description of design and technologies used
* Server side API (using a programming language and/or framework of your choice)
  * Implementation of at least 3 API calls
  * Most full stack web developers at PayPay currently use Java, Ruby on Rails, or Node.js on the server(with MySQL for the database), but feel free to use other tech if you prefer
* Web app
  * Implementation of 2-5 web pages using a modern web framework (e.g. React or Angular) that talks to server side
    * This should integrate with your API, but it's fine to use static responses for some of it 
* Document all assumptions made
* Complete solutions aren't required, but what you do submit needs to run.

## How to complete this challenge
* Fork this repo in github
* Complete the design and code as defined to the best of your abilities
* Place notes in your code to help with clarity where appropriate. Make it readable enough to present to the PayPay interview team
* Complete your work in your own github repo and send the results to us and/or present them during your interview

## What are we looking for? What does this prove?
* Assumptions you make given limited requirements
* Technology and design choices
* Identify areas of your strengths
* This is not a pass or fail test, this will serve as a common ground that we can deep dive together into specific issues
