# SpaceRideGalley
This repository is created to demonstrate and complete an assignment requiring for an amazing job opportunity.

## Goal : 
Create an Android APP which show a list of SPACE iamges in a grid fashion and upon clicking on one tile would take you to detail screen of that image.

## Code Architecture :
There are total 3 modules in repo. 'app' and 'appcompose' are the two application modules, which results in respective view based and compose based app. Third module is 'imagefeaturelibrary' is an androdi library module which provide non-ui code to both app and appcompose module.

This multi module App follows MVVM with Clean architecture. Uses Hilt DI, Coil Image loading, Coroutin and Flows. Compose UI is also present in 'appcompose' module.

## Screens :
1. Images Grid Screen
This is the home screen. When it launches, show a scrollable grid of pictures starting with
the latest images first. When the user taps on an image that should open the image detail
screen.
2. Image Detail Screen
This screen displays the full-size image along with the metadata like title, description, etc.
The user should also be able to swipe to previous or next images from this screen itself.

## Data Source : 
A locally downloaded json file with image informations.

## Evaluation :
Score of the exercise is based on below points. Try to follow the coding conventions and coding best practices like SOLID principles. It is not output which evaluates this exercise.
1. Ideal app structure
2. Usage of Front-end Design Patterns
3. Use Fragments rather Activities
4. At least a Unit test which tests the actual logic
5. Latest trends compose/hilt/koin/
6. Good to have in Kotlin
7. Proper naming conventions for methods, classes and properties

## Demo :


https://github.com/rishikumr/SpaceRideGalley/assets/31123825/bf29c7cc-9912-4516-9be8-8fac3be223f1



