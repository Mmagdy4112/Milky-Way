Milky-Way application will use some of the best practices in Android Development.

### Features
user should be able to :
- When opening the app, users should see a list of results including image, title, center
  and date
- When selecting one of the results, users should be presented with a details screen
  containing image, title, description, center and date

## Libraries And Design patterns:

#### MVVM :
 - is the industry-recognized software architecture pattern that overcomes all drawbacks of MVP and MVC design patterns. MVVM suggests separating the data presentation logic(Views or UI) from the core business logic part of the application.

#### LiveData :
 - is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state.

#### Hilt :
 - Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in project.
 - Hilt provides a standard way to use DI in application by providing containers for every Android class in project and managing their lifecycles automatically.

#### Kotlin Coroutines
 - Coroutines are a great way to write asynchronous code that is perfectly readable and maintainable

#### Retrofit
 - A type-safe HTTP client for Android and Java .

#### Room
 - a database library for Android that reduces boilerplate code to create and manage databases.

#### Navigation
 - Navigation component is the API and the design tool in Android Studio that makes it much easier to create and edit navigation flows throughout application.

#### Timber
 - a logger with a small, extensible API which provides utility on top of Android's normal Log class.

#### Glide
 - a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.

#### Mockito
 - Mockito help to write beautiful tests with a clean & simple API. Mockito doesn't give hangover because the tests are very readable and they produce clean verification errors