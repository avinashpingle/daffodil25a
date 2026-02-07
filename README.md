<<<<<<< HEAD
# AutomationFramework (daffodil25a)

A small Selenium-based automation framework with lightweight helpers for browser management, element locators and simple utilities.

This README lists the project's packages and classes with short descriptions to help you navigate the codebase.

Checklist
- [x] Project overview
- [x] Packages and classes with brief descriptions
- [x] Quick notes on usage and where to look next

Project layout (relevant sources)
- src/main/java/com/skillio/base
- src/main/java/com/skillio/exceptions
- src/main/java/com/skillio/repo
- src/main/java/com/skillio/utils

Packages and classes

com.skillio.base
- DriverManager
  - Manages a thread-local instance of org.openqa.selenium.remote.RemoteWebDriver. Use `setDriver(...)` to store the driver for the current thread, `getDriver()` to retrieve it, and `unload()` to remove it when finished.
- Keyword
  - A small collection of high-level Selenium actions (openBrowser, enterText, clickOn, getText, etc.). It also maps common locator types to Selenium's `By`. `openBrowser(String)` constructs a browser driver (Chrome, Firefox, Safari) and registers it with `DriverManager`.

com.skillio.exceptions
- InvalidBrowserError
  - Custom Error thrown when an unsupported browser name is provided to the framework.
- InvalidLocatorError
  - Custom Error thrown when an unsupported locator type is used by the Keyword utilities.

com.skillio.repo
- Locator (interface)
  - A central place for UI locators as String constants. Locators use a convention `"<locatorType>##<locatorValue>"` (for example: `"xpath##//input[@name=\"username\"]"`).

com.skillio.utils
- PropHandler
  - Simple helper that loads a Java `Properties` file and returns the value for a given key.
- WaitFor
  - Wrapper around `WebDriverWait` and common ExpectedConditions to make explicit waits easier to use. (Note: review this class for incomplete methods or typos before using in production.)

Quick usage notes
- Driver lifecycle: Create a WebDriver (e.g. via `Keyword.openBrowser`) or manually, then call `DriverManager.setDriver(driver)` for the current thread. Always call `DriverManager.unload()` after tests finish to avoid leaks.
- Locators: Use constants from `com.skillio.repo.Locator` or the `locatorType##locatorValue` format in `Keyword` methods that accept a single locator String.
- Properties: Use `PropHandler#get(key, filePath)` to fetch configuration values from property files.

Where to look next
- Tests and examples (if any) under `src/test` or test-output folders to see the framework wired into actual test flows.
- `com.skillio/utils/WaitFor.java` — contains a couple of incomplete lines and should be reviewed/fixed before relying on the helper.

Contact / Maintainers
- Check project `pom.xml` and repository metadata for maintainer contact details.

License
- See project root for licensing information (if present).
=======
# daffodil25a
>>>>>>> ed33aef4b96ad0f390d38dfde0807c2bed5d7b8f
