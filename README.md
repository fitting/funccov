FuncCov
-------
Automated functional test coverage analysis.

How it works
------------
This tool reads user stories and test cases from external sources and tries to relate the test cases to the user stories to come a functional test coverage.

Functional test coverage
------------------------
Functional test coverage, in my definition, is the percentage of **user functionality** that is covered by automated tests within an application.
The problem with this type of coverage is that you want to relate tests to user functionality instead of code.
The relation between a functional test and code goes through the functional requirement (e.g. user story, use case, etc.)

Functional Test <-> Functional Requirement <-> Code

This implies that you're testing human understandable business flows and user interaction, and only implicitly the code through the functional requirement link.
This lack of direct relationship between the tests and the code means that classic methods of test coverage analysis (such as code path analysis,
etc.) are not applicable to determine a basic functional test coverage.

The solution used in FuncCov
----------------------------
To start I've taken the simplest solution I could think of: relating functional tests to the requirements and calculating the coverage based on that.

First all user stories and test cases are retrieved from their respective systems.
Second all tests are related to user stories for as far as possible.
Third all user stories that have 1 or more tests are marked as "covered by tests" and coverage is calculated.

E.g. if you have 4 user stories where the 1st one has 2 tests, the 2nd and 3rd have 1 test and the 4th story has no corresponding test, a coverage of 75% will be reported.

While this is a very crude method of calculating functional test coverage, it allows for more "sophisticated" extensions such as:
- dynamically relating test cases to user stories (e.g. through text analysis)
- inclusion of code paths and coverage, which can help in determining things like dead code, legacy code, code that isn't specified in user stories, etc.
- system dependent quality analysis of tests
- quality analysis of user stories through analysis of the test cases and related code.

TODO / Wishlist
---------------
Everything :-)

License
-------
Apache License Version 2.0
http://apache.org/licenses/LICENSE-2.0.txt

Contributing
------------
Contributions are always more then welcome.
The simplest way is to fork the project and sent a pull request with your change.

There's currently no mailing list but if this project grows and if there's a demand, one may be created for discussions on the project and functional test coverage.

