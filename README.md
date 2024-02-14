## Tutorial 2

### Reflection 2
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