## Tutorial 4

### Reflection

1. In my opinion, the TDD procedure is highly beneficial as it can enhance correctness, maintainability, and workflow efficiency. Initially, I struggled with designing tests before starting to develop the actual class, but then I realized that TDD facilitates the creation of safer code and simplifies the refactoring process because changes can be tested immediately. Additionally, it is important to develop tests that evaluate interactions among features to further ensure code accuracy. For example, by testing the creation, updating, and deletion of multiple products simultaneously. This will enhance security and ensure that all components interact properly.

2. In my opinion, the tests I have created adhere to the F.I.R.S.T principle because I have designed efficient tests to evaluate the code comprehensively. Each test performs assertion checks to verify the accuracy of the output and is designed to be repeatable, allowing consistent testing whenever there are modifications to the code. My tests also cover all the happy paths and unhappy paths, as well as all possible errors and outcomes.

## Tutorial 3

### Reflection
1. I've applied several principles such as:
   1. **Single Responsibility Principle**: Moved the CarController class from ProductController.java file to its own file and removed the "extends ProductController" because CarController should not inherit ProductController's mapping methods.
   2. **Liskov Substitution Principle**: Currently, there are no classes that use the same method and the same return type. So, this project doesn't violate this principle.
   3. **Interface Segregation Principle**: Because we separate CarService and ProductService, services that implement them only require one of them and not both. This makes each class that implements their respective service implement it correctly instead of just returning null or throwing an unimplemented exception.
   4. **Dependency Inversion Principle**:
      In this project, the dependencies within the product controller and car controller classes are focused on interfaces rather than concrete implementations. Instead of relying directly on specific implementations like CarServiceImpl and ProductServiceImpl, these classes are designed to depend on interfaces such as Car Service and Product Service.

2. By implementing SOLID principles, our codebase will be more structured, maintainable, clean, and readable. For example, imagine a situation where a new bug has just been discovered in the codebase. If we don't adhere to the Single Responsibility Principle, we are likely to spend a lot of time just trying to figure out which class the bug originated from because our classes are tightly coupled to each other. However, if we apply SRP, we will be able to quickly identify the source of the bug as we have structured our classes in such a way that each class has only one responsibility.

3. If we do not adhere to SOLID principles, our codebase will be more difficult to maintain. One example is as mentioned above. For another example, if we do not apply the Interface Segregation Principle, people who want to use our interface will be burdened because now they have to implement methods that they actually do not need.

## Tutorial 2

### Reflection
1. There are several code issues that I've fixed such as:
   1. "The instance method name 'HomePage' doesn't match '[a-z][a-zA-Z0-9]*'" \
      **Solution**: rename to homePage
   2. "Unnecessary ‘public’ Modifier" \
      **Solution**: Change to either 'private' or 'protected'
   3. "Use Constructor Injection Instead" \
      **Solution**: Change from `@Autowired` to a Constructor


2. In my current setup, I've established efficient Continuous Integration (CI). Each push or pull request activates my CI workflow, providing a rapid evaluation of my code with tests to identify any issues. It ensures the continued compatibility and functionality of the codebase. For Continuous Deployment (CD), I rely on Koyeb, which automates deployment following pulls, pushes, or merges from the repository.

## Tutorial 1

### Reflection 1
I've applied several clean code principles and secure coding practices such as:
1. **Descriptive Naming** \
   Classes, methods, and variables are named descriptively, which enhances readability and understanding of the code (e.g., `ProductController`, `createProductPage`, `productData`).
2. **Encapsulation** \
   Classes are properly encapsulated, with methods and variables appropriately scoped (e.g., `ProductRepository` encapsulates data access operations for products).
3. **Dependency Injection** \
   Dependency Injection is utilized to manage dependencies between classes, improving modularity and testability (e.g., `ProductService` is injected into `ProductController` and `ProductServiceImpl`).
4. **Exception Handling** \
   Proper exception handling is implemented, with appropriate exceptions thrown and caught where necessary (e.g., `NoSuchElementException` is thrown in `ProductRepository`).

Potential improvements:
1. **Error Handling and Validation**:
   - Implement input validation to ensure that user inputs are valid before processing (e.g., validating product names and quantities).
   - Enhance error handling to provide meaningful error messages to users when operations fail (e.g., failed product creation or deletion).

### Reflection 2
1. After writing unit tests, I feel more confident about the code I've written. There are no specific rule about the number of unit tests in a class, but typically we want to have enough tests to cover all the possible scenarios and corner cases. To ensure that our unit tests are enough to verify our program, it's essential to have a comprehensive test suite that covers various scenarios, including typical use cases, corner cases, and error conditions. Achieving 100% code coverage does not guarantee that my code has no bugs or errors. It simply means that every line of code has been executed at least once during the tests. There could still be logical errors, corner cases, or integration issues that are not caught by the tests, even with full coverage.
2. The cleanliness of the new functional test suite will depend on how it's structured and implemented. However, if it follows a similar pattern to the existing test suite, it may reduce code quality due to code duplication and lack of maintainability.
Potential clean code issues:
   1. **Code Duplication**: If the new test suite follows the same setup procedures and instance variables as the existing one, there may be significant code duplication. This can make the test suite harder to maintain and update. \
      **Improvement**: Consider refactoring common setup procedures and instance variables into reusable methods or a base test class that can be extended by both test suites. This will reduce duplication and improve maintainability.
   2. **Hardcoded Locators**:  If the new test suite uses hardcoded locators (e.g., \`**By.id("nameInput")**\`, \`**By.xpath("//button[@type='submit']")**`), it can make the tests brittle and prone to failure if the UI changes. \
      **Improvement**: Extract locators into variables/constants and provide meaningful names. If possible, use more stable locators like CSS selectors instead of XPath. This will improve the readability and maintainability of the tests.
   3. **Test Isolation**: If the new test suite doesn't properly isolate tests from each other, it can lead to dependencies between tests and non-deterministic test results. \
      **Improvement**: Ensure that each test method is independent and doesn't rely on the state or outcome of other tests. Use setup and teardown methods to create a clean test environment for each test.