# _Wildlife Tracker Application_

#### _Lets users add sightings of certain animals to help conserve the wildlife in the forest._

#### By _**Thomas Rivas**_

## Description

#### _Lets users add sightings of certain animals to help conserve the wildlife in the forest. Rangers can add sightings of animals they had seen. Also the user can see if the anumal is endangered or not_


## Setup/Installation Requirements

* _Clone this repository_
* _Open in your text editor of choice_

In PSQL:
1. CREATE DATABASE wildlife_tracker;
2. CREATE TABLE animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar);
3. CREATE TABLE sightings (id serial PRIMARY KEY, location varchar, date timestamp, rangername varchar, animalid int);

## Known Bugs

_{No know bugs at the time}_

## Technologies Used

* _Java_
* _Gradle_
* _Velocity Template Engine_
* _Postgres_
* _PSQL_



### License

Copyright (c) 2016 **_Thomas Rivas_**

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
