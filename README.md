#   wildlife_tracker

#### 28-SEp-2018
#### Created By **Tonny muchui**

## Description

This is an app that help to truck down endangered animals in the forest 

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You will need to:

* Have Java
* Spark
* Have intellij installed

# Installing

* Go to Github.com

* Search for Tonnymuchui https://github.com/tonnymuchui then navigate to the project **Wildlife_tracker**

* Then clone the project or fork it.

## Development server

Use intellij to run project.
## Built With

* java
* CREATE DATABASE wildlife_tracker;
* CREATE TABLE animals (id serial PRIMARY KEY,name varchar);
* CREATE TABLE sightings (id serial primary key,animal_id varchar,location varchar,ranger_name);
* CREATE TABLE endangered_animals (id serial primary key,name text,health text,age int);_


## Build & Deployment

Navigate into the root folder and run intellij to run application

## License

The MIT License (MIT)

Copyright (c) 2018 Tonny muchui

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.